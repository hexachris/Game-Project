package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.JPanel;
import Entity.Player;

public class GamePanel extends JPanel implements Runnable{

    final int OriginalTileSize = 16; //16x16 tile
    final int scale = 3;

    public final int TileSize = OriginalTileSize * scale; //48x48 tile
    final int MaxScreenCol = 16; 
    final int MaxScreenRaw = 12;

    final int ScreenWidth = TileSize * MaxScreenCol; //768 pixels
    final int ScreenHeight = TileSize * MaxScreenRaw; //576 pixels

    int FPS = 60;
    KeyInputs keyInputs = new KeyInputs();
    Thread gameThread;
    Player player = new Player (this, keyInputs);


    int X = 100 ;
    int Y = 100;
    int PlayerSpeed = 4;
    
    public GamePanel() {

      setPreferredSize(new Dimension(ScreenHeight, ScreenWidth));
      setBackground(Color.BLACK);
      setDoubleBuffered(true);
      addKeyListener(keyInputs);
      setFocusable(true);
    }

    public void StartGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {

        double DrawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime; 
        long Timer = 0; 
        int DrawCount= 0;

        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / DrawInterval;
            Timer += (currentTime - lastTime);
            lastTime = currentTime; 

            if (delta >= 1){
                update();
                repaint();
                delta--;
                DrawCount++;
            }
            if (Timer >= 1000000000){
                System.out.println("FPS:" + DrawCount);
                DrawCount = 0;
                Timer = 0;
            }
        }
    }
    public void update(){

        player.update();

    }
    public void paintComponent (Graphics g ){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        player.Draw(g2);
        g2.dispose();
    }


}
    