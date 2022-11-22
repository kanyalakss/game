package Charactor;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.geom.Rectangle2D;

public class penquin{
	public int x ;
	public int y;
	public int health=180;
	public static int speed=50;
	
	public penquin() {
		
	}
	
	public penquin(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public void jump(JPanel page) {
		this.y -= speed;
		page.repaint();

		Timer timer =new Timer(800,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					y += speed;
					page.repaint();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("img\\penquin2.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	
}
