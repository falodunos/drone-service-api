package com.drone.manager.exception;

public class DuplicateUniqueIdException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new <code>DuplicateUniqueIdException</code> exception with
     * <code>null</code> as its detail message.
     */
    public DuplicateUniqueIdException() {
        super();
    }

    /**
     * Constructs a new <code>DuplicateUniqueIdException</code> exception with the
     * specified detail message.
     *
     * @param message
     *            the detail message.
     */
    public DuplicateUniqueIdException(String message) {
        super(message);
    }
}
