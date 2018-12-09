package GG;

import java.awt.Image;
import java.awt.Toolkit;

public class GoodGuy {
	

	private int xCoord = 10;
	private int yCoord = 10;
	private int width = 10;
	private int height = 10;
	private Image img;
	public int facing = 0;
	

	/**
	 * GoodGuy default constructor
	 */
	public GoodGuy() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("Files/Peter.png");
	
	}

	/**
	 * GoodGuy overloaded constructor
	 * @param x initial x location
	 * @param y initial y location
	 * @param w initial width
	 * @param h initial height 
	 */
	public GoodGuy(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		
		System.out.println(imgpath);
		setImg(imgpath);
	}
	public GoodGuy(int x, int y, int w, int h, String imgpath, int facing) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		this.facing =facing;
		System.out.println(imgpath);
		setImg(imgpath);
	}
	public void moveIt(int direction, int w, int h) { 
		int speed = 20;
		int x = getxCoord();
		int y = getyCoord();
		if (direction == 39) { 
			x = x + speed;
			if (x > w) {x = x - speed * 3; }
			setxCoord (x);
			setImg("Files/Peter.png");
			setFacing(1);
		} else if (direction == 37) {
			if (x < 0) {x = x + speed * 3; }
			x = x - speed;
			setxCoord (x);
			setImg("Files/Peterleft.png");
			setFacing(-1);
		} else if (direction == 40) { 
			if (y > h - 10) { y = y - speed * 3; }
			y = y + speed;
			setyCoord (y);
			setImg("Files/Peter.png");
		} 
		else if (direction == 38) { 
			if (y < 0) { y = y + speed * 3; } 
			y = y - speed;
			setyCoord (y);
			setImg("Files/Peter.png");
		}
		
	}
		
		
		


	public void setImg(Image img) {
		this.img = img;
	}


	public void setImg(String imgpath) { 
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}


		public int getxCoord() {
			return xCoord;
		}


		public void setxCoord(int xCoord) {
			this.xCoord = xCoord;
		}
		
		public int getFacing() {
			return facing;
		}


		public void setFacing(int facing) {
			this.facing = facing;
		}


		public int getyCoord() {
			return yCoord;
		}


		public void setyCoord(int yCoord) {
			this.yCoord = yCoord;
		}


		public int getWidth() {
			return width;
		}


		public void setWidth(int width) {
			this.width = width;
		}


		public int getHeight() {
			return height;
		}


		public void setHeight(int height) {
			this.height = height;
		}


		public Image getImg() {
			return img;
		}

	
}