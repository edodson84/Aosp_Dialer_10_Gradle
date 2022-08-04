
package com.fissy.dialer.commandline;

import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_CommandSupplier extends CommandSupplier {

  private final ImmutableMap<String, Command> commands;

  private AutoValue_CommandSupplier(
      ImmutableMap<String, Command> commands) {
    this.commands = commands;
  }

  @Override
  public ImmutableMap<String, Command> commands() {
    return commands;
  }

  @Override
  public String toString() {
    return "CommandSupplier{"
        + "commands=" + commands
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CommandSupplier) {
      CommandSupplier that = (CommandSupplier) o;
      return (this.commands.equals(that.commands()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.commands.hashCode();
    return h;
  }

  static final class Builder extends CommandSupplier.Builder {
    private ImmutableMap.Builder<String, Command> commandsBuilder$;
    private ImmutableMap<String, Command> commands;
    Builder() {
    }
    @Override
    ImmutableMap.Builder<String, Command> commandsBuilder() {
      if (commandsBuilder$ == null) {
        commandsBuilder$ = ImmutableMap.builder();
      }
      return commandsBuilder$;
    }
    @Override
    public CommandSupplier build() {
      if (commandsBuilder$ != null) {
        this.commands = commandsBuilder$.build();
      } else if (this.commands == null) {
        this.commands = ImmutableMap.of();
      }
      return new AutoValue_CommandSupplier(
          this.commands);
    }
  }

}
