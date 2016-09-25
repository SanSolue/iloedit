/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit.exception;

/**
 * Base exception for all widget related exceptional situations
 *
 * @author Samith Sandanayake
 * @since 1.0
 */
public class WidgetException extends Exception {

    /**
     * Construct widget exception
     */
    public WidgetException() {
        // default constructor
    }

    /**
     * Construct widget exception with a custom message
     *
     * @param message custom message
     */
    public WidgetException(String message) {
        super(message);
    }

    /**
     * Construct widget exception with a custom message and a cause
     *
     * @param message custom message
     * @param cause cause of the exception
     */
    public WidgetException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct widget exception with a cause
     *
     * @param cause cause of the exception
     */
    public WidgetException(Throwable cause) {
        super(cause);
    }
}
