package com.google.android.libraries.backup;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Static utility methods returning {@link BackupKeyPredicate} instances.
 */
public class BackupKeyPredicates {

    /**
     * Returns a predicate that determines whether a key is a member of the given collection. Changes
     * to the given collection will change the returned predicate.
     */
    public static BackupKeyPredicate in(final Collection<? extends String> collection) {
        if (collection == null) {
            throw new NullPointerException("Null collection given.");
        }
        return collection::contains;
    }


    /**
     * Returns a predicate that determines whether a key passes any of the given predicates. Each
     * predicate is evaluated in the order given, and the evaluation process stops as soon as an
     * accepting predicate is found. Changes to the given iterable will not change the returned
     * predicate. The returned predicate returns {@code false} for any key if the given iterable is
     * empty.
     */
    public static BackupKeyPredicate or(Iterable<BackupKeyPredicate> predicates) {
        final List<BackupKeyPredicate> copiedPredicates = new ArrayList<>();
        for (BackupKeyPredicate predicate : predicates) {
            copiedPredicates.add(predicate);
        }
        return orDefensivelyCopied(new ArrayList<>(copiedPredicates));
    }

    /**
     * Returns a predicate that determines whether a key passes any of the given predicates. Each
     * predicate is evaluated in the order given, and the evaluation process stops as soon as an
     * accepting predicate is found. The returned predicate returns {@code false} for any key if no
     * there are no given predicates.
     */
    public static BackupKeyPredicate or(BackupKeyPredicate... predicates) {
        return orDefensivelyCopied(Arrays.asList(predicates));
    }

    private static BackupKeyPredicate orDefensivelyCopied(
            final Iterable<BackupKeyPredicate> predicates) {
        return key -> {
            for (BackupKeyPredicate predicate : predicates) {
                if (predicate.shouldBeBackedUp(key)) {
                    return true;
                }
            }
            return false;
        };
    }

    /**
     * Returns a predicate that returns true for any key.
     */
    public static BackupKeyPredicate alwaysTrue() {
        return key -> true;
    }
}
