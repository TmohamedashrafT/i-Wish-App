/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author HP
 */
public class RechargeDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextField creditCardField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField pointField;
    @FXML
    private Button addBtn;
    @FXML
    private Button cancelBtn;

    @FXML
    private void handleAddAction(ActionEvent event) {
    }

    @FXML
    private void handleCancelAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
