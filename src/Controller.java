package com.yidu.QQTang.quantao;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * �������࣬ʵ���¼�����
 * @author С��ħ
 *
 */
public class Controller implements KeyListener{
	//���
	Player player;
	//���2
	Player players;
	//�ж��Ƿ��ȭ
	public static boolean b = false;
	/**
	 * �������๹�캯��
	 * @param player  ���һ
	 * @param players  ��Ҷ�
	 */ 
	public Controller(Player player,Player players){
		this.player = player;
		this.players = players;
		
	}
	/**
	 * �������޲ι��캯��
	 */
	public Controller(){
		
	}
	/*
	 * ���һ�İ����ж�
	 */
	boolean right1 = false; // �жϳ�ʼֵ
	boolean left1 = false;   //�жϳ�ʼֵ
	boolean up1 = false;   //�ж���ʼֵ
	boolean down1 = false;  //�жϳ�ʼֵ
	/*
	 * ��Ҷ��İ����ж�
	 */
	boolean right2 = false;
	boolean left2 = false;
	boolean up2 = false;
	boolean down2 = false;
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
//		//���1 ���ư���
		if (key == 'd') {
			right1 = true;  //�������d�ȱ�Ϊtrue
			player.right = true;
		}
//		if (right1 == true) {
//			player.moveRight();  //���������ƶ�����
//		}
		if (key == 'a') {
			left1 = true;
			player.left = true;
		}
//		if (left1 == true) {
//			player.moveLeft();  //���������ƶ�����
//		}
		if (key == 'w') {
			up1 = true;
			player.up = true;
		}
//		if (up1) {
//			player.moveUp();
//		}
		if (key == 's') {
			down1 = true;
			player.down = true;
		}
//		if (down1) {
//			player.moveDown();
//		}
//		if (key == 'j') {
//			player.attack();  //���ù����ķ���
//		}
//			//��Ҷ����ư���
			if (e.getKeyCode() == 38) {
				up2 = true;
				players.up = true;
			}
			
			if (e.getKeyCode() == 40) {
				down2 = true;
				players.down = true;
			}
			
			if (e.getKeyCode() == 37) {
				left2 = true;
				players.left = true;
			}
			
			if (e.getKeyCode() == 39) {
				right2 = true;
				players.right = true;
			}
//			if (up2) {
//				players.moveUp();
//			}
//			if (down2) {
//				players.moveDown();
//			}
//			if (left2) {
//				players.moveLeft();
//			}
//			if (right2) {
//				players.moveRight();
//			}
//			//��Ҷ���������
//			if (e.getKeyCode() == 17) {
//				players.attack();
//			}
		//���һ
		player.KeyPressed(e);
		//��Ҷ�
		players.KeyPressed2(e);
	}
	public void keyReleased(KeyEvent e) {
		//���һ
		player.KeyReleased(e);
		//��Ҷ�
		players.KeyReleased2(e);
		/*
		 * ֻҪ��һ�ɿ���run��״̬���ı�Ϊfalse,���ﲻ���ܶ���
		 * ����ܶ������а��·����ӵ�������Ϊ����runΪtrue,���Բ���Ӱ�졣
		 */
		
			if (e.getKeyChar() == 'd') {
				right1 = false;
				player.right = false;
			}
			if (e.getKeyChar() == 'a') {
				left1 = false;
				player.left = false;
			}
			if (e.getKeyChar() == 'w') {
				up1 = false;
				player.up = false;
			}
			if (e.getKeyChar() == 's') {
				down1 = false;
				player.down = false;
			}
		//��Ҷ�
		
		//��Ҷ������ж�
		if (e.getKeyCode() == 38) {
			up2 = false;
			players.up = false;
		}
		if (e.getKeyCode() == 40) {
			down2 = false;
			players.down = false;
		}
		if (e.getKeyCode() == 39) {
			right2 = false;
			players.right = false;
		}
		if (e.getKeyCode() == 37) {
			left2 = false;
			players.left = false;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}
}
