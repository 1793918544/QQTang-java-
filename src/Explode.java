package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * ��ը��
 * @author С��ħ
 *
 */
public class Explode extends Role{
	//���ݶ���
	Bubble bubble;
	//��ʱ��ը����
	int timer;
	//�ж��Ƿ񵽴ﱬը
	boolean isBomb = false;
	/**
	 * ���캯��
	 * @param positionX  ������
	 * @param positionY  ������
	 * @param bubble  ը��
	 */
	public Explode(int positionX,int positionY){
		this.height = Constant.BOOM_HEIGHT;
		this.width = Constant.BOOM_WIDTH;
		this.positionY = positionY;
		this.positionX = positionX;
	}
	public Explode(){
		
	}
	/**
	 * �����Լ�
	 */
	public void display(Graphics g) {
		//������ͼƬ��ȡ�������뼯����
		//��ը��һ��ͼƬ
		ImageIcon up1 = Constant.imageMap.get("1_��ը��.png");
		g.drawImage(up1.getImage(), this.positionX, this.positionY-this.height, this.width, this.height, null);
		
		ImageIcon down1 = Constant.imageMap.get("1_��ը��.png");
		g.drawImage(down1.getImage(), this.positionX, this.positionY+this.height, this.width, this.height, null);
		
		ImageIcon left1 = Constant.imageMap.get("1_��ը��.png");
		g.drawImage(left1.getImage(), this.positionX - this.width, this.positionY, this.width, this.height, null);
		
		ImageIcon right1 = Constant.imageMap.get("1_��ը��.png");
		g.drawImage(right1.getImage(), this.positionX + this.width, this.positionY, this.width, this.height, null);
		
		ImageIcon center = Constant.imageMap.get("��ը��.png");
		g.drawImage(center.getImage(), this.positionX, this.positionY, this.width, this.height, null);
		
		//��ը�ڶ���ͼƬ
		ImageIcon up2 = Constant.imageMap.get("2_��ը��.png");
		
		ImageIcon down2 = Constant.imageMap.get("2_��ը��.png");
		
		ImageIcon left2 = Constant.imageMap.get("2_��ը��.png");
		
		ImageIcon right2 = Constant.imageMap.get("2_��ը��.png");
		
		//��ը������ͼƬ
		ImageIcon up3 = Constant.imageMap.get("3_��ը��.png");
		
		ImageIcon down3 = Constant.imageMap.get("3_��ը��.png");
		
		ImageIcon left3 = Constant.imageMap.get("3_��ը��.png");
		
		ImageIcon right3 = Constant.imageMap.get("3_��ը��.png");
		
		//��ը����ͼƬ
		ImageIcon up4 = Constant.imageMap.get("��ը�϶���.png");
		
		ImageIcon down4 = Constant.imageMap.get("��ը�¶���.png");
		
		ImageIcon left4 = Constant.imageMap.get("��ը�󶥵�.png");
		
		ImageIcon right4 = Constant.imageMap.get("��ը�Ҷ���.png");
		
	}
	/**
	 *  ��ը�����ϵľ��ο�
	 * @return
	 */
	public Rectangle getUpRect(){
		return new Rectangle(this.positionX +10,this.positionY,this.width - 20,this.height );
	}
	/**
	 * ��ը�����µľ��ο�
	 * @return
	 */
	public Rectangle getDownRect(){
		return new Rectangle(this.positionX +10,this.positionY+(this.height),this.width - 10,this.height -10);
	}
	/**
	 * ��ը������ľ��ο�
	 * @return
	 */
	public Rectangle getLeftRect(){
		return new Rectangle(this.positionX - (this.width -20),this.positionY + 8,this.width -10,this.height - 15);
	}
	/**
	 * ��ը�����ҵľ��ο�
	 * @return
	 */
	public Rectangle getRightRect(){
		return new Rectangle(this.positionX + this.width /2,this.positionY + 15,this.width,this.height - 15);
	}
}
