
package com.fissy.dialer.commandline;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Arguments extends Arguments {

  private final ImmutableMap<String, String> flags;
  private final ImmutableList<String> positionals;

  AutoValue_Arguments(
      ImmutableMap<String, String> flags,
      ImmutableList<String> positionals) {
    if (flags == null) {
      throw new NullPointerException("Null flags");
    }
    this.flags = flags;
    if (positionals == null) {
      throw new NullPointerException("Null positionals");
    }
    this.positionals = positionals;
  }

  @Override
  public ImmutableMap<String, String> getFlags() {
    return flags;
  }

  @Override
  public ImmutableList<String> getPositionals() {
    return positionals;
  }

  @Override
  public String toString() {
    return "Arguments{"
        + "flags=" + flags + ", "
        + "positionals=" + positionals
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Arguments) {
      Arguments that = (Arguments) o;
      return (this.flags.equals(that.getFlags()))
           && (this.positionals.equals(that.getPositionals()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.flags.hashCode();
    h *= 1000003;
    h ^= this.positionals.hashCode();
    return h;
  }

}
