package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 加气泡威力 道具类
 * @author 小恶魔
 *
 */
public class Might extends Prop{
	//威力加成
	int power;
	//图片
	ImageIcon mightImg;
	/**
	 * 威力道具构造函数
	 * @param positionX  横坐标
	 * @param positionY  纵坐标
	 */
	public Might(int positionX,int positionY){
		this.power = 1;
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = Constant.PROP_WIDTH;
		this.height = Constant.PROP_HEIGHT;
	}
	/**
	 * 设置威力值
	 * @param power
	 */
	public void setPower(int power){
		this.power = power;
	}
	/**
	 * 获取威力
	 * @return
	 */
	public int getPower(){
		return power;
	}
	/**
	 * 绘制自己
	 */
	public void display(Graphics g) {
		//获取图片
		mightImg = Constant.imageMap.get("道具3.png");
		
		g.drawImage(mightImg.getImage(), this.positionX, this.positionY, this.width, this.height, null);
	}

	/**
	 * 返回自己的矩形框
	 */
	public Rectangle getRect() {
		return new Rectangle(this.positionX + 20, this.positionY +20, this.width - (this.width - 5), this.height - (this.height -5));
	}
	
}
