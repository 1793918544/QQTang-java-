package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 加速度的道具类
 * @author 小恶魔
 * @date  2019/7/1
 */
public class Speed extends Prop{
	//速度加成
	int speed;
	//速度加成图片
	ImageIcon speedImg;
	/**
	 * 速度道具类构造函数
	 * @param positionX  横坐标
	 * @param positionY  纵坐标
	 */
	public Speed(int positionX,int positionY){
		speed = 3;
		this.positionX	= positionX;
		this.positionY = positionY;
		this.width = Constant.PROP_WIDTH;
		this.height = Constant.PROP_HEIGHT;
	}
	/**
	 * 绘制自己
	 */
	public void display(Graphics g) {
		//获取速度加成道具图片
		speedImg = Constant.imageMap.get("道具2.png");
		
		g.drawImage(speedImg.getImage(), this.positionX, this.positionY, this.width, this.height, null);
	}
	/**
	 * 返回道具的矩形框
	 */
	public Rectangle getRect(){
		return new Rectangle(this.positionX + 20, this.positionY + 20, this.width - (this.width -5), this.height - (this.height - 5));
		
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}