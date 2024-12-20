package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entity.Player;
import Tile.TileManager;
import object.UniqueObject;

public class GamePanel extends JPanel implements Runnable{
	
	final int originalTileSize = 16;
	final int scale = 3;
	
	public final int TileSize = originalTileSize * scale;
	public final int MaxScreenCol = 16;
	public final int MaxScreenRow = 12;
	public final int ScreenWidth = TileSize * MaxScreenCol;
	public final int ScreenHeight = TileSize * MaxScreenRow;

	public final int MaxWorldCol = 100;
	public final int MaxWorldRow = 100;
	
	int FPS = 60;
	

	TileManager tileManager = new TileManager(this);
	KeyInputs keyInputs =new KeyInputs();
	Sound music = new Sound();
	Sound soundeffect = new Sound();

	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	
	// entity and object
	public Player player = new Player(this, keyInputs);
	public UniqueObject obj[] = new UniqueObject[10];
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyInputs);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
		
		playMusic(0);
	}
	
	public void StartGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0; 
		double lastTime = System.nanoTime();
		long CurrentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			
			CurrentTime = System.nanoTime();
			
			delta += (CurrentTime - lastTime) / drawInterval;
			timer += (CurrentTime - lastTime);
			lastTime = CurrentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			if (timer >= 1000000000) {
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
			
		}
	}
	public void update() {
		
		player.update();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D)g;
		
		//Debug
		long drawStart = 0;
		if (keyInputs.checkDrawTime == true) {
			drawStart = System.nanoTime();
		}
		
		//Tile
		tileManager.draw(g2);
		
		//object
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		//player
		player.draw(g2);
		
		//UI
		ui.draw(g2);
		
		//debug
		if ( keyInputs.checkDrawTime == true) {
			
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("Draw Time: " + passed, 10, 400);
			System.out.println("Draw Time: " + passed);
		}
		g2.dispose();
	}
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
	}
	public void stopMusic() {
		music.stop();
	}
	public void playSE(int i) {
		
		soundeffect.setFile(i);
		soundeffect.play();
	}
}
