package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * ������֮����������
 * @author С��ħ
 *
 */
public class Count extends Prop{
	int count;  //��������
	ImageIcon imgHp; //ͼƬ
	/**
	 * �����๹�캯��
	 * @param positionX  ������
	 * @param positionY  ������
	 */
	public Count(int positionX,int positionY) {
		this.count = 1;   //�񵽾ͼ�һ����
		this.positionX = positionX;
		this.positionY = positionY;
		this.height = Constant.PROP_HEIGHT;
		this.width = Constant.PROP_WIDTH;
		
	}
	/**
	 * ��������
	 */
	public void display(Graphics g) {
		//��ȡ������ͼƬ
		imgHp = Constant.imageMap.get("����1.png");
		
		g.drawImage(imgHp.getImage(), this.positionX, this.positionY, this.width, this.height, null);
	}
	
	/**
	 * �����Լ��ľ��ο�
	 */
	public Rectangle getRect() {
		
		return new Rectangle(this.positionX +20, this.positionY + 20, this.width - (this.width - 5), this.height - (this.height -5));
	}
	
}
