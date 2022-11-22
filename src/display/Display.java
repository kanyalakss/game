package display;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Display extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Dimension size = new Dimension(1000,600);
	
	public Display() {
		this.setting();
		Game game = new Game();
		this.getContentPane().add(game);
		game.requestFocus();
	}
	

	private void setting() {
		this.setTitle("Dodge the fire dragon");
		this.setSize(size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(280,100);
		this.setVisible(true);
	}
	
	private void removeContent() {
		this.getContentPane().removeAll();
		this.getContentPane().repaint();
	}

	public void endGame(long point,int times,int timesuse,int PenquinHealth) {
		removeContent();
		this.getContentPane().add(new Menu(point, times, PenquinHealth,timesuse,this));
		

	}
	public void winGame(long point,int times,int timesuse,int PenquinHealth) {
		removeContent();
		this.getContentPane().add(new Menu( point, times, PenquinHealth,timesuse,this));

        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("restart")) {
			removeContent();
			Game game = new Game();
			this.getContentPane().add(game);
			game.requestFocus();
		}
	}
	
}
