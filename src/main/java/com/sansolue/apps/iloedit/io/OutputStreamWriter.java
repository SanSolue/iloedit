/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit.io;

import com.sansolue.apps.iloedit.constants.IEIOErrorMessages;
import com.sansolue.apps.iloedit.exception.IEIOException;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Output stream based implementation for {@link AbstractWriter}
 *
 * @author Samith Sandanayake
 * @since 1.0
 */
public class OutputStreamWriter extends AbstractWriter {

    private OutputStream os;

    /**
     * Construct an output stream writer with a converter and an output stream
     *
     * @param converter convert to use for converting content to desired output format
     * @param os output stream to write converted text
     * @throws IEIOException
     */
    public OutputStreamWriter(TextConverter converter, OutputStream os) throws IEIOException {
        super(converter);
        if (os == null) {
            throw new IEIOException(IEIOErrorMessages.ERR_OUTPUT_STREAM_CANNOT_BE_NULL);
        }
        this.os = os;
    }

    @Override
    protected void write(String content) throws IEIOException {
        try {
            os.write(content.getBytes());
        } catch (IOException e) {
            throw new IEIOException(e);
        }
    }
}
