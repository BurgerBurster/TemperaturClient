package client;

import client.models.SensorModel;
import client.models.TemperaturModel;

import java.awt.font.TextMeasurer;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DBReader {
    private String url;


    public DBReader(String dbUrl){
        this.url = dbUrl;
    }

    public void getAllData() {
        try (Connection con = DriverManager.getConnection(url, "u25461", "wk3bwBmShWv5")) {

            //Temperatur Daten
            List<TemperaturModel> listTemps = new ArrayList<>();

            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM temperaturen");

            while(resultSet.next()){
                TemperaturModel item = new TemperaturModel();
                item.TemperaturID = Integer.parseInt(resultSet.getString(0));
                item.sensorNr = Integer.parseInt(resultSet.getString(1));
                item.Zeit = resultSet.getString(2);
                item.Temperatur = Double.parseDouble(resultSet.getString(3));
                item.datum = resultSet.getString(4);
                listTemps.add(item);
            }
            stmt.close();

            //Sensor Daten
            List<SensorModel> listSensor = new ArrayList<>();

            Statement stmtSensor = con.createStatement();
            ResultSet resultSetSensor = stmtSensor.executeQuery("SELECT * FROM sensoren");

            while(resultSetSensor.next()){
                SensorModel item = new SensorModel();
                item.sensorNr = Integer.parseInt(resultSetSensor.getString(0));
                item.serverschrank = Integer.parseInt(resultSetSensor.getString(1));
                item.adresse = resultSetSensor.getString(2);
                item.herstellerNr = Integer.parseInt(resultSetSensor.getString(3));
                item.maxTemperatur = Double.parseDouble(resultSetSensor.getString(4));

                System.out.println(resultSetSensor.getString(0));

                listSensor.add(item);
            }
            stmtSensor.close();



        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}
