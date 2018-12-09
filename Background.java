package GG;

import java.awt.Image;
import java.awt.Toolkit;

public class Background {
	
		// TODO Auto-generated constructor stub
	
	

		private int xCoord;
		private int yCoord;
		private int width;
		private int height;
		private Image img;
		
		public Background() {
			setxCoord(20);
			setyCoord(20);
			setWidth(30);
			setHeight(30);
			setImg("Files/Chicken.png");
	}

		public Background(int x, int y, int w, int h, String imgpath) {
			setxCoord(x);
			setyCoord(y);
			setWidth(w);
			setHeight(h);
			
			System.out.println(imgpath);
			setImg(imgpath);
			
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

	
