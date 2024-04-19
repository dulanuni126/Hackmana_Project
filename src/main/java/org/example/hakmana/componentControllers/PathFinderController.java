package org.example.hakmana.componentControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PathFinderController extends VBox implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static List<String> sceneList = new ArrayList<>();
    private String bckBtnScene;
    private static byte sceneListCounter=-1;
    private static boolean continuousPressed=false;
    @FXML
    public HBox searchBar;

    private boolean searchBarVisible;
    @FXML
    private Button backBttn;
    @FXML
    private Label pathTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public boolean isSearchBarVisible() {
        return searchBarVisible;
    }

    public void setSearchBarVisible(boolean searchBarVisible) {
        this.searchBarVisible = searchBarVisible;
        searchBar.setVisible(this.searchBarVisible);
    }

    public PathFinderController() {
        super();
        String filePath = "src/main/resources/org/example/hakmana/Component/PathFinder.fxml";
        FXMLLoader fxmlPathLoader = null;
        try {
            fxmlPathLoader = new FXMLLoader(new File(filePath).toURI().toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        fxmlPathLoader.setController(this);
        fxmlPathLoader.setRoot(this);
        try{
            fxmlPathLoader.load();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public Label getPathTxt() {
        return pathTxt;
    }

    public void setPathTxt(String pathTxt) {
        this.pathTxt.setText(pathTxt);
    }

    public List<String> getSceneList() {
        return sceneList;
    }

    public void setBckBtnScene(String bckBtnScene) {
        this.bckBtnScene = bckBtnScene;
        sceneList.add(this.bckBtnScene);
        sceneListCounter++;
        continuousPressed=false;
    }
    public void goBack(ActionEvent event) throws IOException {
        String listScenename = "src/main/resources/org/example/hakmana/Scene/dashboard.fxml";
        if(!sceneList.isEmpty()) {
            System.out.println(sceneList);
            //To remove current scene from the list.
            //Because current scene is also added to the list
            if (continuousPressed == false) {
                sceneList.removeLast();
                continuousPressed = true;
            }
            System.out.println(sceneList);
            listScenename = sceneList.getLast();
            sceneList.removeLast();
            sceneListCounter--;

        }else{
            System.out.println("list is empty");
        }

        try {
            Parent sceneRoot = FXMLLoader.load(new File(listScenename).toURI().toURL());
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(sceneRoot);
            stage.setScene(scene);
            stage.show();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
