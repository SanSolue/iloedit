/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit.io;

import com.sansolue.apps.iloedit.exception.IEIOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * File based implementation for {@link AbstractWriter}
 *
 * @author Samith Sandanayake
 * @since 1.0
 */
public class FileWriter extends AbstractWriter  {

    private final FileOutputStream fileOutputStream;

    /**
     * Construct a file writer with a converter and a file
     *
     * @param converter converter to use to convert content into expected output type
     * @param file file to write converted content to
     * @throws IEIOException
     */
    public FileWriter(TextConverter converter, File file) throws IEIOException {
        super(converter);
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new IEIOException(e);
        }
    }

    @Override
    protected void write(String content) throws IEIOException {
        try {
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            throw new IEIOException(e);
        }
    }
}
