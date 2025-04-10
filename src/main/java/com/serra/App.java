package com.serra;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase <code>App</code> es la aplicación principal que extiende la clase <code>Application</code> de JavaFX.
 * Esta clase es responsable de iniciar la aplicación, configurar la ventana principal (Stage), 
 * establecer el icono de la ventana, y gestionar las escenas mediante el <code>SceneManager</code>.
 */
public class App extends Application {

    /**
     * Método que se ejecuta cuando la aplicación JavaFX inicia.
     * 
     * Este método configura el título de la ventana, establece el icono de la ventana,
     * inicializa el <code>SceneManager</code>, configura las escenas disponibles y carga la escena principal.
     * 
     * @param stage el <code>Stage</code> principal de la aplicación, que representa la ventana.
     * @throws IOException si ocurre un error al cargar los recursos o las vistas.
     */
    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException {
        // Establece el título de la ventana
        stage.setTitle("Grid y Listas");
        
        // Establece el icono de la ventana
        stage.getIcons().add(new Image(App.class.getResource("images/logo.png").toExternalForm()));
        
        // Obtiene la instancia del SceneManager
        SceneManager sm = SceneManager.getInstance();
        
        // Inicializa el SceneManager con el stage y una ruta de estilos
        sm.init(stage, "style");
        
        // Configura las escenas con identificadores
        sm.setScene(SceneID.ADD, "AddView");
        sm.setScene(SceneID.LIST, "ListView");
        sm.setScene(SceneID.FRAME, "FrameView");
        
        // Carga la escena principal
        sm.loadScene(SceneID.FRAME);
    }

    public static void main(String[] args) {
        launch();
    }
}
