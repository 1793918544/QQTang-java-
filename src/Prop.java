package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 道具类
 * @author 小恶魔
 * @date  2019/7/1
 */
public abstract class Prop{
	//横坐标
	int positionX;
	//纵坐标
	int positionY;
	//道具高度
	int height;
	//道具宽度
	int width;
	//图片
	ImageIcon imgProp;
	/**
	 * 获取横坐标
	 * @return
	 */
	public int getPositionX() {
		return positionX;
	}
	/**
	 * 设置横坐标  
	 * @param positionX  横坐标
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	/**
	 * 获取纵坐标
	 * @return
	 */
	public int getPositionY() {
		return positionY;
	}
	/**
	 * 设置纵坐标
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	/**
	 * 获取高度
	 * @return
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * 设置道具高度
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * 获取道具宽度
	 * @return
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * 设置道具宽度
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * 绘制自己
	 */
	public abstract void display(Graphics g);
	/**
	 * 返回自己的矩形框
	 */
	public abstract Rectangle getRect();
}
