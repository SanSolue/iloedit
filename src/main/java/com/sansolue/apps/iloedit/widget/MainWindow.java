
/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit.widget;


import com.sansolue.apps.iloedit.constants.WidgetErrorMessages;
import com.sansolue.apps.iloedit.exception.IEIOException;
import com.sansolue.apps.iloedit.exception.WidgetException;
import com.sansolue.apps.iloedit.io.IOManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Main window widget
 *
 * @author Samith Sandanayake
 * @since 1.0
 */
public class MainWindow extends BorderPane {

    private static final String UI_FILE = "/fxml/mainwindow.fxml";

    private static final Logger LOGGER = LoggerFactory.getLogger(MainWindow.class);

    @FXML
    private Button newButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button saveAsButton;

    @FXML
    private Button previewButton;

    @FXML
    private Button settingsButton;

    @FXML
    private TextArea editor;

    private Window window;

    /**
     * Construct main window
     */
    public MainWindow(Window parentWindow) throws WidgetException {
        this.window = parentWindow;
        setupUI();
    }

    private void setupUI() throws WidgetException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(UI_FILE));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            LOGGER.error("Cannot load main window ui", e);
            throw new WidgetException(WidgetErrorMessages.ERR_CANNOT_LOAD_UI, e);
        }
    }

    @FXML
    private void newAction(ActionEvent event) {
        if (editor.getText().isEmpty()) {
            IOManager.getInstance().newFile();
        } else {
            //TODO: prompt if need to save exiting content
        }
    }

    @FXML
    private void saveAction(ActionEvent event) {
        try {
            if (!IOManager.getInstance().save(editor.getText())) {
                saveAsAction(event);
            }
        } catch (IEIOException e) {
            LOGGER.error("Cannot save file", e);
            //TODO: show an error message here to the user
        }
    }

    @FXML
    private void saveAsAction(ActionEvent event) {
        try {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Save as");
            chooser.setInitialFileName("untitled.txt");
            chooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Text file", "txt"));
            File file = chooser.showSaveDialog(window);
            IOManager.getInstance().saveAs(editor.getText(), file.toURI());
        } catch (IEIOException e) {
            LOGGER.error("Cannot save file", e);
            //TODO: show an error message here to the user
        }
    }

    @FXML
    private void previewAction(ActionEvent event) {

    }

    @FXML
    private void settingsAction(ActionEvent event) {

    }
}
