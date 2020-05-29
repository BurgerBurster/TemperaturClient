package client;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
    HIER kannst du dich austoben, Lucas :)

    Ich habe schonmal etwas vorbereitet,
    du kannst das aber auch gerne anders machen
 */

public class GUI extends JFrame {

    private final int WIDTH = 800;
    private final int HEIGHT = 500;

    private final String TITLE = "Temperatur-Client";

    public GUI() {
        initGUI();
        addComponents();
    }

    private void initGUI() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle(TITLE);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addComponents() {
        // Das hier sind nur Beispiele
        JButton btnShowTemps = new JButton("Temperaturdaten");
        JButton btnShowSensors = new JButton("Sensordaten");
        JButton btnShowAverage = new JButton("Durchschnittstemperaturen");

        // Es muss noch ein passendes Layout hinzugefügt werden
        this.add(btnShowTemps);
        this.add(btnShowSensors);
        this.add(btnShowAverage);
    }

    public void display() {
        setVisible(true);
    }

}
