package com.yidu.QQTang.quantao;

import java.awt.Graphics;


/**
 * ��ɫ��  ������
 * @author С��ħ
 * @date  2019/7/1
 */
public abstract class Role {
	//�߶�
	int height;
	//���
	int width;
	// ������
	int positionX;
	// ������
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
	//�����Լ��ķ���
	public abstract void display(Graphics g);
	
}
