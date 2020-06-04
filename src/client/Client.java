package client;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hallo Welt");
        DBReader reader = new DBReader("jdbc:mysql://mysql04.manitu.net/db25461?serverTimezone=UTC&verifyServerCertificate=false");
        reader.getAllData();
    }
}
