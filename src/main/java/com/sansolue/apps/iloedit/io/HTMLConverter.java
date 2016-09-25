/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit.io;

import com.sansolue.apps.iloedit.exception.IEIOException;

/**
 * Text to HTML converter
 *
 * @author Samith Sandanayake
 * @since 1.0
 */
public class HTMLConverter implements TextConverter {

    private boolean inChapter = false;
    private boolean inSection = false;

    @Override
    public String addNewLine() throws IEIOException {
        return "\n<br>\n";
    }

    @Override
    public String addSpace() throws IEIOException {
        return "&nbsp;";
    }

    @Override
    public String addLetter(char letter) throws IEIOException {
        return String.valueOf(letter);
    }

    @Override
    public String addChapter(String name) throws IEIOException {
        StringBuilder builder = new StringBuilder();
        if (inSection) {
            builder.append("\n</p>\n");
            inSection = false;
        }
        if (inChapter) {
            builder.append("\n</div>\n");
        }
        inChapter = true;
        builder.append("\n<div class=\"chapter\">\n<h3>");
        builder.append(name);
        builder.append("</h3>\n\n");
        return builder.toString();
    }

    @Override
    public String addSection(String name) throws IEIOException {
        StringBuilder builder = new StringBuilder();
        if (inSection) {
            builder.append("\n</p>\n");
        }
        inSection = true;
        builder.append("\n<p>");
        builder.append("<!-- ");
        builder.append("Section: ");
        builder.append(name);
        builder.append(" -->\n");
        return builder.toString();
    }
}
