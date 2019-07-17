package com.yidu.QQTang.quantao;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * ������ ��ը����
 * @author С��ħ
 *
 */
public class Bubble {
	//���ݳ���
	int width;
	//���ݿ��
	int height;
	//���ݺ�����
	int positionX;
	//����������
	int positionY;
	//����ͼƬ
	ImageIcon bubbleImg;
	//���
	Player player;
	//��ըЧ��
	Explode explode;
	//��ʱ����
	int timer;
	//���ݱ�ը֮��ɾ�����ж�
	boolean isBomb = false;
	//�ж����
	boolean isPlayer = true;
	//��ըЧ������
	List<Explode> explodeList = new ArrayList<Explode>();
	//��ը����
	Music music;
	
	/**
	 * ���ݹ��캯�� 
	 * @param positionX  ������
	 * @param positionY  ������
	 * @param player  ���һ
	 * @param explodeList  ��ըЧ������
	 */
	public Bubble(int positionX,int positionY,Player player,List<Explode> explodeList){
		this.width = Constant.XIGUA_WIDTH;
		this.height = Constant.XIGUA_HEIGHT;
		this.positionX = positionX;
		this.positionY = positionY;
		this.player = player;
		this.explodeList = explodeList;
		explode = new Explode(this.positionX, this.positionY);
		//������ը��Ч
		music = new Music("src\\com\\yidu\\QQTang\\quantao\\Music\\bubbleBomb.wav");
	}
	/**
	 * ����ը��
	 * @param g ����
	 */
	public void display(Graphics g){
		//��ȡը��ͼƬ
		bubbleImg = Constant.imageMap.get("����1.png");
		timer++;
		if (timer < 150) {
			//��������ͼƬ
			g.drawImage(bubbleImg.getImage(), this.positionX, this.positionY, this.width, this.height, null);
		}
		if (timer >= 130 && timer < 148) {
			explode.display(g);
		}
		if (timer == 149) {
			for (Explode explode : explodeList) {
				explode.isBomb = true;
			}
			isBomb = true;
			//��ը����ը��ʱ��ȵ����ж�����ը����ҵķ���
			player.plyaerHitExplode();
			//����ը����ը�����ķ���
			music.startMusic();
		}
		if (timer >= 180) {
			explode = null;
		}
		
	}
}
