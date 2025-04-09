package com.serra.controllers;

import com.serra.SceneID;
import com.serra.SceneManager;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class FrameViewController {
    @FXML
    AnchorPane listFrame;

    @FXML
    AnchorPane addFrame;

    @FXML
    public void initialize(){
        SceneManager sm = SceneManager.getInstance();

        Scene addScene = sm.getScene(SceneID.ADD);
        AnchorPane.setBottomAnchor(addScene.getRoot(), 0.0);
        AnchorPane.setTopAnchor(addScene.getRoot(), 0.0);
        AnchorPane.setLeftAnchor(addScene.getRoot(), 0.0);
        AnchorPane.setRightAnchor(addScene.getRoot(), 0.0);
        addFrame.getChildren().setAll(addScene.getRoot());

        Scene listScene = sm.getScene(SceneID.LIST);
        AnchorPane.setBottomAnchor(listScene.getRoot(), 0.0);
        AnchorPane.setTopAnchor(listScene.getRoot(), 0.0);
        AnchorPane.setLeftAnchor(listScene.getRoot(), 0.0);
        AnchorPane.setRightAnchor(listScene.getRoot(), 0.0);
        listFrame.getChildren().setAll(listScene.getRoot());
    }
}
