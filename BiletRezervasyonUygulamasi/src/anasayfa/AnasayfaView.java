package anasayfa;

import Models.BiletModel;
import Models.UcusModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import messageType.IResultListInterface;
import messageType.IResultMessageInterface;

//polymorphism
public class AnasayfaView implements IResultMessageInterface, IResultListInterface {
    public DatePicker ucusTarihiDtPicker;
    public TextField varisYeriTf;
    public TextField kalkisYeriTf;
    public Label kalkisYeriLbl;
    public Label varisYeriLbl;
    public ComboBox ucusTipiCombobox;
    public Label ucusTarihiLbl;
    public Label ucusTipiLbl;
    public Button ucusSorgulaBtn;
    public AnasayfaController anasayfaController = new AnasayfaController(this);
    public TableView<UcusModel> biletSorguSonucuViewTable;
    public TableView<BiletModel> biletlerimSorguSonucuViewTable;

    public TableColumn<UcusModel, String> kalkisYeri;
    public TableColumn<UcusModel, String> varisYeri;
    public TableColumn<UcusModel, String> kalkisZamani;
    public TableColumn<UcusModel, String> biletTipi;
    public Button biletAl;
    public Button biletSorgulaBtn;
    public Button biletGuncelleBtn;
    public Button biletSilBtn;

    public TableColumn<BiletModel, String> kalkisYeriBiletlerim;
    public TableColumn<BiletModel, String> varisYeriBiletlerim;
    public TableColumn<BiletModel, String> ucusTarihiBiletlerim;
    public TableColumn<BiletModel, String> ucusTipiBiletlerim;
    public TableColumn<BiletModel, String> biletNoBiletlerim;

    public void ucusSorguAction(ActionEvent actionEvent) {
        anasayfaController.ucusSorgula(kalkisYeriTf.getText(), varisYeriTf.getText(), ucusTarihiDtPicker.getValue());
    }

    @Override
    public void resultListUcus(ObservableList<?> resultList) {
        biletSorguSonucuViewTable.getItems().clear();
        kalkisYeri.setCellValueFactory(new PropertyValueFactory<>("kalkisYeri"));
        varisYeri.setCellValueFactory(new PropertyValueFactory<>("varisYeri"));
        kalkisZamani.setCellValueFactory(new PropertyValueFactory<>("kalkisZamani"));
        biletTipi.setCellValueFactory(new PropertyValueFactory<>("biletTipi"));
        biletSorguSonucuViewTable.setItems((ObservableList<UcusModel>) resultList);
    }

    @Override
    public void resultListBiletlerim(ObservableList<?> resultList) {
        biletlerimSorguSonucuViewTable.getItems().clear();

        biletNoBiletlerim.setCellValueFactory(new PropertyValueFactory<>("id"));
        kalkisYeriBiletlerim.setCellValueFactory(new PropertyValueFactory<>("kalkisYeri"));
        varisYeriBiletlerim.setCellValueFactory(new PropertyValueFactory<>("varisYeri"));
        ucusTarihiBiletlerim.setCellValueFactory(new PropertyValueFactory<>("kalkisZamani"));
        ucusTipiBiletlerim.setCellValueFactory(new PropertyValueFactory<>("biletTipi"));
        biletlerimSorguSonucuViewTable.setItems((ObservableList<BiletModel>) resultList);
    }

    @Override
    public void success() {
        System.out.print("başarılı");
    }

    @Override
    public void error() {
        biletSorguSonucuViewTable.getItems().clear();
    }

    public void biletAlAction(ActionEvent actionEvent) {
        UcusModel ucusModel = biletlerimSorguSonucuViewTable.getSelectionModel().getSelectedItem();
        Integer userId = 1;

        BiletModel biletModel = new BiletModel();
        biletModel.setUcusID(ucusModel.getUcusID());
        biletModel.setUserId(userId);

        anasayfaController.biletAl(biletModel);
    }

    public void biletiSilAction(ActionEvent actionEvent) {
        BiletModel biletModel = biletlerimSorguSonucuViewTable.getSelectionModel().getSelectedItem();

        BiletModel biletModelSil = new BiletModel();

        biletModelSil.setId(biletModel.getId());
        biletModelSil.setUcusID(biletModel.getUcusID());
        biletModelSil.setUserId(biletModel.getUserId());

        anasayfaController.biletSil(biletModelSil);
    }

    public void biletimiGuncelleAction(ActionEvent actionEvent) {
        BiletModel biletModel = biletlerimSorguSonucuViewTable.getSelectionModel().getSelectedItem();

        BiletModel biletModelSil = new BiletModel();

        biletModelSil.setId(biletModel.getId());
        biletModelSil.setUcusID(biletModel.getUcusID());
        biletModelSil.setUserId(biletModel.getUserId());

        anasayfaController.biletGuncelle(biletModel);
    }

    public void biletlerimiSorgulaAction(ActionEvent actionEvent) {
        anasayfaController.biletlerimiSorgula();
    }
}
