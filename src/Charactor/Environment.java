package Charactor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Environment implements Runnable {
		public int x;
		public int y;
		public int startX;
		public int speed;
		public int eType;
		public static int CLOUD = 0;
		public Timer timeMove;
		public Environment(int x,int y,JPanel page,int eType,int speed) {
			this.x = x;
			this.y = y;
			this.startX = x;
			this.speed = speed;
			this.eType = eType;
			this.move(page);
		}

		Thread gameThread4 = new Thread() {
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
							gameThread4.resume();
						} catch (Exception ex) {
						}
							page.repaint();				
					}
				});
				gameThread4.start();
			}
		
		
		public String getEvType(int eType){
			 String[] name = new String[] {"fah.png"};
			 return name[eType];
		}
		
		public BufferedImage getImage() {
			BufferedImage image = null;
			try {
				 image = ImageIO.read(new File("img\\"+getEvType(this.eType)));
				 return image;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return image;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
}
