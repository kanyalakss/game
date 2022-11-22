package Charactor;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;

public class heart {
		public int speed;
		public int x;
		public int y;
		Timer timeMove;
		public heart(int x,int y,int speed,JPanel page) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.move(page);
		}
		
		public void move(JPanel page) {
			this.timeMove = new Timer(speed,new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
					   if(x<=0) {
						   x = (int) (1000+(300+Math.random()*1000));
					   }
					   x -= 30;
					   page.repaint();
			   }
		   });
			this.timeMove.start();
   }
		
		public BufferedImage getImage() {
			BufferedImage image = null;
			try {
				 image = ImageIO.read(new File("img\\heart.png"));
				 return image;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return image;
		}
}
