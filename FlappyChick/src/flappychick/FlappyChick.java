package flappychick;

import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;

public class FlappyChick extends PApplet {
	private ImageBall chick;
	private float upVelocity = -7;
	private int score = 0;
	private ArrayList<Rectangle> pipes = new ArrayList<Rectangle>();

	public void setup() {
		size(800, 600);
		chick = new ImageBall(this, width / 2, height / 2, 3);
		constructPipes();
	}

	public void draw() {
		background(Color.CYAN.getRGB());
		chick.display();
		chick.move();
		moveChickUp();

		for (Rectangle r : pipes) {
			r.display();
		}
		for (Rectangle r : pipes) {
			r.move();
		}
		gamePlay();
		fill(255);
		textSize(20);
		text("Score:" + score, 700, 50);
	}

	public void gamePlay() {
		for (int i = 0; i < pipes.size(); i++) {
			Rectangle r = pipes.get(i);
			if (chickHit(chick, r)) {
				r.setrColor(Color.RED);
				upVelocity=0;
				fill(255);
				textSize(20);
				text("GAME OVER",350,300);
				text("Press R to restart",330,500);
				for(Rectangle rect:pipes){
					rect.setVx(0);
				}
				
				if(keyPressed&& key== 'R'){
					chick.setxPos(width/2);
					chick.setyPos(height/2);
					for(Rectangle rect:pipes){
						rect.setVx(3);
						rect.setrColor(Color.GREEN);
					}
				}
				
			}
		}
		//score
	}

	public boolean chickHit(ImageBall chick, Rectangle p) {
		if (chick.getxPos() + chick.getSize() / 2 > p.getxPos()
				&& chick.getxPos() - chick.getSize() / 2 < p.getxPos()
						+ p.getrWidth()
				&& chick.getyPos() + chick.getSize() / 2 > p.getyPos()
				&& chick.getyPos() - chick.getSize() / 2 < p.getyPos()
						+ p.getrHeight()) {
			return true;
		} else {
			return false;
		}
	}

	private void constructPipes(){
		//construct pipes on top and bottom and add to arraylist
			for(int i=0;i<5;i++){
			pipes.add(new Rectangle(this,150*i,0, random(130,300), 3, Color.GREEN));
		}
		
		//bottom:try to make space between pipes set
		
		for(int i=0;i<5; i++){
			float rHeight= random(130,300);
			pipes.add(new Rectangle(this,150*i,height-rHeight,rHeight,3,Color.GREEN));
		}
	}

	public void moveChickUp() {
		if (keyPressed && key == ' ' || keyPressed && key == CODED
				&& keyCode == UP) {
			chick.setyPos(chick.getyPos() + upVelocity);
		}
	}

}
