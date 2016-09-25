
/*
 * Copyright (c) 2016 by Samith Sandanayake.
 *
 * This software is licensed under Apache License 2
 */

package com.sansolue.apps.iloedit;

import com.sansolue.apps.iloedit.widget.MainWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Application class for IloEdit
 *
 * @author Samith Sandanayake
 * @since 1.0
 * @see javafx.application.Application
 * @see com.sansolue.apps.iloedit.widget.MainWindow
 */
public class IloEdit extends Application {

    public static final String APPLICATION_TITLE = "IloEdit";
    public static final int APPLICATION_DEFAULT_WIDTH = 1024;
    public static final int APPLICATION_DEFAULT_HEIGHT = 768;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new MainWindow(primaryStage), APPLICATION_DEFAULT_WIDTH, APPLICATION_DEFAULT_HEIGHT);
        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Application entry point
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
