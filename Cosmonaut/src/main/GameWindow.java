package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameWindow extends JFrame{

    public GameWindow(){
        //title of the window
        setTitle("Cosmonaut");  

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        pack();

        //size of the window
        setSize(800, 600);

        //set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        gamePanel.StartGameThread();
        
    }
    public static void main(String[] args) {
        // Use SwingUtilities to ensure thread safety
        SwingUtilities.invokeLater(() -> {
            GameWindow frame = new GameWindow();
            frame.setVisible(true); // Make the window visible
            frame.requestFocus();
        });
    }
}
