package br.gigliarly;

import java.util.Objects;

public class CampoFixo {
    private final int value;
    private final int line;
    private final int column;

    public CampoFixo(int value, int line, int column) {
        this.value = value;
        this.line = line;
        this.column = column;
    }

    public int value() {
        return this.value;
    }

    public int line() {
        return this.line;
    }

    public int column() {
        return this.column;
    }

    public boolean equals(int line, int column) {
        return this.line == line && this.column == column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, column);
    }
}
