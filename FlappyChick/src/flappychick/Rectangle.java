package flappychick;

import java.awt.Color;

import processing.core.PApplet;

public class Rectangle {
	private PApplet rApplet;
	private float xPos;
	private float yPos;
	private float rWidth;
	private float rHeight;
	private float vx;
	private Color rColor;
	//constructor
	public Rectangle(PApplet rApplet, float xPos, float yPos, float rHeight,
			float vx, Color rColor) {
		this.rApplet = rApplet;
		this.xPos = xPos;
		this.yPos = yPos;
		this.rHeight = rHeight;
		this.vx = vx;
		this.rColor = rColor;
		rWidth= 50;
	}
	
	public void display(){
		rApplet.fill(rColor.getRGB());
		rApplet.rect(xPos, yPos, rWidth, rHeight);
	}
	
	public void move(){
		xPos-=vx;
		if(xPos<0){
			xPos=rApplet.width;
			rColor=Color.GREEN;
		}
	}
	//getters and setters
	public float getxPos() {
		return xPos;
	}
	public float getyPos() {
		return yPos;
	}
	public float getrWidth() {
		return rWidth;
	}
	public float getrHeight() {
		return rHeight;
	}
	public float getVx() {
		return vx;
	}
	public Color getrColor() {
		return rColor;
	}
	public void setxPos(float xPos) {
		this.xPos = xPos;
	}
	public void setyPos(float yPos) {
		this.yPos = yPos;
	}
	public void setrWidth(float rWidth) {
		this.rWidth = rWidth;
	}
	public void setrHeight(float rHeight) {
		this.rHeight = rHeight;
	}
	public void setVx(float vx) {
		this.vx = vx;
	}
	public void setrColor(Color rColor) {
		this.rColor = rColor;
	}
	
}
