package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 金币道具类
 * @author 小恶魔
 * @date 2019/7/9
 */
public class Gold extends Prop{
	//金钱
	int money;
	//图片
	ImageIcon goldImg;
	/**
	 * 金币道具类构造函数
	 * @param positionX  横坐标
	 * @param positionY  纵坐标
	 */
	public Gold(int positionX,int positionY){
		this.money = 0;
		this.positionX	= positionX;
		this.positionY = positionY;
		this.width = Constant.PROP_WIDTH;
		this.height = Constant.PROP_HEIGHT;
	}
	/**
	 * 绘制金币图片
	 */
	public void display(Graphics g) {
		//获取金币图片
		goldImg = Constant.imageMap.get("gold.png");
		//画出自己
		g.drawImage(goldImg.getImage(), this.positionX, this.positionY, this.width, this.height, null);
	}

	/**
	 * 返回金币道具的矩形框
	 */
	public Rectangle getRect() {
		return new Rectangle(this.positionX + 20, this.positionY + 20, this.width - (this.width -5), this.height - (this.height - 5));
	}
	
}
