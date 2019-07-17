package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 爆炸类
 * @author 小恶魔
 *
 */
public class Explode extends Role{
	//气泡对象
	Bubble bubble;
	//定时爆炸参数
	int timer;
	//判断是否到达爆炸
	boolean isBomb = false;
	/**
	 * 构造函数
	 * @param positionX  横坐标
	 * @param positionY  纵坐标
	 * @param bubble  炸弹
	 */
	public Explode(int positionX,int positionY){
		this.height = Constant.BOOM_HEIGHT;
		this.width = Constant.BOOM_WIDTH;
		this.positionY = positionY;
		this.positionX = positionX;
	}
	public Explode(){
		
	}
	/**
	 * 绘制自己
	 */
	public void display(Graphics g) {
		//将所有图片提取出来放入集合里
		//爆炸第一层图片
		ImageIcon up1 = Constant.imageMap.get("1_爆炸上.png");
		g.drawImage(up1.getImage(), this.positionX, this.positionY-this.height, this.width, this.height, null);
		
		ImageIcon down1 = Constant.imageMap.get("1_爆炸下.png");
		g.drawImage(down1.getImage(), this.positionX, this.positionY+this.height, this.width, this.height, null);
		
		ImageIcon left1 = Constant.imageMap.get("1_爆炸左.png");
		g.drawImage(left1.getImage(), this.positionX - this.width, this.positionY, this.width, this.height, null);
		
		ImageIcon right1 = Constant.imageMap.get("1_爆炸右.png");
		g.drawImage(right1.getImage(), this.positionX + this.width, this.positionY, this.width, this.height, null);
		
		ImageIcon center = Constant.imageMap.get("爆炸中.png");
		g.drawImage(center.getImage(), this.positionX, this.positionY, this.width, this.height, null);
		
		//爆炸第二层图片
		ImageIcon up2 = Constant.imageMap.get("2_爆炸上.png");
		
		ImageIcon down2 = Constant.imageMap.get("2_爆炸下.png");
		
		ImageIcon left2 = Constant.imageMap.get("2_爆炸左.png");
		
		ImageIcon right2 = Constant.imageMap.get("2_爆炸右.png");
		
		//爆炸第三层图片
		ImageIcon up3 = Constant.imageMap.get("3_爆炸上.png");
		
		ImageIcon down3 = Constant.imageMap.get("3_爆炸下.png");
		
		ImageIcon left3 = Constant.imageMap.get("3_爆炸左.png");
		
		ImageIcon right3 = Constant.imageMap.get("3_爆炸右.png");
		
		//爆炸顶点图片
		ImageIcon up4 = Constant.imageMap.get("爆炸上顶点.png");
		
		ImageIcon down4 = Constant.imageMap.get("爆炸下顶点.png");
		
		ImageIcon left4 = Constant.imageMap.get("爆炸左顶点.png");
		
		ImageIcon right4 = Constant.imageMap.get("爆炸右顶点.png");
		
	}
	/**
	 *  爆炸方向上的矩形框
	 * @return
	 */
	public Rectangle getUpRect(){
		return new Rectangle(this.positionX +10,this.positionY,this.width - 20,this.height );
	}
	/**
	 * 爆炸方向下的矩形框
	 * @return
	 */
	public Rectangle getDownRect(){
		return new Rectangle(this.positionX +10,this.positionY+(this.height),this.width - 10,this.height -10);
	}
	/**
	 * 爆炸方向左的矩形框
	 * @return
	 */
	public Rectangle getLeftRect(){
		return new Rectangle(this.positionX - (this.width -20),this.positionY + 8,this.width -10,this.height - 15);
	}
	/**
	 * 爆炸方向右的矩形框
	 * @return
	 */
	public Rectangle getRightRect(){
		return new Rectangle(this.positionX + this.width /2,this.positionY + 15,this.width,this.height - 15);
	}
}
