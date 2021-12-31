package com.drone.manager.exception;

public class SmartCardNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new <code>EntityMissingException</code> exception with
     * <code>null</code> as its detail message.
     */
    public SmartCardNotFoundException() {
        super();
    }

    /**
     * Constructs a new <code>EntityMissingException</code> exception with the
     * specified detail message.
     *
     * @param message
     *            the detail message.
     */
    public SmartCardNotFoundException(String message) {
        super(message);
    }

}