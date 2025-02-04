/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddFriendDocumentController implements Initializable {

    @FXML
    private TableView<Friend> addTable;
    @FXML
    private TableColumn<Friend, String> nameColumn;
    @FXML
    private TableColumn<Friend, String> addColumn;
    @FXML
    private TextField searchField;
    @FXML
    private Button searchBtn;

    @FXML
    private void handleBackAction(ActionEvent event) {
    }
   public static class Friend {

        private String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Set up button column
        addColumn.setCellFactory(param -> new TableCell<AddFriendDocumentController.Friend, String>() {
            private final Button btn = new Button("Add Friend");
            private final Button btn2 = new Button("Remove");

            {
                btn.setOnAction((ActionEvent event) -> {
                    AddFriendDocumentController.Friend w = getTableView().getItems().get(getIndex());
                });
                btn2.setOnAction((ActionEvent event) -> {
                    AddFriendDocumentController.Friend w = getTableView().getItems().get(getIndex());
                });
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox hbox = new HBox(10, btn, btn2);  // Add TextField & Button inside HBox
                    setGraphic(hbox);
                }
            }
        });

        // Sample data
        ObservableList<AddFriendDocumentController.Friend> friendList  = FXCollections.observableArrayList(
                new AddFriendDocumentController.Friend("Somaya Ahmed"),
                new AddFriendDocumentController.Friend("menna"),
                new AddFriendDocumentController.Friend("Mohamed Ashraf"),
                new AddFriendDocumentController.Friend("omar")
        );

        addTable.setItems(friendList);
    }    
    
}
