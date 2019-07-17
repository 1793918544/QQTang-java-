package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 道具类之加气泡数量
 * @author 小恶魔
 *
 */
public class Count extends Prop{
	int count;  //气泡数量
	ImageIcon imgHp; //图片
	/**
	 * 道具类构造函数
	 * @param positionX  横坐标
	 * @param positionY  纵坐标
	 */
	public Count(int positionX,int positionY) {
		this.count = 1;   //捡到就加一条命
		this.positionX = positionX;
		this.positionY = positionY;
		this.height = Constant.PROP_HEIGHT;
		this.width = Constant.PROP_WIDTH;
		
	}
	/**
	 * 画出道具
	 */
	public void display(Graphics g) {
		//获取加气泡图片
		imgHp = Constant.imageMap.get("道具1.png");
		
		g.drawImage(imgHp.getImage(), this.positionX, this.positionY, this.width, this.height, null);
	}
	
	/**
	 * 返回自己的矩形框
	 */
	public Rectangle getRect() {
		
		return new Rectangle(this.positionX +20, this.positionY + 20, this.width - (this.width - 5), this.height - (this.height -5));
	}
	
}
