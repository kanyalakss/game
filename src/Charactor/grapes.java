package Charactor;


import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;



public class grapes{
		public static final String style = null;
        public int speed;
		public int x;
		public int y;
		boolean startGrapes = false;
		Timer timeMove;
		public grapes(int x,int y,int speed,JPanel page) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.move(page);
		}

		Thread gameThread3 = new Thread() {
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
							gameThread3.resume();
						} catch (Exception ex) {
						}
							page.repaint();				
					}
				});
				gameThread3.start() ;
			}
		
		
		public BufferedImage getImage() {
			BufferedImage image = null;
			try {
				 image = ImageIO.read(new File("img\\grapes.png"));
				 return image;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return image;
		}
}
