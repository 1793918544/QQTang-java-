package com.yidu.QQTang.quantao;

import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * ��ͼש��������
 * @author С��ħ
 *
 */
public class Smash{
	//������
	int positionX;
	//������
	int positionY;
	//�߶�
	int Height;
	//���
	 int Width;
	//ͼƬ����
	 ImageIcon[] img = new ImageIcon[3];
	/**
	 * ���캯��
	 * @param positionX ������
	 * @param positionY ������
	 * @param mapHeight  �߶�
	 * @param mapWidth  ���
	 * @param mapImg   ͼƬ
	 */
	public Smash(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.Height = 43;
		this.Width = 43;
	}
	/**
	 * �����Լ�
	 */
	public void display(Graphics g){
		//��ȡש������ͼƬ
		for (int i = 1; i <= img.length; i++) {
			img[i-1] = Constant.imageMap.get("ש������"+i+".png");
		}
		g.drawImage(img[0].getImage(), this.positionX, this.positionY, this.Width, this.Height, null);
	}
	
}
