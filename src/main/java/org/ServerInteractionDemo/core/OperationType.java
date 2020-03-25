package org.ServerInteractionDemo.core;

public enum OperationType {
    ADD("add"),
    SUBTRACT("subtract"),
    MULTIPLY("multiply"),
    DIVIDE("divide");

    private final String value;

    OperationType(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
