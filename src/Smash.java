package com.yidu.QQTang.quantao;

import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * 地图砖块破碎类
 * @author 小恶魔
 *
 */
public class Smash{
	//横坐标
	int positionX;
	//纵坐标
	int positionY;
	//高度
	int Height;
	//宽度
	 int Width;
	//图片数组
	 ImageIcon[] img = new ImageIcon[3];
	/**
	 * 构造函数
	 * @param positionX 横坐标
	 * @param positionY 纵坐标
	 * @param mapHeight  高度
	 * @param mapWidth  宽度
	 * @param mapImg   图片
	 */
	public Smash(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.Height = 43;
		this.Width = 43;
	}
	/**
	 * 绘制自己
	 */
	public void display(Graphics g){
		//获取砖块破碎图片
		for (int i = 1; i <= img.length; i++) {
			img[i-1] = Constant.imageMap.get("砖块破碎"+i+".png");
		}
		g.drawImage(img[0].getImage(), this.positionX, this.positionY, this.Width, this.Height, null);
	}
	
}
