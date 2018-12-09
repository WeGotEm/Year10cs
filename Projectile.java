package GG;

import java.awt.Image;
import java.awt.Toolkit;

public class Projectile {
	private float xCoord;
	private int yCoord;
	private int width;
	private int height;
	private Image img;
	public int facing = 1;
	
	public Projectile() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("Files/Chicken.png");
}

	public Projectile(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		
		System.out.println(imgpath);
		setImg(imgpath);
	}
	
	public int getFacing() {
		return facing;
	}


	public void setFacing(int facing) {
		this.facing = facing;
	}

	public void setImg(Image img) {
		this.img = img;
	}


	public void setImg(String imgpath) { 
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}


		public float getxCoord() {
			return this.xCoord;
		}


		public void setxCoord(double d) {
			this.xCoord = xCoord;
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

		public void setxCoord(float xCoord) {
			this.xCoord = xCoord;
		}


}
