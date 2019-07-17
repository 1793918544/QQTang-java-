package com.yidu.QQTang.quantao;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * ����̨,��Ϸ�����,���Ƹ��ֶ���ͼ��
 * @author С��ħ
 *	@date��2019 - 7 - 1
 */
public class GamePanel extends JPanel{
	//�߶�
	int height;
	//���
	int width;
	//����ͼƬ
	ImageIcon bgimage;
	//��ͼ����ͼƬ
	ImageIcon mapBgimage;
	//���
	Player player;
	//���2
	Player players;
	//�ϰ���ľ��ο�
	Rectangle mapRect;
	//ը��
	Bubble bubble;
	//����
	Prop props;
	//���߼���
	List<Prop> propList = new ArrayList<Prop>();
	//��������
	Count count;
	//������󼯺�
	List<MapImg> mapList = new ArrayList<MapImg>(); 
	//�ֱ��壺��ש����ש����ƿ��������
	MapImg brick1,brick2,vase,cactus;
	//�÷���ʱ��
	Scoring scoring;
	//��ά�����ͼ
	int[][] map = null;
	//����
	Music music;
	/**
	 * ���캯������ʼ������
	 * @param player ���
	 * @param props ����
	 * @param mapList  ��ͼ����
	 * @param count  ��������
	 * @param brick1  ��ͼ - ��ש��
	 * @param brick2  ��ͼ - ��ש��
	 * @param vase  ��ƿ
	 * @param cactus  ������
	 * @param propList  ���߼���
	 * @param players  ��Ҷ�
	 * @param scoring �÷���ʱ��
	 */
	public GamePanel(Player player,
			List<Prop> props,List<MapImg> mapList,
			Count count,MapImg brick1,MapImg brick2,
			MapImg vase,MapImg cactus,int[][] map,
			List<Prop> propList,Player players,Scoring scoring){
		
		this.height = Constant.GAMEPANEL_HEIGHT;  //��̨�߶�
		this.width = Constant.GAMEPANEL_WIDTH;	//��̨���
		this.player = player;   //���
		this.mapList = mapList;  //��ͼ����
		this.count = count;  //��������
		this.propList = propList;  //���߼���
		this.players = players;  //��Ҷ�
		this.scoring = scoring;  //�÷�
		//�������ֶ��� ��ʰȡ����
		music = new Music("src\\com\\yidu\\QQTang\\quantao\\Music\\getGoods.wav");
		//�������̻߳���ˢ��
		GameThread gameThread = new GameThread();
		//�������̶߳���
		Thread thread = new Thread(gameThread);
		//���÷������������߳�
		thread.start();
	}
	/**
	 * ��Ϸ����޲ι��캯��
	 */
	public GamePanel(){
		
	}
	
