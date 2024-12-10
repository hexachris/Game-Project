package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener{
	
	public boolean UpPressed, DownPressed, LeftPressed, RightPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			UpPressed = true;
		}
		if (code == KeyEvent.VK_S) {
			DownPressed = true;
		}
		if (code == KeyEvent.VK_A) {
			LeftPressed = true;
		}
		if (code == KeyEvent.VK_D) {
			RightPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			UpPressed = false;
		}
		if (code == KeyEvent.VK_S) {
			DownPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			LeftPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			RightPressed = false;
		}
		
	}
	
}
