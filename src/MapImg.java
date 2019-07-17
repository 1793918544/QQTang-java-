package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * ��ͼ�ϰ��������
 * @author С��ħ
 *
 */
public class MapImg {
	//ͼƬ��X����
	int positionX;
	//ͼƬ��Y����
	int positionY;
	//ͼƬ�ĸ߶�
	int mapHeight;
	//ͼƬ�Ŀ��
	int mapWidth;
	//��ͼ��ͼƬ
	ImageIcon mapImg;
	/**
	 * ��ͼ�ϰ�������๹�캯��
	 * @param positionX  ������
	 * @param positionY  ������
	 * @param mapHeight  ��ͼ�߶�
	 * @param mapWidth  ��ͼ���
	 * @param mapImg  ��ͼͼƬ
	 */
	public MapImg(int positionX,int positionY,int mapHeight,int mapWidth,ImageIcon mapImg){
		this.positionX = positionX;
		this.positionY = positionY;
		this.mapHeight = mapHeight;
		this.mapWidth = mapWidth;
		this.mapImg = mapImg;
	}
	/**
	 * �����Լ�
	 * @param g
	 */
	public void display(Graphics g){
		//�����Լ�
		g.drawImage(mapImg.getImage(), this.positionX, this.positionY, this.mapWidth, this.mapHeight, null);
	}
	/**
	 * ���ص�ͼ�ľ��ο�
	 * @return
	 */
	public Rectangle getRect(){
		return new Rectangle(this.positionX + 7, this.positionY + 10, this.mapWidth - 15, this.mapHeight - 10);
	}
}
