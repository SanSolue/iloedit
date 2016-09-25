/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit.io;

import com.sansolue.apps.iloedit.exception.IEIOException;

/**
 * Builder interface to text content conversion
 *
 * @author Samith Sandanayake
 * @since 1.0
 * @see AbstractWriter
 * @see TxtConverter
 * @see HTMLConverter
 * @see ExportDirector
 */
public interface TextConverter {

    /**
     * Add new line
     *
     * @return content to new line
     * @throws IEIOException
     */
    String addNewLine() throws IEIOException;

    /**
     * Add spece
     *
     * @return content for space
     * @throws IEIOException
     */
    String addSpace() throws IEIOException;

    /**
     * add letter
     * @param letter letter to be added
     * @return content for added latter
     * @throws IEIOException
     */
    String addLetter(char letter) throws IEIOException;

    /**
     * Add chapter
     * @param name name of the chapter
     * @return content for added chapter
     * @throws IEIOException
     */
    String addChapter(String name) throws IEIOException;

    /**
     * Add section
     * @param name name of the section
     * @return content for added section
     * @throws IEIOException
     */
    String addSection(String name) throws IEIOException;
}
