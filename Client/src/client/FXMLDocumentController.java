/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dto.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    PrintWriter writer;
    BufferedReader reader;
    Socket mySocket;
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfPassword;
    @FXML
    private Button btLogin;

    

    
    @FXML
    private void handleButtonLogin(ActionEvent e) {
        LoginDTO loginData = new LoginDTO(tfUsername.getText(), tfPassword.getText());
        System.out.println(loginData.getPassword() + loginData.getUsername());
        Gson gson = new Gson();
        JsonObject jsonObject = gson.toJsonTree(loginData).getAsJsonObject();
        jsonObject.addProperty("command", "login");
        String jsonString = gson.toJson(jsonObject);
        writer.println(jsonString);
        try {                   
            System.out.println("test");
            String jsonResponse = reader.readLine();
            jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            String result = jsonObject.get("Result").getAsString();    
            System.out.println(result);
            /// Home Page
            
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }   
    @FXML
    private void handleButtonSignup(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SignupDocument.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            try {
            mySocket = new Socket("127.0.0.1", 5005);
            writer = new PrintWriter(mySocket.getOutputStream(),true);
            reader = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
