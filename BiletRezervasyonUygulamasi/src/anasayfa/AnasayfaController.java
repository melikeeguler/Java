package anasayfa;

import Models.BiletModel;
import Models.UcusModel;
import connection.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

public class AnasayfaController {
    AnasayfaView anasayfaView;
    ConnectionClass connectionClass;
    Connection connection;

    public AnasayfaController(AnasayfaView view) {
        this.anasayfaView = view;
        this.connectionClass = new ConnectionClass();
        this.connection = connectionClass.getConnection();
    }


    public void ucusSorgula(String kalkisYeri, String varisYeri, LocalDate kalkisZamani) {
        try {

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM flight WHERE from_city ='"
                    + kalkisYeri
                    + "' AND to_city ='" + varisYeri
                    + "' AND flight_date ='" + kalkisZamani.toString()
                    + "' AND flight_type ='Ekonomi';";
            ResultSet rs = statement.executeQuery(sql);
            ObservableList<UcusModel> ucusModelList = FXCollections.observableArrayList();
            UcusModel ucusModel1;

            while (rs.next()) {
                ucusModel1 = new UcusModel();
                ucusModel1.setUcusID(rs.getInt("id"));
                ucusModel1.setKalkisYeri(rs.getString("from_city"));
                ucusModel1.setBiletTipi(rs.getString("flight_type"));
                ucusModel1.setVarisYeri(rs.getString("to_city"));
                Date newFlightDate = rs.getDate("flight_date");

                ucusModel1.setKalkisZamani(newFlightDate.toString());
                ucusModelList.add(ucusModel1);
            }

            if (ucusModelList.isEmpty()) {
                anasayfaView.error();
            } else {
                anasayfaView.resultListUcus(ucusModelList);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            anasayfaView.error();
        }
    }

    public void biletlerimiSorgula() {
        /*SELECT * FROM `ticket` as t INNER JOIN `user` as u ON u.id=t.ticket_user_id INNER JOIN `flight` as f ON f.id=t.ucus_id*/
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM `ticket` as t INNER JOIN `user` as u ON u.id=t.ticket_user_id INNER JOIN `flight` as f ON f.id=t.ucus_id";
            ResultSet rs = statement.executeQuery(sql);
            ObservableList<BiletModel> biletModelList = FXCollections.observableArrayList();
            BiletModel biletModelSonuc;
            while (rs.next()) {
                biletModelSonuc = new BiletModel();
                biletModelSonuc.setId(rs.getInt("id"));
                biletModelSonuc.setUserId(rs.getInt("ticket_user_id"));
                biletModelSonuc.setUcusId(rs.getInt("ucus_id"));

                biletModelSonuc.setKalkisYeri(rs.getString("from_city"));
                biletModelSonuc.setBiletTipi(rs.getString("flight_type"));
                biletModelSonuc.setVarisYeri(rs.getString("to_city"));
                Date newFlightDate = rs.getDate("flight_date");

                biletModelSonuc.setKalkisZamani(newFlightDate.toString());
                biletModelList.add(biletModelSonuc);
            }

            if (biletModelList.isEmpty()) {
                anasayfaView.error();
            } else {
                anasayfaView.resultListBiletlerim(biletModelList);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            anasayfaView.error();
        }
    }


    public void biletAl(BiletModel biletModel) {
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO TICKET( ticket_user_id, ucus_id)  VALUES(1,1)";
            boolean rs = statement.execute(sql);
            if (!rs) {
                anasayfaView.success();
            } else {
                anasayfaView.error();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void biletSil(BiletModel biletSiltModel) {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM `ticket`" +
                    "WHERE id ='"
                    + biletSiltModel.getId()
                    + "';";
            boolean rs = statement.execute(sql);
            if (!rs) {
                anasayfaView.success();
            } else {
                anasayfaView.error();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void biletGuncelle(BiletModel biletGuncelletModel) {
        try {
            Statement statement = connection.createStatement();
            String sql = "UPDATE `ticket` " +
                    " SET `ticket_user_id` =2 "
                    + "WHERE id ='"
                    + biletGuncelletModel.getId()
                    + "';";
            boolean rs = statement.execute(sql);
            if (!rs) {
                anasayfaView.success();
            } else {
                anasayfaView.error();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
