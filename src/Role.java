package com.yidu.QQTang.quantao;

import java.awt.Graphics;


/**
 * 角色类  抽象类
 * @author 小恶魔
 * @date  2019/7/1
 */
public abstract class Role {
	//高度
	int height;
	//宽度
	int width;
	// 横坐标
	int positionX;
	// 纵坐标
	int positionY;
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getPotionX() {
		return positionX;
	}
	public void setPotionX(int potionX) {
		this.positionX = potionX;
	}
	public int getPotionY() {
		return positionY;
	}
	public void setPotionY(int potionY) {
		this.positionY = potionY;
	}
	//绘制自己的方法
	public abstract void display(Graphics g);
	
}
