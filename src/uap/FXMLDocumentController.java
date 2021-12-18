/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Windosw
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtNoRek;
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtPin;
    @FXML
    private TextField txtSaldo;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnClear;
    @FXML
    private TableView<String> tblRekening;
    @FXML
    private Button btnRefresh;
    @FXML
    private TableColumn<?, ?> kolomNoRek;
    @FXML
    private TableColumn<?, ?> kolomNama;
    @FXML
    private TableColumn<?, ?> kolomSaldo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simpanData(ActionEvent event) {
        
    }

    @FXML
    private void clearData(ActionEvent event) {
        
    }

    @FXML
    private void refreshData(ActionEvent event) {
    }
    
}
