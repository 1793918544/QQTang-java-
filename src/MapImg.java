package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 地图障碍物抽象类
 * @author 小恶魔
 *
 */
public class MapImg {
	//图片的X坐标
	int positionX;
	//图片的Y坐标
	int positionY;
	//图片的高度
	int mapHeight;
	//图片的宽度
	int mapWidth;
	//地图的图片
	ImageIcon mapImg;
	/**
	 * 地图障碍物抽象类构造函数
	 * @param positionX  横坐标
	 * @param positionY  纵坐标
	 * @param mapHeight  地图高度
	 * @param mapWidth  地图宽度
	 * @param mapImg  地图图片
	 */
	public MapImg(int positionX,int positionY,int mapHeight,int mapWidth,ImageIcon mapImg){
		this.positionX = positionX;
		this.positionY = positionY;
		this.mapHeight = mapHeight;
		this.mapWidth = mapWidth;
		this.mapImg = mapImg;
	}
	/**
	 * 绘制自己
	 * @param g
	 */
	public void display(Graphics g){
		//画出自己
		g.drawImage(mapImg.getImage(), this.positionX, this.positionY, this.mapWidth, this.mapHeight, null);
	}
	/**
	 * 返回地图的矩形框
	 * @return
	 */
	public Rectangle getRect(){
		return new Rectangle(this.positionX + 7, this.positionY + 10, this.mapWidth - 15, this.mapHeight - 10);
	}
}
