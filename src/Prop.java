package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * ������
 * @author С��ħ
 * @date  2019/7/1
 */
public abstract class Prop{
	//������
	int positionX;
	//������
	int positionY;
	//���߸߶�
	int height;
	//���߿��
	int width;
	//ͼƬ
	ImageIcon imgProp;
	/**
	 * ��ȡ������
	 * @return
	 */
	public int getPositionX() {
		return positionX;
	}
	/**
	 * ���ú�����  
	 * @param positionX  ������
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	/**
	 * ��ȡ������
	 * @return
	 */
	public int getPositionY() {
		return positionY;
	}
	/**
	 * ����������
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	/**
	 * ��ȡ�߶�
	 * @return
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * ���õ��߸߶�
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * ��ȡ���߿��
	 * @return
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * ���õ��߿��
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * �����Լ�
	 */
	public abstract void display(Graphics g);
	/**
	 * �����Լ��ľ��ο�
	 */
	public abstract Rectangle getRect();
}
