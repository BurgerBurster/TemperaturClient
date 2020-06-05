package client;

public class Client {
    public static void main(String[] args) {
        DBReader reader = new DBReader("jdbc:mysql://mysql04.manitu.net/db25461?serverTimezone=UTC&verifyServerCertificate=false&autoReconnect=true&useSSL=false");
        reader.getAllData();

        GUI.callGui();
    }
}
