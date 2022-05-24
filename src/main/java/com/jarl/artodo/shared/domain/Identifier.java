package com.jarl.artodo.shared.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class Identifier implements Serializable {
    final protected UUID value;

    public Identifier(UUID value) {
        this.value = value;
    }

    protected Identifier() {
        this.value = null;
    }

    public UUID value() {
        return value;
    }

    @Override
    public String toString() {
        assert value != null;
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
