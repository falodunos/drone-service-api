package com.drone.manager.exception;
public class MissingEntityException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new <code>EntityMissingException</code> exception with
     * <code>null</code> as its detail message.
     */
    public MissingEntityException() {
        super();
    }

    /**
     * Constructs a new <code>EntityMissingException</code> exception with the
     * specified detail message.
     *
     * @param message
     *            the detail message.
     */
    public MissingEntityException(String message) {
        super(message);
    }
}
