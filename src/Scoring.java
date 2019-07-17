package com.yidu.QQTang.quantao;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * �÷���
 * @author С��ħ
 * @date 2019/7/1
 */
public class Scoring {
	//ʱ������
	int time;
	//�÷���
	int score;
	//�ı�ʱ�丨������
	int k;
	//ͼƬ���
	int width;
	//ͼƬ�߶�
	int height;
	//�÷�ͼƬ����
	ImageIcon[] scoreImg = new ImageIcon[10];
	//���һ
	Player player;
	//��Ҷ�
	Player players;
	//ʱ���λͼƬ
	ImageIcon timeSingle;
	//ʱ��ʮλͼƬ
	ImageIcon timeTen;
	//ʱ���λͼƬ
	ImageIcon timeHundred;
	//���һ�÷ָ�λͼƬ
	ImageIcon playerSingle;
	//���һ�÷�ʮλͼƬ
	ImageIcon playerTen;
	//��Ҷ��÷ָ�λͼƬ
	ImageIcon playersSingle;
	//��Ҷ��÷�ʮλͼƬ
	ImageIcon playersTen;
	//��Ϸ���洰��
	JFrame gameFrame;
	//����
	boolean over;
	/**
	 * �÷��๹�캯��
	 * @param player  ���һ
	 * @param players  ��Ҷ�
	 * @param gameFrame  ��ʼ����
	 */
	public Scoring(Player player,Player players,JFrame gameFrame){
		this.time = 70;
		this.score = 0;
		this.k = 0;
		this.width = 50;
		this.height = 50;
		this.player = player;
		this.players = players;
		this.gameFrame = gameFrame;
		this.over = false;
		//ѭ����ȡ�÷�ͼƬ
		for (int i = 0; i < scoreImg.length; i++) {
			scoreImg[i] = Constant.imageMap.get("number"+i+".png");
		}
		//ʱ���λͼƬ��ʼͼƬ
		timeSingle = scoreImg[0];
		//ʱ��ʮλͼƬ��ʼͼƬ
		timeTen = scoreImg[0];
		//ʱ���λͼƬ��ʼͼƬ
		timeHundred = scoreImg[0];
		//���һ�÷ָ�λ����ʼͼƬ
		playerSingle = scoreImg[0];
		//���һ�÷�ʮλ����ʼͼƬ
		playerTen = scoreImg[0];
		//��Ҷ��÷ָ�λ����ʼͼƬ
		playersSingle = scoreImg[0];
		//��Ҷ��÷�ʮλ����ʼͼƬ
		playersTen = scoreImg[0];
	}
	/**
	 * �����Լ�
	 * @param g  ����
	 */
	public void display(Graphics g){
		//����ʱ���λͼƬ
		g.drawImage(timeHundred.getImage(), 1400, 30, this.width, this.height, null);
		//����ʱ��ʮλͼƬ
		g.drawImage(timeTen.getImage(), 1450, 30, this.width, this.height, null);
		//����ʱ���λͼƬ
		g.drawImage(timeSingle.getImage(), 1500, 30, this.width, this.height, null);
		//�������һ�÷ָ�λͼƬ
		g.drawImage(playerSingle.getImage(), 110, 45, this.width, this.height, null);
		//�������һ�÷�ʮλͼƬ
		g.drawImage(playerTen.getImage(), 70, 45, this.width, this.height, null);
		//������Ҷ��÷ָ�λͼƬ
		g.drawImage(playersSingle.getImage(), 550, 45, this.width, this.height, null);
		//������Ҷ��÷�ʮλͼƬ
		g.drawImage(playersTen.getImage(), 510, 45, this.width, this.height, null);
		k++;
		//��k ����50 ���� time ���� 0 
		if (k == 50 && time >0) {
			//ʱ�� --
			time--;
			//���ø���ʱ�䷽��
			updataTime();
			//���¸�ֵk = 0
			k = 0;
		}
		//���ø��µ÷���Ϣ
		updataScore();
		//��ʱ�����0��ʱ������˭ʤ��
		if (time == 0 ) {
			//��Ϸ������Ϣ
			String message = "";
			//��Ϸʱ������
			time = 600;
//			if (player.isOver) {
//				//����Ҷ���ʤ
//				message = "��ϲ�㣬��Ҷ����ʤ����";
//				over = true;
//			}else if (players.isOver) {
//				//����Ҷ���ʤ
//				message = "��ϲ�㣬���һ���ʤ����";
//				over = true;
//			//������һ����Ҷ��ķ������
//			}else 
			if (player.gold == players.gold) {
				//��ƽ��
				message = "���Ƕ��ܰ�Ӵ�����ƽ�֣�";
			//������һ�ķ���������Ҷ��ķ���
			}else if (player.gold > players.gold) {
				//�����һ��ʤ
				message = "��ϲ�㣬���һ���ʤ����";
			//�����Ҷ��ķ����������һ�ķ���
			}else if (player.gold < players.gold) {
				//����Ҷ���ʤ
				message = "��ϲ�㣬��Ҷ����ʤ����";
			}
			//���������һ�ʤ֮��Ľ�����ȵ���һ����Ϣ��
			JOptionPane.showConfirmDialog(null, message, "��Ϸ����", JOptionPane.PLAIN_MESSAGE);
		}
	}
	/**
	 * ���µ÷���Ϣ
	 */
	public void updataScore(){
		//ѭ���������һ�ĸ�λ�÷���Ϣ
		switch(player.gold %10){
		case 0:
			playerSingle = scoreImg[0];
			break;
		case 1:
			playerSingle = scoreImg[1];
			break;
		case 2:
			playerSingle = scoreImg[2];
			break;
		case 3:
			playerSingle = scoreImg[3];
			break;
		case 4:
			playerSingle = scoreImg[4];
			break;
		case 5:
			playerSingle = scoreImg[5];
			break;
		case 6:
			playerSingle = scoreImg[6];
			break;
		case 7:
			playerSingle = scoreImg[7];
			break;
		case 8:
			playerSingle = scoreImg[8];
			break;
		case 9:
			playerSingle = scoreImg[9];
			break;
		}
		//ѭ���������һ��ʮλ�÷���Ϣ
		switch(player.gold /10){
		case 0:
			playerTen = scoreImg[0];
			break;
		case 1:
			playerTen = scoreImg[1];
			break;
		case 2:
			playerTen = scoreImg[2];
			break;
		case 3:
			playerTen = scoreImg[3];
			break;
		case 4:
			playerTen = scoreImg[4];
			break;
		case 5:
			playerTen = scoreImg[5];
			break;
		case 6:
			playerTen = scoreImg[6];
			break;
		case 7:
			playerTen = scoreImg[7];
			break;
		case 8:
			playerTen = scoreImg[8];
			break;
		case 9:
			playerTen = scoreImg[9];
			break;
		}
		//ѭ��������Ҷ��ĸ�λ�÷���Ϣ
		switch(players.gold %10){
		case 0:
			playersSingle = scoreImg[0];
			break;
		case 1:
			playersSingle = scoreImg[1];
			break;
		case 2:
			playersSingle = scoreImg[2];
			break;
		case 3:
			playersSingle = scoreImg[3];
			break;
		case 4:
			playersSingle = scoreImg[4];
			break;
		case 5:
			playersSingle = scoreImg[5];
			break;
		case 6:
			playersSingle = scoreImg[6];
			break;
		case 7:
			playersSingle = scoreImg[7];
			break;
		case 8:
			playersSingle = scoreImg[8];
			break;
		case 9:
			playersSingle = scoreImg[9];
			break;
		}
		//ѭ���������һ��ʮλ�÷���Ϣ
		switch(players.gold /10){
		case 0:
			playersTen = scoreImg[0];
			break;
		case 1:
			playersTen = scoreImg[1];
			break;
		case 2:
			playersTen = scoreImg[2];
			break;
		case 3:
			playersTen = scoreImg[3];
			break;
		case 4:
			playersTen = scoreImg[4];
			break;
		case 5:
			playersTen = scoreImg[5];
			break;
		case 6:
			playersTen = scoreImg[6];
			break;
		case 7:
			playersTen = scoreImg[7];
			break;
		case 8:
			playersTen = scoreImg[8];
			break;
		case 9:
			playersTen = scoreImg[9];
			break;
		}
	}
	/**
	 * ����ʱ�䷽��
	 */
	public void updataTime(){
		//ʱ���λͼƬѭ������
		switch(time % 10){
		case 0:
			timeSingle = scoreImg[0];
			break;
		case 1:
			timeSingle = scoreImg[1];
			break;
		case 2:
			timeSingle = scoreImg[2];
			break;
		case 3:
			timeSingle = scoreImg[3];
			break;
		case 4:
			timeSingle = scoreImg[4];
			break;
		case 5:
			timeSingle = scoreImg[5];
			break;
		case 6:
			timeSingle = scoreImg[6];
			break;
		case 7:
			timeSingle = scoreImg[7];
			break;
		case 8:
			timeSingle = scoreImg[8];
			break;
		case 9:
			timeSingle = scoreImg[9];
			break;
		}
		//ʱ��ʮλͼƬѭ������
		switch(time /10 %10){
		case 0:
			timeTen = scoreImg[0];
			break;
		case 1:
			timeTen = scoreImg[1];
			break;
		case 2:
			timeTen = scoreImg[2];
			break;
		case 3:
			timeTen = scoreImg[3];
			break;
		case 4:
			timeTen = scoreImg[4];
			break;
		case 5:
			timeTen = scoreImg[5];
			break;
		case 6:
			timeTen = scoreImg[6];
			break;
		case 7:
			timeTen = scoreImg[7];
			break;
		case 8:
			timeTen = scoreImg[8];
			break;
		case 9:
			timeTen = scoreImg[9];
			break;
		}
		//ʱ���λͼƬѭ������
		switch(time /100){
		case 0:
			timeHundred = scoreImg[0];
			break;
		case 1:
			timeHundred = scoreImg[1];
			break;
		case 2:
			timeHundred = scoreImg[2];
			break;
		case 3:
			timeHundred = scoreImg[3];
			break;
		case 4:
			timeHundred = scoreImg[4];
			break;
		case 5:
			timeHundred = scoreImg[5];
			break;
		case 6:
			timeHundred = scoreImg[6];
			break;
		case 7:
			timeHundred = scoreImg[7];
			break;
		case 8:
			timeHundred = scoreImg[8];
			break;
		case 9:
			timeHundred = scoreImg[9];
			break;
		}
	}
}
