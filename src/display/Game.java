package display;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import Charactor.*;
import Element.Element;
import event.Event;

public class Game extends JPanel implements KeyListener{
    boolean timestart=false ;
	public int timesuse = 0;
	public int times = 60;
	private long point = 0;
	private long morningnoonnight = 0;
	private static int speed = 50,penquinSize = 60 ,dragonHeight = 70,grapesHeight = 50;
	private static int base=400,xStart = 1000;
	long lastPress=0;
	
	private penquin Penquin = new penquin(100,base+80);
	static Display display;
    private grapes[] GrapesSet = makeGrapes(4);
    private heart[] HeartSet = makeHeart(4);
	private dragon[] DragonSet = makeDragon(4);
	private fire[] FireSet = makeFire(4);
	private Environment[] envSet = makeEnv(2,Environment.CLOUD);
	
		public Game(){
		this.setBounds(0,0,1000,600);
		this.addKeyListener(this);
		this.setLayout(null);
		this.setFocusable(true);
		time.start();
		actor.start();
		counttime.start();
		timeuse.start();
	}
	
	@Override
	public void paint(Graphics g) {
			try {
				super.paint(g);
				Graphics2D g2 = (Graphics2D) g;
				this.drawBackground(g2);
				g2.setFont(Element.getFont(20));
				g2.setColor(Color.white);
				g2.drawString("experiance: "+point,10,30);
				g2.setColor(Color.red);
				g2.setFont(Element.getFont(38));
				if(timesuse == 20){
					g2.drawString("you need to hurry up",400,200);
				}
				if(timesuse == 40){
					g2.drawString("hurry up",400,200);
				}
				if(timesuse == 50){
					g2.drawString("10 sec left!!",400,200);
				}
				g2.setFont(Element.getFont(20));
				g2.drawString("times left: "+times,10,100);
				g2.setColor(Color.white);
				g2.setFont(Element.getFont(20));
                for(int i =0;i<=3;i++){
					if(point <= 300){
				    g2.drawString("level: EASY ",400,30);
						;}
					else if(point<=1000){
					g2.drawString("level: NOT THAT HARD ",400,30);
						}
					else if(point<=2000){
					g2.drawString("level:HARD ",400,30);
    }
					else if(point>2500){
					g2.drawString("level: EXPERT ",400,30);
						}
				}

                this.point+=5;
				this.morningnoonnight += 5;

				g2.setColor(Color.RED);
				drawPenquinHealth(g2);
				g2.drawImage(Penquin.getImage(),Penquin.x,Penquin.y,penquinSize,penquinSize, null);
				for(dragon item : DragonSet) {
					drawDragon(item,g2);
				}
				for(fire item :FireSet) {
					drawFire(item,g2);
				}
				for(grapes item : GrapesSet) {
					drawGrapes(item,g2);
				}

				for(heart item : HeartSet) {
					drawHeart(item,g2);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	Thread time = new Thread(new Runnable(){
		public void run(){
		while(true){
		    try{
		        Thread.sleep(10);
		        }catch(Exception e){ }
		            if(timestart == false){
		             repaint();
	}
		}
		}
		});
		Thread timeuse = new Thread(new Runnable(){
			public void run() {
			while(true){
			if(timestart == false){
				timesuse = (timesuse+1) ;
			}
			try{
			     Thread.sleep(1000);
			}catch(InterruptedException e)
			{
			e.printStackTrace();
			}
			
			}
			}
			});

		Thread counttime = new Thread(new Runnable(){
			public void run() {
			while(true){
			if(timestart == false){
			     times = (times-1) ;
			}
			try{
			     Thread.sleep(1000);
			}catch(InterruptedException e)
			{
			e.printStackTrace();
			}
			if(times==0){
				display.winGame(point, times,timesuse,Penquin.health);
			}
			}
			}
			});

	Thread actor = new Thread(new Runnable(){
			public void run(){
			    while(true){
			try{
			    Thread.sleep(1);
			}catch(Exception e){}
			    repaint();
			}
			}
			});
			
	private void drawBackground(Graphics2D g2) throws IOException {
		
			if(Event.checkmorning(morningnoonnight)){
				g2.drawImage(ImageIO.read(new File("img\\morning.jpg")),
				0,0,1000,580, null);	

				if(Event.checkafternoon(morningnoonnight)){
			    g2.drawImage(ImageIO.read(new File("img\\noon2.jpg")),
				0,0,1000,580, null);	
			       
				    if(Event.checknight(morningnoonnight)){
			        	g2.drawImage(ImageIO.read(new File("img\\night.jpg")),
						0,0,1000,580, null);	
			            if(morningnoonnight == 900){
						this.morningnoonnight = 0;}
					}	
			
		}	
			}
		
		
		for(Environment item:envSet) {
				g2.drawImage(item.getImage(),item.x,item.y,250,160, null);
			}
	}
 
		
	
	private void drawPenquinHealth(Graphics2D g2) {
		try {
			g2.drawImage(ImageIO.read(new File("img\\heart.png")),705,21, 20,20,null);
			g2.setStroke(new BasicStroke(18.0f));
			g2.setColor(new Color(227,36,167));
			g2.drawLine(740, 30,795+Penquin.health,30);	
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(2.0f));
			g2.drawRect(730,20, 255,20);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private grapes[] makeGrapes(int size) {
		grapes[] GrapesSet = new grapes[size];
		int far = 600;
		for(int i=0;i<size;i++) {
			GrapesSet[i] = new grapes(xStart+far,base,speed,this);
			far+=12000;
		}
		return GrapesSet;
	}
	private heart[] makeHeart(int size) {
		heart[] HeartSet = new heart[size];
		int far = 1400;
		for(int i=0;i<size;i++) {
			HeartSet[i] = new heart(xStart+far,base,speed,this);
			far+=5600;
		}
		return HeartSet;
	}
	private fire[] makeFire(int size) {
		fire[] FireSet = new fire[size];
		int far = 260;
		for(int i=0;i<size;i++) {
			if(point <= 300){
				FireSet[i] = new fire(xStart+far,base,speed,this);
			far+=4500;}
			else if(point<=1500){
				FireSet[i] = new fire(xStart+far,base,speed,this);
			far+=2500;}
			else if(point<=2000){
				FireSet[i] = new fire(xStart+far,base,speed,this);
			far+=1000;}
			else if(point>2500){
				FireSet[i] = new fire(xStart+far,base,speed,this);
			far+=300;}
			
			}
			
		return FireSet;
	
		}
	
	private dragon[] makeDragon(int size) {
		dragon[] DragonSet = new dragon[size];
		int far = 200;
		for(int i=0;i<size;i++) {
				if(point <= 300){
					DragonSet[i] = new dragon(xStart+far,base,speed,this);
				far+=3000;}
				else if(point<=1000){
					DragonSet[i] = new dragon(xStart+far,base,speed,this);
				far+=2000;}
				else if(point>2000){
					DragonSet[i] = new dragon(xStart+far,base,speed,this);
				far+=900;}
				else if(point>2500){
					DragonSet[i] = new dragon(xStart+far,base,speed,this);
				far+=300;}
				}		
				return DragonSet;

		}
	
	
	private Environment[] makeEnv(int size,int eType){
		Environment[] envSet = new Environment[size];
		int far = 0;
		for(int i=0;i<size;i++) {
			envSet[i] = new Environment(xStart+far,20,this,eType,10);
			far+=400;
		}
		return envSet;
	}
	
	

	private void drawDragon(dragon Dragon,Graphics2D g2) {
			g2.drawImage(Dragon.getImage(),Dragon.x ,(Dragon.y+70),60,dragonHeight+15,null);
			if(Event.checkHitdragon(Penquin,Dragon,penquinSize)){
				Penquin.health-=10;
				g2.setColor(new Color(241, 98, 69));
				g2.drawString("--------- BE CAREFUL-------- ",400,200);
					if(Penquin.health<=0) {
						display.endGame(this.point,this.times,this.timesuse,this.Penquin.health);
						Penquin.health = new penquin().health;
						this.point = 0;	
					}
			}
	}
	private void drawFire(fire Fire,Graphics g2) {

		g2.drawImage(Fire.getImage(),Fire.x ,(Fire.y+25),60,dragonHeight+15,null);
		if(Event.checkHitfire(Penquin,Fire,penquinSize)){
			    g2.setColor(new Color(206, 6, 9));
				g2.drawString(" !!! it's HOT !!!",400,250);
				Penquin.health-=10;
				if(Penquin.health<=0) {
					display.endGame(this.point,this.times,this.timesuse,this.Penquin.health);
					Penquin.health = new penquin().health;
					this.point = 0;	
				}
		}
}
	private void drawGrapes(grapes Grapes,Graphics g2) {

		g2.drawImage(Grapes.getImage(),Grapes.x,(Grapes.y+10),40,grapesHeight+10,null);
		if(Event.checkHitgrapes(Penquin,Grapes,penquinSize,grapesHeight)){
			    g2.setColor(new Color(241, 98, 69));
				g2.drawString("+50 experiances ",20,70);
				point+=50;
				this.GrapesSet = null;

				
		}
}
        private void drawHeart(heart Heart,Graphics g2) {
		g2.drawImage(Heart.getImage(),Heart.x,(Heart.y+90),20,20,null);
		if(Event.checkHitHeart(Penquin,Heart,penquinSize)){	
			    g2.setColor(new Color(220, 3, 216));
				g2.drawString("+10 blood ",720,70);
				Penquin.health += 10;
				this.HeartSet = null;

				
				
		}
}

	@Override
	public void keyPressed(KeyEvent e) {
		if(System.currentTimeMillis() - lastPress > 600) {
				switch(e.getKeyCode()){
				case KeyEvent.VK_UP  : Penquin.jump(this);
					lastPress = System.currentTimeMillis();
					
			}}
			
		}
		

	@Override
	public void keyTyped(KeyEvent e) {
		//---
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//---
	}
	
	public static void main(String[] arg) {
		 display = new Display();
		 
	}
}
