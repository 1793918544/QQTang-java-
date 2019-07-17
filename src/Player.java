package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


/**
 * �����
 * @author С��ħ
 * @date  2019/7/1
 */
public class Player extends Role{
	//���ͼƬ
	ImageIcon imgs;
	//�������ж�
	boolean right = false;
	//�������ж�
	boolean left = false;
	//�������ж�
	boolean down = false;
	//�������ж�
	boolean up = false;
	//�����ٶ� X��Y �ٶ�
	int speed;
	//������ͼƬ����
	ImageIcon[] zuo = new ImageIcon[4];
	//������ͼƬ����
	ImageIcon[] you = new ImageIcon[4];
	//������ͼƬ����
	ImageIcon[] upImg = new ImageIcon[4];
	//������ͼƬ����
	ImageIcon[] downImg = new ImageIcon[4];
	//������ͼƬ��Ƶ�ʲ���
	int leftNum = 0,rightNum = 0,upNum = 0,downNum = 0;
	//װ���ݵļ���
	List<Bubble> bubbleList = new ArrayList<Bubble>();
	//ͬʱ�ɷ����ݵ�����
	int count;
	//���ݶ���
	Bubble bubble;
	//���
	int gold;
	//�Ϸ���ײ����
	boolean hitUp = false;
	//�·���ײ����
	boolean hitDown = false;
	//�ҷ���ײ��ʽ
	boolean hitRight = false;
	//����ײ����
	boolean hitLeft = false;
	//hit������������ı���
	String direUp = "up",direDown = "down",direLeft = "left",direRight = "right";
	//������󼯺�
	List<MapImg> mapList = new ArrayList<MapImg>(); 
	//��֮ǰ������ֵ
	int oidPositionX,oidPositionY;
	//��ըЧ��
	Explode explode;
	//�Ƿ�ը
	boolean isBomb = false;
	//�ֿ����
	boolean isPlayer;
	//�Ƿ����
	boolean isOver = false;
	//��������
	boolean bL = false,bU = false,bR = false,bD = false;
	//��ըЧ������
	List<Explode> explodeList = new ArrayList<Explode>();
	/** 
	 * ��ʼ���� 
	 */ 
	private Directions dir = Directions.STOP;
	/**
	 * ���һ�Ĺ��캯��
	 * @param positionX  ������
	 * @param positionY  ������
	 * @param mapList   �ϰ��Ｏ��
	 */
	public Player(int positionX,int positionY,List<MapImg> mapList){
		this.height = Constant.MEME_HEIGHT;
		this.width = Constant.MEME_WIDTH;
		this.positionX = positionX;
		this.positionY = positionY;
		this.count = 1;
		this.speed = 2;
		this.mapList = mapList;
		this.oidPositionX = this.positionX;
		this.oidPositionY = this.positionY;
		this.isPlayer = true;
		this.gold = 0;
	}
	/**
	 * ��Ҷ��Ĺ��캯��
	 * @param positionX  ������
	 * @param positionY  ������
	 * @param mapList  �ϰ��Ｏ��
	 * @param isPlayer  �Ƿ�Ϊ���һ����Ҷ�
	 */
	public Player(int positionX,int positionY,List<MapImg> mapList,boolean isPlayer){
		this.height = Constant.MEME_HEIGHT;
		this.width = Constant.MEME_WIDTH;
		this.positionX = positionX;
		this.positionY = positionY;
		this.count = 1;
		this.speed = 2;
		this.isPlayer = isPlayer;
		this.mapList = mapList;
		this.oidPositionX = this.positionX;
		this.oidPositionY = this.positionY;
		this.gold = 0;
	}
	/**
	 * ��ȡ�ٶ�
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * ��ֵ�ٶ�
	 * @param speed  �ٶ�
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * ��ȡ���
	 * @return
	 */
	public int getGold(){
		return gold;
	}
	/**
	 * ��ֵ���
	 * @param gold ���
	 */
	public void setGold(int gold){
		this.gold = gold;
	}
	/**
	 * �����Լ�
	 */
	public void display(Graphics g) {
		//���1
		if (isPlayer) {
			//������
			if (left) {
				for (int i = 1; i <= 4; i++) {
					//ѭ����ͼƬ��ȡ����
					zuo[i-1] = Constant.imageMap.get("SunZuo"+i+".png");
				}  //������ͼƬ����
				if (leftNum < 3) {
					g.drawImage(zuo[0].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 5) {
					g.drawImage(zuo[1].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 7) {
					g.drawImage(zuo[2].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 9) {
					g.drawImage(zuo[3].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}
			}else if (right) {    //������
				for (int i = 1; i <= 4; i++) {
					//ѭ����ͼƬ��ȡ����
					you[i-1] = Constant.imageMap.get("SunYou"+i+".png");
				}  //������ͼƬ����
				if (rightNum < 3) {
					g.drawImage(you[0].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (rightNum < 5) {
					g.drawImage(you[1].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (rightNum < 7) {
					g.drawImage(you[2].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (rightNum < 9) {
					g.drawImage(you[3].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}
			}else if (up) {
				for (int i = 1; i <= 4; i++) {
					//ѭ����ͼƬ��ȡ����
					upImg[i-1] = Constant.imageMap.get("SunHou"+i+".png");
				}
				if (upNum <3) {
					g.drawImage(upImg[0].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (upNum < 6) {
					g.drawImage(upImg[1].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (upNum < 7) {
					g.drawImage(upImg[2].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (upNum < 9) {
					g.drawImage(upImg[3].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}
			}else if(down){
				for (int i = 1; i <= 4; i++) {
					//ѭ����ͼƬ��ȡ����
					downImg[i-1] = Constant.imageMap.get("SunQian"+i+".png");
				}
				if (downNum < 3) {
					g.drawImage(downImg[0].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (downNum < 5) {
					g.drawImage(downImg[1].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (downNum < 7) {
					g.drawImage(downImg[2].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (downNum < 9) {
					g.drawImage(downImg[3].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}
			}else {
				imgs = Constant.imageMap.get("SunQian1.png");
				//������ҽ�ɫ
				g.drawImage(imgs.getImage(), this.positionX, this.positionY, this.width, this.height, null);
			}
			//���2
		}else if (!isPlayer) {
			//������
			if (left) {
				for (int i = 1; i <= 4; i++) {
					//ѭ����ͼƬ��ȡ����
					zuo[i-1] = Constant.imageMap.get("left"+i+".png");
				}  //������ͼƬ����
				if (leftNum < 3) {
					g.drawImage(zuo[0].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 5) {
					g.drawImage(zuo[1].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 7) {
					g.drawImage(zuo[2].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 9) {
					g.drawImage(zuo[3].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}
				}else if (right) {    //������
					for (int i = 1; i <= 4; i++) {
						//ѭ����ͼƬ��ȡ����
						you[i-1] = Constant.imageMap.get("right"+i+".png");
					}  //������ͼƬ����
					if (rightNum < 3) {
						g.drawImage(you[0].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}else if (rightNum < 5) {
						g.drawImage(you[1].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}else if (rightNum < 7) {
						g.drawImage(you[2].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}else if (rightNum < 9) {
						g.drawImage(you[3].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}
				}else if (up) {
					for (int i = 1; i <= 4; i++) {
						//ѭ����ͼƬ��ȡ����
						upImg[i-1] = Constant.imageMap.get("up"+i+".png");
					}
					if (upNum <3) {
						g.drawImage(upImg[0].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}else if (upNum < 6) {
						g.drawImage(upImg[1].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}else if (upNum < 7) {
						g.drawImage(upImg[2].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}else if (upNum < 9) {
						g.drawImage(upImg[3].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}
				}else if(down){
					for (int i = 1; i <= 4; i++) {
						//ѭ����ͼƬ��ȡ����
						downImg[i-1] = Constant.imageMap.get("down"+i+".png");
					}
					if (downNum < 3) {
						g.drawImage(downImg[0].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}else if (downNum < 5) {
						g.drawImage(downImg[1].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}else if (downNum < 7) {
						g.drawImage(downImg[2].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}else if (downNum < 9) {
						g.drawImage(downImg[3].getImage(), this.positionX, this.positionY, this.width, this.height, null);
					}
				
			}else {
				imgs = Constant.imageMap.get("down1.png");
				//������ҽ�ɫ
				g.drawImage(imgs.getImage(), this.positionX, this.positionY, this.width, this.height, null);
			}
		}
		//��ͷ�ƶ�����
		move();
	}
	
	/**
	 * ��ը������
	 */
	public void attack(){
		//������������1 ���� isPlayer Ϊtrue
		if (count == 1 && isPlayer) {
			//������һ�����ݼ� �������� -- 
			count--;
			//����һ�����ݶ���
			bubble = new Bubble(this.positionX, this.positionY+15,this,explodeList);
			//�����������ݷ��뼯��
			bubbleList.add(bubble);
			//ͬʱҲ����һ�����Դ���һ���������ײ�ı�ըЧ��
			explode = new Explode(this.positionX, this.positionY);
			
		}else if (count == 1 && !isPlayer) {
			//������һ�����ݼ� �������� -- 
			count--;
			//����һ�����ݶ���
			bubble = new Bubble(this.positionX, this.positionY+15,this,explodeList);
			//�����������ݷ��뼯��
			bubbleList.add(bubble);
			//ͬʱҲ����һ�����Դ���һ���������ײ�ı�ըЧ��
			explode = new Explode(this.positionX, this.positionY);
			
		}
	}
	/**
	 * ��֮ǰ������
	 */
	public void moveOid(){
			this.positionX = this.oidPositionX;
			this.positionY = this.oidPositionY;
		
		
	}
	/**
	 * ö�� ����
	 * @author С��ħ
	 * 
	 */
	public enum Directions{
		L,LU,U,UR,R,RD,D,LD,STOP
	}
	
	/**
	 * �ƶ�
	 */
	public void move(){
		//���� ��ײ����������
		hit(direDown);
		this.oidPositionY = this.positionY;
		this.oidPositionX = this.positionX;
		//ѭ���жϷ���
		switch(dir){
		//�����ƶ�
		case L:
			this.positionX = this.positionX - this.speed;
			leftNum++; //��������߼�++
			if (leftNum >= 9) {
				leftNum = 0;
			}
			break;
		case LU:
			this.positionX -= this.speed;
			this.positionY -= this.speed;
			break;
		case U:
			this.positionY -= this.speed;
			upNum++;  //��������߼�++
			if (upNum >= 9) {
				upNum = 0;
			}
			break;
		case UR:
			this.positionX += this.speed;
			this.positionY -= this.speed;
			break;
		case R:
			this.positionX += this.speed;
			rightNum++;  //��������߼�++
			if (rightNum >= 9) {
				rightNum = 0;
			}
			break;
		case RD:
			this.positionX += this.speed;
			this.positionY += this.speed;
			break;
		case D:
			this.positionY += this.speed;
			downNum++;  //��������߼�++
			if (downNum >= 9) {  //����6�Ļ� downNum �ȱ��0��������ѭ��
				downNum = 0;
			}
			break;
		case LD:
			this.positionX -= this.speed;
			this.positionY += this.speed;
			break;
		case STOP:
			break;
		default:
			break;
		}
		//�����ƶ���������
		if(this.positionX < 0){
			this.positionX = 0;
		}
		if (this.positionY < 100) {
			this.positionY = 100;
		}
		if (this.positionY > 950) {
			this.positionY = 950;
		}
		if (this.positionX > 1570) {
			this.positionX = 1570;
		}
	}
	/**
	 * ���һ�ƶ������̼���
	 * @param e
	 */
	public void KeyPressed(KeyEvent e){
		int key = e.getKeyChar();
		switch(key){
		case 'w':
			bU = true;
			break;
		case 's':
			bD = true;
			break;
		case 'a':
			bL = true;
			break;
		case 'd':
			bR = true;
			break;
		case 'j':
			attack();
			break;
		default:
			break;
		}
		locateDirections();
	}
	/**
	 * ���һ���̸�λ����
	 * @param e
	 */
	public void KeyReleased(KeyEvent e){
		int key = e.getKeyChar();
		switch(key){
		case 'w':
			bU = false;
			break;
		case 's':
			bD = false;
			break;
		case 'a':
			bL = false;
			break;
		case 'd':
			bR = false;
			break;
		default:
			break;
		}
		locateDirections();
	}
	/**
	 * ��Ҷ��ƶ������̼���
	 * @param e
	 */
	public void KeyPressed2(KeyEvent e){
		int key = e.getKeyCode();
		switch(key){
		case 38:  //�����ƶ�
			bU = true;
			break;
		case 40:  //�����ƶ�
			bD = true;
			break;
		case 37:  //�����ƶ�
			bL = true;
			break;
		case 39:  //�����ƶ�
			bR = true;
			break;
		case 17:
			attack();  //��������
			break;
		default:
			break;
		}
		locateDirections();
	}
	/**
	 * ��Ҷ����̸�λ����
	 * @param e
	 */
	public void KeyReleased2(KeyEvent e){
		int key = e.getKeyCode();
		switch(key){
		case 38:
			bU = false;
			break;
		case 40:
			bD = false;
			break;
		case 37:
			bL = false;
			break;
		case 39:
			bR = false;
			break;
		}
		//�����жϰ˸�����ķ���
		locateDirections();
	}
	/**
	 * �жϷ��򷽷����˸�����
	 */
	public void locateDirections(){
		if (bL && !bU && !bR && !bD) 
			dir = Directions.L; 
		if (bL && bU && !bR && !bD) 
			dir = Directions.LU; 
		if (!bL && bU && !bR && !bD) 
			dir = Directions.U; 
		if (!bL && bU && bR && !bD) 
			dir = Directions.UR; 
		if (!bL && !bU && bR && !bD) 
			dir = Directions.R; 
		if (!bL && !bU && bR && bD) 
			dir = Directions.RD; 
		if (!bL && !bU && !bR && bD) 
			dir = Directions.D; 
		if (bL && !bU && !bR && bD) 
			dir = Directions.LD; 
		if (!bL && !bU && !bR && !bD) 
			dir = Directions.STOP;

	}
	/**
	 * �������һ�ľ��ο�
	 */
	public Rectangle getRect(){
		return new Rectangle(this.positionX, this.positionY + 40 , this.width - 10, this.height - 30);
	}
	/**
	 * �����ײ���ϰ���
	 */
	public void hit(String dire) {
		if (isPlayer) {  //���һ
			//��ȡ�ϰ���ľ��ο�
			Rectangle mapRect = null;
			for (MapImg map : mapList) {
				//�ж�������ϰ����Ƿ�����ײ
				if (dire.equals("up")) {
					mapRect =  map.getRect();
				}else if (dire.equals("down")) {
					mapRect =  map.getRect();
				}else if (dire.equals("left")) {
					mapRect =  map.getRect();
				}else if (dire.equals("right")) {
					mapRect =  map.getRect();
				}
				//��ȡ���һ���ο�
				Rectangle playerRect =  getRect();
				if (playerRect.intersects(mapRect)) {
					//���ײ�����ϰ���ȵ��ô˷���
					moveOid();
				}
			}
		}else{  //��Ҷ�
			//��ȡ�ϰ���ľ��ο�
			Rectangle mapRect = null;
			for (MapImg map : mapList) {
				//�ж�������ϰ����Ƿ�����ײ
				if (dire.equals("up")) {
					mapRect =  map.getRect();
				}else if (dire.equals("down")) {
					mapRect =  map.getRect();
				}else if (dire.equals("left")) {
					mapRect =  map.getRect();
				}else if (dire.equals("right")) {
					mapRect =  map.getRect();
				}
				//��ȡ��Ҷ��ľ��ο�
				Rectangle playersRect = getRect();
				if (playersRect.intersects(mapRect)) {
					moveOid();
				}
			}
		}
	}
	/**
	 * �����ײ������ըЧ��
	 */
	public void plyaerHitExplode(){
		if (isPlayer) {
			//��ȡ��ҵľ��ο�
			Rectangle playerRect = getRect();
			//��ȡ��ըЧ�����ο�
			//��ȡ�����ϵľ��ο�
			Rectangle upRect =  this.explode.getUpRect();
			//��ȡ�����µľ��ο�
			Rectangle downRect = this.explode.getDownRect();
			//��ȡ������ľ��ο�
			Rectangle leftRect = this.explode.getLeftRect();
			//��ȡ�����ҵľ��ο�
			Rectangle rightRect = this.explode.getRightRect();
			if (upRect.intersects(playerRect) || downRect.intersects(playerRect) || leftRect.intersects(playerRect) || rightRect.intersects(playerRect)) {
				isOver = true;
			}
		}else if (!isPlayer) {
			//��ȡ��ҵľ��ο�
			Rectangle playerRect = getRect();
			//��ȡ��ըЧ�����ο�
			//��ȡ�����ϵľ��ο�
			Rectangle upRect =  this.explode.getUpRect();
			//��ȡ�����µľ��ο�
			Rectangle downRect = this.explode.getDownRect();
			//��ȡ������ľ��ο�
			Rectangle leftRect = this.explode.getLeftRect();
			//��ȡ�����ҵľ��ο�
			Rectangle rightRect = this.explode.getRightRect();
			if (upRect.intersects(playerRect) || downRect.intersects(playerRect) || leftRect.intersects(playerRect) || rightRect.intersects(playerRect)) {
				isOver = true;
			}
		}
	}
}