	/**
	 * ���ƴ�������
	 * g  ����
	 */
	public void paintComponent(final Graphics g) {
		
		//���Ʊ�������
		drawBackground(g);
		
		//��������
		drawProp(g);
		
		//���Ƶ�ͼ
		drawMap(g);
		
		//������ҵ�ը��
		drawBomb(g);
		
		//�������
		drawmeme(g);
		
		//������ݱ�ը��ײ�ϰ���ϰ������ʧ
		bubbleHitmap(g);
		
		//�����ײ���������Լӳ�
		playerHitProp();
		
		//�����ײ����������ı�ըЧ��
		playerHitExplode();
		
		//��Ϸ����
		if (player.isOver || players.isOver) {
			//����gameOver 
			gameOver(g);
		}
		
		//����ʱ����÷���Ϣ
		drawTime(g);
	}
	/**
	 * ���Ƹ���ʱ����Ϣ
	 * @param g  ����
	 */
	private void drawTime(Graphics g) {
		//���õ÷� ��display����
		scoring.display(g);
	}
	/**
	 * ������Ϸ����
	 * @param g ����
	 */
	private void gameOver(Graphics g) {
		//��ȡ��Ϸ����ͼƬ
		ImageIcon gameOverImg = Constant.imageMap.get("gameover.png");
		//������Ϸ������ͼƬ
		g.drawImage(gameOverImg.getImage(), 550, 370, 500, 89, null);
	}
	/**
	 * �����ײ����������ı�ըЧ��
	 */
	private void playerHitExplode() {
		//���һ �� ��Ҷ������ڿ�
		if (player != null && players != null) {
			//��ȡ���һ�ľ��ο�
			Rectangle playerRect = player.getRect();
			//��ȡ��Ҷ��ľ��ο�
			Rectangle playersRect = players.getRect();
			//���һ�ı�ըЧ�������ڿ�
			if (player.explode != null) {
				//��ȡ���һ��ըЧ�������ϵľ��ο�
				Rectangle upRect =  player.explode.getUpRect();
				//��ȡ���һ��ըЧ�������µľ��ο�
				Rectangle downRect = player.explode.getDownRect();
				//��ȡ���һ��ըЧ��������ľ��ο�
				Rectangle leftRect = player.explode.getLeftRect();
				//��ȡ���һ��ըЧ�������ҵľ��ο�
				Rectangle rightRect = player.explode.getRightRect();
				//������һ��ը���ı�ըЧ������ isbomb  Ϊtrue ��ִ�����´���
				if (player.bubble.isBomb) {
					//�����Ҷ����ο������һ�ı�ը������ľ��ο��ص�
					if (playersRect.intersects(upRect) || playersRect.intersects(downRect) || playersRect.intersects(leftRect) || playersRect.intersects(rightRect)) {
						//��Ҷ��� isOver ��Ϊtrue
						players.isOver = true;
						//���һ��ը����ըЧ����Ϊ null
						player.explode = null;
					}else {  //���û��ը�����һ��ը��Ч������ ��Ϊ��
						player.explode = null;
					}
				}
			}
			//��Ҷ��ı�ըЧ�������ڿ�
			if (players.explode != null) {
				//��ȡ��Ҷ�ը�������ϵľ��ο�
				Rectangle upRect2 =  players.explode.getUpRect();
				//��ȡ��Ҷ�ը�������µľ��ο�
				Rectangle downRect2 = players.explode.getDownRect();
				//��ȡ��Ҷ�ը��������ľ��ο�
				Rectangle leftRect2 = players.explode.getLeftRect();
				//��ȡ��Ҷ�ը�������ҵľ��ο�
				Rectangle rightRect2 = players.explode.getRightRect();
				//�����Ҷ���ը���ı�ըЧ������ isbomb  Ϊtrue ��ִ�����´���
				if (players.bubble.isBomb) {
					//�����Ҷ����ο������һ�ı�ը������ľ��ο��ص�
					if (playerRect.intersects(upRect2) || playerRect.intersects(downRect2) || playerRect.intersects(leftRect2) || playerRect.intersects(rightRect2)) {
						//���һ�� isOver ��Ϊtrue
						player.isOver = true;
						//��Ҷ���ը����ըЧ����Ϊ null
						players.explode = null;
					}else {  //���û��ը����Ҷ���ը��Ч������ ��Ϊ��
						players.explode = null;
					}
				}
			}
		}
	}
	/**
	 * �����ײ����
	 */
	private void playerHitProp() {
		//��ȡ���һ�ľ��ο�
		Rectangle playerRect = player.getRect();
		//��ȡ��Ҷ��ľ��ο�
		Rectangle playersRect = players.getRect();
		//���߾��ο�
		Rectangle propRect = null;
		//��ȡ���е��ߵľ��ο�
		for (int i = 0; i < propList.size(); i++) {
			//���߾��ο򱣴� ѭ�������ĵ��߼��� propList (���߼���)
			propRect = propList.get(i).getRect();
			//�ж����һ�������ײ
			if (playerRect.intersects(propRect)) {
				//�����ײ�ĵ�������Speed
				if (propList.get(i) instanceof Speed) {
					//���һ���ٶ����� +1
					player.setSpeed(player.getSpeed() + 1);
				//�����Ҷ�����ײ�ĵ������� Gold �ȼ���Ҷ��Ľ��ֵ
				}else if (propList.get(i) instanceof Gold) {
					//���һ�Ľ������ +1
					player.setGold(player.getGold() + 1);
				}
				//�����˵���ͬʱ�ѵ����Ƴ�
				propList.remove(i);
				//���ò�������
				music.startMusic();
				
				
				//��Ҷ��������ײ
			}else if (playersRect.intersects(propRect)) { 
				//�����ײ�ĵ�������Speed
				if (propList.get(i) instanceof Speed) { 
					//��Ҷ����ٶ����� +1
					players.setSpeed(players.getSpeed() + 1);
					//�����Ҷ�����ײ�ĵ������� Gold �ȼ���Ҷ��Ľ��ֵ
				}else if (propList.get(i) instanceof Gold) {
					//��Ҷ��Ľ������ +1
					players.setGold(players.getGold() + 1);
				}
				//�����˵���ͬʱ�ѵ����Ƴ�
				propList.remove(i);
				
				//���ò�������
				music.startMusic();
			}
		}
	}

