/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit.io;

import com.sansolue.apps.iloedit.exception.IEIOException;


/**
 * Source text to .txt converter
 *
 * @author Samith Sandanayake
 * @since 1.0
 */
public class TxtConverter implements TextConverter {


    @Override
    public String addNewLine() throws IEIOException {
        return "\n";
    }

    @Override
    public String addSpace() throws IEIOException {
        return " ";
    }

    @Override
    public String addLetter(char letter) throws IEIOException {
        return String.valueOf(letter);
    }

    @Override
    public String addChapter(String name) throws IEIOException {
        // not supported
        return String.format("%n%n%n%n -------------------------- Chapter %s -------------------------------%n", name);
    }

    @Override
    public String addSection(String name) throws IEIOException {
        return "\n\n\n";
    }
}
