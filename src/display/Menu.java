package display;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Charactor.penquin;
import Element.EleButton;
import Element.EleLabel;

public class Menu extends JPanel {

		private static final long serialVersionUID = 1L;
		public long point,PenquinHealth;
		public int times,timesuse;
		
		public Menu() {
			
		}
		
		public void paintComponent(Graphics g){
			try {
				g.drawImage(ImageIO.read(new File("img\\night.jpg")),0,0,1000,580, null);
			} catch (IOException e) {
				e.printStackTrace();
			}	
	
		}
		
		public Menu(long point,int times,int PenquinHealth,int timesuse,ActionListener main) {
			try {
				    this. timesuse = timesuse;
					this.point = point;
					this.times = times;
					this.PenquinHealth = PenquinHealth;
					this.setBounds(0,0,1000,600);
					this.setFocusable(true);
					this.setLayout(null);
					
					
					EleLabel showPoint = new EleLabel("Total score : "+this.point,20,8,4,400,100);
					showPoint.setForeground(Color.white);
										
					EleButton restart = new EleButton("restart",15,380,340,200,50);
					restart.addActionListener(main);		

					if(this.times == 0){
					EleLabel showMess = new EleLabel("you did it hooray!",48,300,150,700,100);
					showMess.setForeground(Color.yellow);
					this.add(showMess);
					}
					if(this.PenquinHealth == 0){
						EleLabel showMesstime = new EleLabel("you used "+timesuse+" sec",20,8,28,400,100);
						EleLabel showMess = new EleLabel("you died!",48,370,150,400,100);
						showMess.setForeground(Color.red);
						showMesstime.setForeground(Color.white);
					this.add(showMess);
					this.add(showMesstime);
					}

					this.add(showPoint);
					this.add(restart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}


}
