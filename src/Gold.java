package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * ��ҵ�����
 * @author С��ħ
 * @date 2019/7/9
 */
public class Gold extends Prop{
	//��Ǯ
	int money;
	//ͼƬ
	ImageIcon goldImg;
	/**
	 * ��ҵ����๹�캯��
	 * @param positionX  ������
	 * @param positionY  ������
	 */
	public Gold(int positionX,int positionY){
		this.money = 0;
		this.positionX	= positionX;
		this.positionY = positionY;
		this.width = Constant.PROP_WIDTH;
		this.height = Constant.PROP_HEIGHT;
	}
	/**
	 * ���ƽ��ͼƬ
	 */
	public void display(Graphics g) {
		//��ȡ���ͼƬ
		goldImg = Constant.imageMap.get("gold.png");
		//�����Լ�
		g.drawImage(goldImg.getImage(), this.positionX, this.positionY, this.width, this.height, null);
	}

	/**
	 * ���ؽ�ҵ��ߵľ��ο�
	 */
	public Rectangle getRect() {
		return new Rectangle(this.positionX + 20, this.positionY + 20, this.width - (this.width -5), this.height - (this.height - 5));
	}
	
}
