package org.ServerInteractionDemo.api.exceptions;

public class InvalidOperandException extends RuntimeException {

    private static final long serialVersionUID = -311110184052856839L;

    public InvalidOperandException(final String message) {
        super(message);
    }
}