	/**
	 * �������е���
	 * @param g  ����
	 */
	private void drawProp(Graphics g) {
		//ѭ����������(propList)����
		for (int i = 0; i < propList.size(); i++) {
			//���õ��߼�����ÿһ��display�ķ���
			propList.get(i).display(g);
		}
	}

	/**
	 * ������ݱ�ը��ײ���ϰ���
	 * @param g  ����
	 */
	private void bubbleHitmap(Graphics g) {
		//���һ��ը��������null ���� ���һ��ը����ըЧ��������null
		if (player.bubble != null && player.bubble.explode != null) {  //���һ
			//��ȡ���һը���ı�ըЧ�������ϵľ��ο�
			Rectangle upRect =  player.bubble.explode.getUpRect();
			//��ȡ���һը���ı�ըЧ�������µľ��ο�
			Rectangle downRect = player.bubble.explode.getDownRect();
			//��ȡ���һը���ı�ըЧ��������ľ��ο�
			Rectangle leftRect = player.bubble.explode.getLeftRect();
			//��ȡ���һը���ı�ըЧ�������ҵľ��ο�
			Rectangle rightRect = player.bubble.explode.getRightRect();
			//ѭ�������ϰ��Ｏ��
			for (int j = 0; j < mapList.size(); j++) {
				//�� mapRect ����mapList ����ÿһ�����ο�
				mapRect = mapList.get(j).getRect();
				//�ж�������ݱ�ը��ײ�ϰ���
				if (upRect.intersects(mapRect) || downRect.intersects(mapRect) || leftRect.intersects(mapRect) || rightRect.intersects(mapRect)){
					//�����ݱ�ը֮��Ȱ��ϰ������Ӽ������Ƴ�
					if (player.bubble.isBomb) {
						//�Ƴ��ϰ���
						mapList.remove(j);
					}
				}
			}
		}
		//��Ҷ���ը��������null ���� ��Ҷ���ը����ըЧ��������null
		if (players.bubble != null && players.bubble.explode != null) {  //��Ҷ�
			//��ȡ��Ҷ�ը���ı�ըЧ�������ϵľ��ο�
			Rectangle upRect =  players.bubble.explode.getUpRect();
			//��ȡ��Ҷ�ը���ı�ըЧ�������µľ��ο�
			Rectangle downRect = players.bubble.explode.getDownRect();
			//��ȡ��Ҷ�ը���ı�ըЧ��������ľ��ο�
			Rectangle leftRect = players.bubble.explode.getLeftRect();
			//��ȡ��Ҷ�ը���ı�ըЧ�������ҵľ��ο�
			Rectangle rightRect = players.bubble.explode.getRightRect();
			//ѭ�������ϰ��Ｏ��
			for (int i = 0; i < mapList.size(); i++) {
				//�� mapRect ����mapList ����ÿһ�����ο�
				mapRect = mapList.get(i).getRect();
				//�ж�������ݱ�ը��ײ�ϰ���
				if (upRect.intersects(mapRect) || downRect.intersects(mapRect) || leftRect.intersects(mapRect) || rightRect.intersects(mapRect)) {
					//�����ݱ�ը֮��Ȱ��ϰ������Ӽ������Ƴ�
					if (players.bubble.isBomb) {
						//�Ƴ��ϰ���
						mapList.remove(i);
						//��Ҷ�ը���ı�ըЧ��Ϊnull
						players.bubble.explode = null;
					}
				}
			}
		}
	}

