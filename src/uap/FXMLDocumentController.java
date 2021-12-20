/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap;

import db.koneksi;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TextField txtSaldo;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnClear;
    @FXML
    private TableView<Rekening> tblRekening;
    @FXML
    private Button btnRefresh;
    @FXML
    private TableColumn<Rekening, String> kolomNoRek;
    @FXML
    private TableColumn<Rekening, String> kolomNama;
    @FXML
    private TableColumn<Rekening, Double> kolomSaldo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnClear.fire();
        btnRefresh.fire();
    }    

    @FXML
    private void simpanData(ActionEvent event) {
        koneksi d = new koneksi();
        
        d.addRekening(new Rekening(txtNoRek.getText(), txtNama.getText(), Double.parseDouble(txtSaldo.getText())));
        
        btnRefresh.fire();
    }

    @FXML
    private void clearData(ActionEvent event) {
        txtNoRek.setText("");
        txtNama.setText("");
        txtSaldo.setText("");
    }

    @FXML
    private void refreshData(ActionEvent event) {
        koneksi d = new koneksi();
        ObservableList<Rekening> data = d.getRekening();
        kolomNoRek.setCellValueFactory(new PropertyValueFactory<>("norek"));
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kolomSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblRekening.setItems(null);
        tblRekening.setItems(data);
    }
    
}
