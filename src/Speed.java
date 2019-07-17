package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * ���ٶȵĵ�����
 * @author С��ħ
 * @date  2019/7/1
 */
public class Speed extends Prop{
	//�ٶȼӳ�
	int speed;
	//�ٶȼӳ�ͼƬ
	ImageIcon speedImg;
	/**
	 * �ٶȵ����๹�캯��
	 * @param positionX  ������
	 * @param positionY  ������
	 */
	public Speed(int positionX,int positionY){
		speed = 3;
		this.positionX	= positionX;
		this.positionY = positionY;
		this.width = Constant.PROP_WIDTH;
		this.height = Constant.PROP_HEIGHT;
	}
	/**
	 * �����Լ�
	 */
	public void display(Graphics g) {
		//��ȡ�ٶȼӳɵ���ͼƬ
		speedImg = Constant.imageMap.get("����2.png");
		
		g.drawImage(speedImg.getImage(), this.positionX, this.positionY, this.width, this.height, null);
	}
	/**
	 * ���ص��ߵľ��ο�
	 */
	public Rectangle getRect(){
		return new Rectangle(this.positionX + 20, this.positionY + 20, this.width - (this.width -5), this.height - (this.height - 5));
		
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}