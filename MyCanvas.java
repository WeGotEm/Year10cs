package GG;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

public class MyCanvas extends Canvas implements KeyListener {
	 // global variables - accessible in all methods
	GoodGuy Peter = new GoodGuy(500, 500, 30, 30,"Files/Peter.png");
	GoodGuy Victory = new GoodGuy(430,250, 400, 200, "Files/EpicRoyale.png");
	Background Startgame = new Background (0, 0, 1200,750, "Files/Spoonerstreet.png");
	Background Gameover = new Background (0, 0, 1200, 750, "Files/GameOver.gif");
	Image clam = Toolkit.getDefaultToolkit().getImage("Files/clam.jpg");
	//GoodGuy Chicken = new GoodGuy(500, 300, 50, 50	,"Files/Chicken.png");
	boolean gameStarted = false;
	boolean gameOver = false;
	LinkedList badguys = new LinkedList();
	LinkedList bullets = new LinkedList();
	
	int time = 0;
	int score;

	/** 
	 * MyCanvas drawing canvas inherits from java.awt.Canvas
	 * @author EVaccaro
	 * @since Oct 11, 2018
	 * @param no parameters, default constructor
	 */
	

	public MyCanvas() {
		this.setSize(1200,750); // set same size as MyScreen
		this.addKeyListener (this);
		this.setBackground(Color.CYAN);
		
		
		Random rand = new Random();
		int winwidth = this.getWidth();
		int winheight =  this.getHeight();
		for(int i = 0; i<20; i++) {
			BadGuy bg = new BadGuy(rand.nextInt(winwidth)+1400, rand.nextInt(winheight), 125,125, "Files/Chicken.png");
			Rectangle r = new Rectangle(100,100, 100, 100);
			if (r.contains(Peter.getxCoord(), Peter.getyCoord())) {
				System.out.println("sniped");
				continue;
				
			}
			badguys.add(bg);
		}
	}

	/**
	 * paint overload java.awt.Canvas paint method and make it draw an oval
	 * @param graphics context variable called g
	 */
	public void paint (Graphics g) {
		System.out.println(score);
		//g.fillOval(100,100,10,10);
		//draw good guy
		if(gameStarted) {
		g.drawImage(clam, 0, 0, this);
		g.drawImage(Peter.getImg(), Peter.getxCoord(), Peter.getyCoord(), this);
		time++;
		
		
		
		for(int i =  0; i < badguys.size(); i++) {
			BadGuy bg = (BadGuy) badguys.get(i);
			g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
			Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());
			
			if (time%4==0) {
				bg.setxCoord(bg.getxCoord()-1);
			}
			if(bg.getxCoord() < 0) {
				gameOver = true;
				score = 0;
			}
			
			for(int j = 0; j < bullets.size();j++) {
				Projectile k = (Projectile) bullets.get(j);
				if (k.getxCoord() > this.getWidth()) {bullets.remove(k);}
				if (time%6==0 ) {
				k.setxCoord(k.getxCoord() + k.getFacing());
				}
				g.drawImage(k.getImg(), (int) k.getxCoord(), k.getyCoord(), this);
				
				Rectangle kr = new Rectangle ( (int) k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight());
				if (kr.intersects(r)) {
					badguys.remove(i);
					bullets.remove(j);
					score++;
				}
				
			}
		} 
	}
		if(!gameStarted) {
			g.drawImage(Startgame.getImg(), Startgame.getxCoord(), Startgame.getyCoord(), Startgame.getWidth(), Startgame.getHeight(),this);
		}
		if(gameOver) {
			g.drawImage(Gameover.getImg(), Gameover.getxCoord(), Gameover.getyCoord(), Gameover.getWidth(), Gameover.getHeight(),this);
		}
		repaint();
		if (score==20) {
			
			g.drawImage(Victory.getImg(), Victory.getxCoord(), Victory.getyCoord(), Victory.getWidth(), Victory.getHeight(),this);

		}
	}
	//public void KeyTyped(KeyEvent e) {
	//}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e);
		
		if (gameOver && e.getKeyCode()==10) {
			gameOver = false;
			gameStarted = false;
			while (badguys.size()>0) {
				for (int i = 0; i<badguys.size(); i++) {
					badguys.remove(i);
				}
			}
			Peter.setxCoord(20);
			Peter.setyCoord(50);
			Random rand = new Random();
			int winwidth = this.getWidth();
			int winheight =  this.getHeight();
			for(int i = 0; i<40; i++) {
				BadGuy bg = new BadGuy(rand.nextInt(winwidth)+1200, rand.nextInt(winheight), 125,125, "Files/Chicken.png");
				Rectangle r = new Rectangle(100,100, 100, 100);
				if (r.contains(Peter.getxCoord(), Peter.getyCoord())) {
					System.out.println("sniped");
					continue;
					
				}
				badguys.add(bg);
			}
		}
		
		if (e.getKeyCode() == 32) { 
			Projectile bullet = new Projectile(Peter.getxCoord()+181,Peter.getyCoord()+30,100,100,"Files/Pawtuket.png");
			if (Peter.getFacing()<0) {
				bullet.setxCoord(Peter.getxCoord()+10);
			}
			bullet.setFacing(Peter.getFacing());
			bullets.add(bullet);
		}
		if (e.getKeyCode() == 10) {
			gameStarted = true;
		}
		
		Peter.moveIt(e.getKeyCode(),this.getWidth(), this.getHeight());
		repaint();
		
		for(int i = 0; i < badguys.size(); i++) {
			BadGuy bg = (BadGuy) badguys.get(i);
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
			if (r.contains(Peter.getxCoord(),Peter.getyCoord())) {
				System.out.println("Hit By Peter");
				badguys.remove(i);
			}
		repaint();
	}
}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}