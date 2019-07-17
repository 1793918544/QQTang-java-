package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * ���������� ������
 * @author С��ħ
 *
 */
public class Might extends Prop{
	//�����ӳ�
	int power;
	//ͼƬ
	ImageIcon mightImg;
	/**
	 * �������߹��캯��
	 * @param positionX  ������
	 * @param positionY  ������
	 */
	public Might(int positionX,int positionY){
		this.power = 1;
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = Constant.PROP_WIDTH;
		this.height = Constant.PROP_HEIGHT;
	}
	/**
	 * ��������ֵ
	 * @param power
	 */
	public void setPower(int power){
		this.power = power;
	}
	/**
	 * ��ȡ����
	 * @return
	 */
	public int getPower(){
		return power;
	}
	/**
	 * �����Լ�
	 */
	public void display(Graphics g) {
		//��ȡͼƬ
		mightImg = Constant.imageMap.get("����3.png");
		
		g.drawImage(mightImg.getImage(), this.positionX, this.positionY, this.width, this.height, null);
	}

	/**
	 * �����Լ��ľ��ο�
	 */
	public Rectangle getRect() {
		return new Rectangle(this.positionX + 20, this.positionY +20, this.width - (this.width - 5), this.height - (this.height -5));
	}
	
}
