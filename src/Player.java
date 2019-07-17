package com.yidu.QQTang.quantao;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


/**
 * 玩家类
 * @author 小恶魔
 * @date  2019/7/1
 */
public class Player extends Role{
	//玩家图片
	ImageIcon imgs;
	//向右走判断
	boolean right = false;
	//向左走判断
	boolean left = false;
	//向下走判断
	boolean down = false;
	//向上走判断
	boolean up = false;
	//人物速度 X和Y 速度
	int speed;
	//向左走图片数组
	ImageIcon[] zuo = new ImageIcon[4];
	//向右走图片数组
	ImageIcon[] you = new ImageIcon[4];
	//向上走图片数组
	ImageIcon[] upImg = new ImageIcon[4];
	//向下走图片数组
	ImageIcon[] downImg = new ImageIcon[4];
	//各方向换图片的频率参数
	int leftNum = 0,rightNum = 0,upNum = 0,downNum = 0;
	//装气泡的集合
	List<Bubble> bubbleList = new ArrayList<Bubble>();
	//同时可放气泡的数量
	int count;
	//气泡对象
	Bubble bubble;
	//金币
	int gold;
	//上方碰撞测试
	boolean hitUp = false;
	//下方碰撞测试
	boolean hitDown = false;
	//右方碰撞测式
	boolean hitRight = false;
	//左方碰撞测试
	boolean hitLeft = false;
	//hit方法参数传入的变量
	String direUp = "up",direDown = "down",direLeft = "left",direRight = "right";
	//地面对象集合
	List<MapImg> mapList = new ArrayList<MapImg>(); 
	//走之前的坐标值
	int oidPositionX,oidPositionY;
	//爆炸效果
	Explode explode;
	//是否爆炸
	boolean isBomb = false;
	//分开玩家
	boolean isPlayer;
	//是否结束
	boolean isOver = false;
	//上下左右
	boolean bL = false,bU = false,bR = false,bD = false;
	//爆炸效果集合
	List<Explode> explodeList = new ArrayList<Explode>();
	/** 
	 * 初始方向 
	 */ 
	private Directions dir = Directions.STOP;
	/**
	 * 玩家一的构造函数
	 * @param positionX  横坐标
	 * @param positionY  纵坐标
	 * @param mapList   障碍物集合
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
	 * 玩家二的构造函数
	 * @param positionX  横坐标
	 * @param positionY  纵坐标
	 * @param mapList  障碍物集合
	 * @param isPlayer  是否为玩家一或玩家二
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
	 * 获取速度
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * 赋值速度
	 * @param speed  速度
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * 获取金币
	 * @return
	 */
	public int getGold(){
		return gold;
	}
	/**
	 * 赋值金币
	 * @param gold 金币
	 */
	public void setGold(int gold){
		this.gold = gold;
	}
	/**
	 * 绘制自己
	 */
	public void display(Graphics g) {
		//玩家1
		if (isPlayer) {
			//向左走
			if (left) {
				for (int i = 1; i <= 4; i++) {
					//循环把图片提取出来
					zuo[i-1] = Constant.imageMap.get("SunZuo"+i+".png");
				}  //向右走图片更换
				if (leftNum < 3) {
					g.drawImage(zuo[0].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 5) {
					g.drawImage(zuo[1].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 7) {
					g.drawImage(zuo[2].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 9) {
					g.drawImage(zuo[3].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}
			}else if (right) {    //向右走
				for (int i = 1; i <= 4; i++) {
					//循环把图片提取出来
					you[i-1] = Constant.imageMap.get("SunYou"+i+".png");
				}  //向右走图片更换
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
					//循环把图片提取出来
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
					//循环把图片提取出来
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
				//画出玩家角色
				g.drawImage(imgs.getImage(), this.positionX, this.positionY, this.width, this.height, null);
			}
			//玩家2
		}else if (!isPlayer) {
			//向左走
			if (left) {
				for (int i = 1; i <= 4; i++) {
					//循环把图片提取出来
					zuo[i-1] = Constant.imageMap.get("left"+i+".png");
				}  //向右走图片更换
				if (leftNum < 3) {
					g.drawImage(zuo[0].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 5) {
					g.drawImage(zuo[1].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 7) {
					g.drawImage(zuo[2].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}else if (leftNum < 9) {
					g.drawImage(zuo[3].getImage(), this.positionX, this.positionY, this.width, this.height, null);
				}
				}else if (right) {    //向右走
					for (int i = 1; i <= 4; i++) {
						//循环把图片提取出来
						you[i-1] = Constant.imageMap.get("right"+i+".png");
					}  //向右走图片更换
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
						//循环把图片提取出来
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
						//循环把图片提取出来
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
				//画出玩家角色
				g.drawImage(imgs.getImage(), this.positionX, this.positionY, this.width, this.height, null);
			}
		}
		//掉头移动方法
		move();
	}
	
	/**
	 * 放炸弹技能
	 */
	public void attack(){
		//气泡数量等于1 并且 isPlayer 为true
		if (count == 1 && isPlayer) {
			//当放了一个气泡既 气泡数量 -- 
			count--;
			//创建一个气泡对象
			bubble = new Bubble(this.positionX, this.positionY+15,this,explodeList);
			//将创建的气泡放入集合
			bubbleList.add(bubble);
			//同时也创建一个可以创建一个跟玩家碰撞的爆炸效果
			explode = new Explode(this.positionX, this.positionY);
			
		}else if (count == 1 && !isPlayer) {
			//当放了一个气泡既 气泡数量 -- 
			count--;
			//创建一个气泡对象
			bubble = new Bubble(this.positionX, this.positionY+15,this,explodeList);
			//将创建的气泡放入集合
			bubbleList.add(bubble);
			//同时也创建一个可以创建一个跟玩家碰撞的爆炸效果
			explode = new Explode(this.positionX, this.positionY);
			
		}
	}
	/**
	 * 走之前的坐标
	 */
	public void moveOid(){
			this.positionX = this.oidPositionX;
			this.positionY = this.oidPositionY;
		
		
	}
	/**
	 * 枚举 方向
	 * @author 小恶魔
	 * 
	 */
	public enum Directions{
		L,LU,U,UR,R,RD,D,LD,STOP
	}
	
	/**
	 * 移动
	 */
	public void move(){
		//调用 碰撞方法，向下
		hit(direDown);
		this.oidPositionY = this.positionY;
		this.oidPositionX = this.positionX;
		//循环判断方向
		switch(dir){
		//向左移动
		case L:
			this.positionX = this.positionX - this.speed;
			leftNum++; //如果向左走既++
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
			upNum++;  //如果向上走既++
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
			rightNum++;  //如果向右走既++
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
			downNum++;  //如果向下走既++
			if (downNum >= 9) {  //大于6的话 downNum 既变回0可以无限循环
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
		//人物移动过界限制
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
	 * 玩家一移动，键盘监听
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
	 * 玩家一键盘复位监听
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
	 * 玩家二移动，键盘监听
	 * @param e
	 */
	public void KeyPressed2(KeyEvent e){
		int key = e.getKeyCode();
		switch(key){
		case 38:  //向上移动
			bU = true;
			break;
		case 40:  //向下移动
			bD = true;
			break;
		case 37:  //向左移动
			bL = true;
			break;
		case 39:  //向右移动
			bR = true;
			break;
		case 17:
			attack();  //攻击方法
			break;
		default:
			break;
		}
		locateDirections();
	}
	/**
	 * 玩家二键盘复位监听
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
		//调用判断八个方向的方法
		locateDirections();
	}
	/**
	 * 判断方向方法，八个方向
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
	 * 返回玩家一的矩形框
	 */
	public Rectangle getRect(){
		return new Rectangle(this.positionX, this.positionY + 40 , this.width - 10, this.height - 30);
	}
	/**
	 * 玩家碰撞到障碍物
	 */
	public void hit(String dire) {
		if (isPlayer) {  //玩家一
			//获取障碍物的矩形框
			Rectangle mapRect = null;
			for (MapImg map : mapList) {
				//判断玩家与障碍物是否有碰撞
				if (dire.equals("up")) {
					mapRect =  map.getRect();
				}else if (dire.equals("down")) {
					mapRect =  map.getRect();
				}else if (dire.equals("left")) {
					mapRect =  map.getRect();
				}else if (dire.equals("right")) {
					mapRect =  map.getRect();
				}
				//获取玩家一矩形框
				Rectangle playerRect =  getRect();
				if (playerRect.intersects(mapRect)) {
					//如果撞到了障碍物，既调用此方法
					moveOid();
				}
			}
		}else{  //玩家二
			//获取障碍物的矩形框
			Rectangle mapRect = null;
			for (MapImg map : mapList) {
				//判断玩家与障碍物是否有碰撞
				if (dire.equals("up")) {
					mapRect =  map.getRect();
				}else if (dire.equals("down")) {
					mapRect =  map.getRect();
				}else if (dire.equals("left")) {
					mapRect =  map.getRect();
				}else if (dire.equals("right")) {
					mapRect =  map.getRect();
				}
				//获取玩家二的矩形框
				Rectangle playersRect = getRect();
				if (playersRect.intersects(mapRect)) {
					moveOid();
				}
			}
		}
	}
	/**
	 * 玩家碰撞到自身爆炸效果
	 */
	public void plyaerHitExplode(){
		if (isPlayer) {
			//获取玩家的矩形框
			Rectangle playerRect = getRect();
			//获取爆炸效果矩形框
			//获取方向上的矩形框
			Rectangle upRect =  this.explode.getUpRect();
			//获取方向下的矩形框
			Rectangle downRect = this.explode.getDownRect();
			//获取方向左的矩形框
			Rectangle leftRect = this.explode.getLeftRect();
			//获取方向右的矩形框
			Rectangle rightRect = this.explode.getRightRect();
			if (upRect.intersects(playerRect) || downRect.intersects(playerRect) || leftRect.intersects(playerRect) || rightRect.intersects(playerRect)) {
				isOver = true;
			}
		}else if (!isPlayer) {
			//获取玩家的矩形框
			Rectangle playerRect = getRect();
			//获取爆炸效果矩形框
			//获取方向上的矩形框
			Rectangle upRect =  this.explode.getUpRect();
			//获取方向下的矩形框
			Rectangle downRect = this.explode.getDownRect();
			//获取方向左的矩形框
			Rectangle leftRect = this.explode.getLeftRect();
			//获取方向右的矩形框
			Rectangle rightRect = this.explode.getRightRect();
			if (upRect.intersects(playerRect) || downRect.intersects(playerRect) || leftRect.intersects(playerRect) || rightRect.intersects(playerRect)) {
				isOver = true;
			}
		}
	}
}
