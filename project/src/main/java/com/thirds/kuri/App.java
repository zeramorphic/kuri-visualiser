/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.thirds.kuri;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class App {
    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.vSyncEnabled = true;
        config.foregroundFPS = 60;
        config.backgroundFPS = 10;
        config.width = 800;
        config.height = 600;
        config.useHDPI = true;
        config.samples = 4;

        config.title = "Kuri Visualiser";

        new LwjglApplication(new KuriVisualiser(), config);
    }
}