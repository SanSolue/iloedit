/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit.exception;

/**
 * IloEdit io section exception
 *
 * @author Samith Sandanayake
 * @since 1.0
 */
public class IEIOException extends Exception {


    /**
     * Construct ieio exception
     */
    public IEIOException() {
        // default constructor
    }

    /**
     * Construct ieio exception with a custom message
     *
     * @param message custom message
     */
    public IEIOException(String message) {
        super(message);
    }

    /**
     * Construct ieio exception with a custom message and a cause
     *
     * @param message custom message
     * @param cause cause of the exception
     */
    public IEIOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct ieio exception with a cause
     *
     * @param cause cause of the exception
     */
    public IEIOException(Throwable cause) {
        super(cause);
    }
}