	/**
	 * �������ݼ���
	 * @param g  ����
	 */
	private void drawBomb(Graphics g) {
		//���һը�����ϲ����� 0 
		if (player.bubbleList.size() != 0) {
			//ѭ���������һ��ը������
			for (Bubble bubble : player.bubbleList) {
				//����ը�������display����
				bubble.display(g);
			}
		}
		//���һ��ը�����ϴ��� 0 
		if (player.bubbleList.size() > 0) {
			//����ըЧ�������󼴿ɰѼ��������ݶ����Ƴ����л���
			for (int i = 0; i < player.bubbleList.size(); i++) {
				//������һ��ը�����϶������isbomb Ϊtrue ��ִ�����´���
				if (player.bubbleList.get(i).isBomb) {
					//���һ ���Ƴ����һը��������л���
					player.bubbleList.remove(i);
					//���һ��count �������� ++
					player.count++;
				}
			}
		}
		//��Ҷ�ը�����ϲ����� 0 
		if (players.bubbleList.size() != 0) {
			//ѭ��������Ҷ���ը������
			for (Bubble bubble : players.bubbleList) {
				//����ը�������display����
				bubble.display(g);
			}
		}
		//��Ҷ���ը�����ϴ��� 0 
		if (players.bubbleList.size() > 0) {
			//����ըЧ�������󼴿ɰѼ��������ݶ����Ƴ����л���
			for (int i = 0; i < players.bubbleList.size(); i++) {
				//�����Ҷ���ը�����϶������isbomb Ϊtrue ��ִ�����´���
				if (players.bubbleList.get(i).isBomb) {
					//��Ҷ� ���Ƴ���Ҷ�ը��������л���
					players.bubbleList.remove(i);
					//��Ҷ���count �������� ++
					players.count++;
				}
			}
		}
		
	}
	/**
	 * �������
	 * @param g  ����
	 */
	private void drawmeme(Graphics g) {
		//������һ�� isOver Ϊfalse
		if (!player.isOver) {
			//�������1
			player.display(g);
		}
		//�����Ҷ��� isOver Ϊfalse
		if (!players.isOver) {
			//�������2
			players.display(g);
		}
	}
	/**
	 * ���Ƶ�ͼ
	 * @param g  ����
	 */
	private void drawMap(Graphics g) {
		//����ϰ��Ｏ����������0
		if (mapList.size() > 0) {
			//ѭ�������ϰ��Ｏ��
			for (MapImg mapImg : mapList) {
				//�����ϰ���
				mapImg.display(g);
			}
		}
	}
	/**
	 *  ���Ʊ���
	 *  @param g  ����
	 */
	private void drawBackground(Graphics g) {
		//��ȡ�Ʒ�ͼ
		ImageIcon scoreImg = Constant.imageMap.get("score.png");
		//�����Ʒ�ͼ
		g.drawImage(scoreImg.getImage(), 0, 0, 1600, 122, null);
		//��ȡ����ͼƬ
		ImageIcon mapImg = Constant.imageMap.get("backDrop0.png");
		//ѭ��20�� 
		for (int i = 0; i < 20; i++) {
			//ѭ��10��
			for (int j = 0; j < 10; j++) {
				//������ͼ��
				g.drawImage(mapImg.getImage(), i*150, j*150 + 122, 150, 150, null);
			}
		}
	}
	/**
	 * ��������ɫ��ʾ
	 */
	public void showAll(){
		//���û������ˢ�»���
		this.repaint();
	}
	/**
	 * ���߳�ˢ�´���
	 * @author ȫ��
	 *
	 */
	class GameThread implements Runnable{
		public void run() {
			//����ѭ��
			while(true){
				//���ý�ɫ��ʾ����
				showAll();
				try {
					//���� 20 ����
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
