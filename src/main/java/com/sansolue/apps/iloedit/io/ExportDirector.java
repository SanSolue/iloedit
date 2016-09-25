/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit.io;

import com.sansolue.apps.iloedit.exception.IEIOException;

/**
 * Export director which direct the builder {@link TextConverter} and construct the export image
 *
 * @author Samith Sandanayake
 * @since 1.0
 */
public class ExportDirector {

    private AbstractWriter writer;

    /**
     * Construct an export director with a writer
     *
     * @param writer writer to export directed content into
     */
    public ExportDirector(AbstractWriter writer) {
        this.writer = writer;
    }

    /**
     * Direct export
     *
     * @param content content to export
     * @throws IEIOException
     */
    public synchronized void direct(String content) throws IEIOException {

        String[] lines = content.split("\\n");
        for (String line : lines) {
            handleLine(line);
            writer.addNewLine();
        }
    }

    private void handleLine(String line) throws IEIOException {
        if (line.matches("^### Chapter: (\\w+)$")) {

        } else if (line.matches("^### Section: (\\W+)$")) {

        } else {
            handleGenericLine(line);
        }
    }

    private void handleGenericLine(String line) throws IEIOException {
        for (char c : line.toCharArray()) {
            if (c == ' ') {
                writer.addSpace();
            } else {
                writer.addLetter(c);
            }
        }
    }
}
