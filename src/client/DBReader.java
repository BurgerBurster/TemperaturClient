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

    public List<TemperaturModel> listTemps;
    public List<SensorModel> listSensor;

    public void getAllData() {
        try (Connection con = DriverManager.getConnection(url, "u25461", "wk3bwBmShWv5")) {

            //Temperatur Daten
            listTemps = new ArrayList<>();

            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM temperaturen");

            while(resultSet.next()){
                TemperaturModel item = new TemperaturModel();
                item.TemperaturID = Integer.parseInt(resultSet.getString(1));
                item.sensorNr = Integer.parseInt(resultSet.getString(2));
                item.Zeit = resultSet.getString(3);
                item.Temperatur = Double.parseDouble(resultSet.getString(4));
                item.datum = resultSet.getString(5);
                listTemps.add(item);
            }
            stmt.close();

            //Sensor Daten
            listSensor = new ArrayList<>();

            Statement stmtSensor = con.createStatement();
            ResultSet resultSetSensor = stmtSensor.executeQuery("SELECT sensorNr, serverschrank, adresse, herstellerNr, maxtemperatur FROM sensoren");

            while(resultSetSensor.next()){
                SensorModel item = new SensorModel();
                item.sensorNr = Integer.parseInt(resultSetSensor.getString(1));
                item.serverschrank = Integer.parseInt(resultSetSensor.getString(2));
                item.adresse = resultSetSensor.getString(3);
                item.herstellerNr = Integer.parseInt(resultSetSensor.getString(4));
                item.maxTemperatur = Double.parseDouble(resultSetSensor.getString(5));

                System.out.println(resultSetSensor.getString(2));

                listSensor.add(item);
            }
            stmtSensor.close();



        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}
