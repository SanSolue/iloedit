/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit.io;

import com.sansolue.apps.iloedit.constants.IEIOErrorMessages;
import com.sansolue.apps.iloedit.exception.IEIOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URI;
import java.nio.file.*;

/**
 * Singleton IO Manager to handle editors file save
 *
 * @author Samith Sandanayake
 * @since 1.0
 */
public class IOManager {

    private static final IOManager instance = new IOManager();

    private static final Logger LOGGER = LoggerFactory.getLogger(IOManager.class);

    private Path saveFile = null;

    private IOManager() {
        // singleton constructor
    }

    /**
     * Retrieve singleton instance
     *
     * @return IOManager singleton instance
     */
    public static IOManager getInstance() {
        return instance;
    }

    /**
     * Reset the file when a new file is requested by the user
     *
     */
    public synchronized void newFile() {
        saveFile = null;
    }

    /**
     * Save text editor content
     *
     * @param content content of the editor
     * @return true if file is available, else false
     */
    public synchronized boolean save(String content) throws IEIOException {

        if (saveFile==null) {
            return false;
        }

        try {
            Files.write(saveFile,(content!=null?content:"").getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            LOGGER.error("Failed to write content to the file", e);
            throw new IEIOException(IEIOErrorMessages.ERR_FAILED_TO_WRITE_CONTENT_TO_THE_FILE, e);
        }

        return true;
    }

    /**
     * Save editors content as another file
     *
     * @param content content to be saved
     * @param file new file location
     * @throws IEIOException
     */
    public synchronized void saveAs(String content, URI file) throws IEIOException {
        saveFile = Paths.get(file);
        save(content);
    }
}
