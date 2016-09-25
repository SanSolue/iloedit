/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit.io;

import com.sansolue.apps.iloedit.exception.IEIOException;

/**
 * Abstract writer to write export content to a sync
 *
 * @author Samith Sandanayake
 * @since 1.0
 */
public abstract class AbstractWriter {

    private TextConverter converter;

    /**
     * Abstract constructor
     *
     * @param converter  text converter
     */
    public AbstractWriter(TextConverter converter) {
        this.converter = converter;
    }

    public TextConverter getConverter() {
        return converter;
    }

    public void setConverter(TextConverter converter) throws IEIOException {
        if (converter==null) {
            throw new IEIOException("converter cannot be null");
        }
        this.converter = converter;
    }

    public void addNewLine() throws IEIOException{write(converter.addNewLine());}
    public void addSpace() throws IEIOException{write(converter.addSpace());}
    public void addLetter(char letter) throws IEIOException{write(converter.addLetter(letter));}
    public void addChapter(String name) throws IEIOException{write(converter.addChapter(name));}
    public void addSection(String name) throws IEIOException{write(converter.addSection(name));}

    protected abstract void write(String content) throws IEIOException;
}
