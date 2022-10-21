/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.fissy.dialer.commandline.impl;

import android.content.Context;

import androidx.annotation.NonNull;

import com.fissy.dialer.commandline.Arguments;
import com.fissy.dialer.commandline.Command;
import com.fissy.dialer.commandline.CommandLineComponent;
import com.fissy.dialer.inject.ApplicationContext;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.Locale;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

/**
 * List available commands
 */
public class Help implements Command {

    private final Context context;

    @Inject
    Help(@ApplicationContext Context context) {
        this.context = context;
    }

    private static String runOrThrow(Command command) throws IllegalCommandLineArgumentException {
        try {
            return command.run(Arguments.EMPTY).get();
        } catch (InterruptedException e) {
            Thread.interrupted();
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    @Override
    public String getShortDescription() {
        return "Print this message";
    }

    @NonNull
    @Override
    public String getUsage() {
        return "help";
    }

    @Override
    public ListenableFuture<String> run(Arguments args) throws IllegalCommandLineArgumentException {
        boolean showHidden = args.getFlags().containsKey("showHidden");

        StringBuilder stringBuilder = new StringBuilder();
        ImmutableMap<String, Command> commands =
                CommandLineComponent.get(context).commandSupplier().get();
        stringBuilder
                .append(runOrThrow(Objects.requireNonNull(commands.get("version"))))
                .append("\n")
                .append("\n")
                .append("usage: <command> [args...]\n")
                .append("\n")
                .append("<command>\n");

        for (Entry<String, Command> entry : commands.entrySet()) {
            String description = entry.getValue().getShortDescription();
            if (!showHidden && description.startsWith("@hide ")) {
                continue;
            }
            stringBuilder.append(String.format(Locale.US, "  %20s  %s\n", entry.getKey(), description));
        }

        return Futures.immediateFuture(stringBuilder.toString());
    }
}
