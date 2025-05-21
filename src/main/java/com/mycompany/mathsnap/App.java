package com.mycompany.mathsnap;

import java.io.IOException;
import java.util.function.Consumer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Font font = Font.loadFont(getClass().getResourceAsStream("/com/mycompany/mathsnap/font/comicsans.ttf"), 36);
        System.out.println("Loaded font family: " + (font != null ? font.getFamily() : "Font not loaded"));
        scene = new Scene(loadFXML("Welcome"), 480, 640);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void setRootWithData(String fxml, Consumer<Object> controllerSetup) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
            Parent root = loader.load();
            if (controllerSetup != null) {
                controllerSetup.accept(loader.getController());
            }
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}