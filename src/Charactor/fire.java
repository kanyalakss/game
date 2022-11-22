package Charactor;


import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;



public class fire {
		public int speed;
		public int x;
		public int y;
		Timer timeMove;
		public fire(int x,int y,int speed,JPanel page) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.move(page);
		}
		
		Thread gameThread2 = new Thread() {
			public void run() {
				while(true) {
					if(x<=0) {
						x = (int) (1000+(300+Math.random()*1000));
					}
					x -= 30;
					try {
						Thread.sleep(150);
					} catch (InterruptedException ex) { }
				}
			}
		};
		
		public void move(JPanel page) {
				 this.timeMove = new Timer(speed,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							gameThread2.resume();
						} catch (Exception ex) {
						}
							page.repaint();
							
					}
				});
				gameThread2.start() ;
			}
		
		
		
		public BufferedImage getImage() {
			BufferedImage image = null;
			try {
				 image = ImageIO.read(new File("img\\fire.png"));
				 return image;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return image;
		}
      
}
