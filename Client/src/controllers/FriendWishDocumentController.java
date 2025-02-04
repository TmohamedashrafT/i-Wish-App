package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FriendWishDocumentController implements Initializable {

    @FXML
    private Label fName;
    @FXML
    private Label totalPoint;
    @FXML
    private Button backBtn;
    @FXML
    private TableView<Wish> friendWishTable;
    @FXML
    private TableColumn<Wish, String> wishColumn;
    @FXML
    private TableColumn<Wish, String> fullpriceColumn;
    @FXML
    private TableColumn<Wish, String> remainColumn;
    @FXML
    private TableColumn<Wish, String> statusColumn;
    @FXML
    private TableColumn<Wish, Void> contColumn;

    public static class Wish {

        private String name;
        private String fullPrice;
        private String remaining;
        private String status;

        public Wish(String name, String fullPrice, String remaining, String status) {
            this.name = name;
            this.fullPrice = fullPrice;
            this.remaining = remaining;
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public String getFullPrice() {
            return fullPrice;
        }

        public String getRemaining() {
            return remaining;
        }

        public String getStatus() {
            return status;
        }
    }
    
    @FXML
    private void handleBackAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wishColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        fullpriceColumn.setCellValueFactory(new PropertyValueFactory<>("fullPrice"));
        remainColumn.setCellValueFactory(new PropertyValueFactory<>("remaining"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Set up button column
        contColumn.setCellFactory(param -> new TableCell<Wish, Void>() {
            private final Button btn = new Button("Contribute");
            private final TextField textField = new TextField();  // Create a TextField

            {
                btn.setOnAction((ActionEvent event) -> {
                    Wish w = getTableView().getItems().get(getIndex());
                    String inputText = textField.getText();
                    System.out.println("Button clicked for: " + w.getName() + " | Text: " + inputText);
                });

                textField.setPromptText("Enter point");  // Placeholder text
                textField.setPrefWidth(80);  // Set width
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox hbox = new HBox(10, textField, btn);  // Add TextField & Button inside HBox
                    setGraphic(hbox);
                }
            }
        });

        // Sample data
        ObservableList<Wish> w = FXCollections.observableArrayList(
                new Wish("w1", "100", "50", "Pending"),
                new Wish("w2", "200", "150", "Completed"),
                new Wish("w3", "300", "100", "Processing")
        );

        friendWishTable.setItems(w);
    }
}
