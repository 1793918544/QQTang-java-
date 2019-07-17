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
 * 主舞台,游戏面板类,绘制各种对象图形
 * @author 小恶魔
 *	@date：2019 - 7 - 1
 */
public class GamePanel extends JPanel{
	//高度
	int height;
	//宽度
	int width;
	//背景图片
	ImageIcon bgimage;
	//地图背景图片
	ImageIcon mapBgimage;
	//玩家
	Player player;
	//玩家2
	Player players;
	//障碍物的矩形框
	Rectangle mapRect;
	//炸弹
	Bubble bubble;
	//道具
	Prop props;
	//道具集合
	List<Prop> propList = new ArrayList<Prop>();
	//生命道具
	Count count;
	//地面对象集合
	List<MapImg> mapList = new ArrayList<MapImg>(); 
	//分别定义：黄砖，红砖，花瓶，仙人掌
	MapImg brick1,brick2,vase,cactus;
	//得分与时间
	Scoring scoring;
	//二维数组地图
	int[][] map = null;
	//音乐
	Music music;
	/**
	 * 构造函数，初始化工作
	 * @param player 玩家
	 * @param props 道具
	 * @param mapList  地图集合
	 * @param count  气泡数量
	 * @param brick1  地图 - 黄砖块
	 * @param brick2  地图 - 红砖块
	 * @param vase  花瓶
	 * @param cactus  仙人掌
	 * @param propList  道具集合
	 * @param players  玩家二
	 * @param scoring 得分与时间
	 */
	public GamePanel(Player player,
			List<Prop> props,List<MapImg> mapList,
			Count count,MapImg brick1,MapImg brick2,
			MapImg vase,MapImg cactus,int[][] map,
			List<Prop> propList,Player players,Scoring scoring){
		
		this.height = Constant.GAMEPANEL_HEIGHT;  //舞台高度
		this.width = Constant.GAMEPANEL_WIDTH;	//舞台宽度
		this.player = player;   //玩家
		this.mapList = mapList;  //地图集合
		this.count = count;  //气泡数量
		this.propList = propList;  //道具集合
		this.players = players;  //玩家二
		this.scoring = scoring;  //得分
		//创建音乐对象 ：拾取道具
		music = new Music("src\\com\\yidu\\QQTang\\quantao\\Music\\getGoods.wav");
		//创建多线程画板刷新
		GameThread gameThread = new GameThread();
		//创建多线程对象
		Thread thread = new Thread(gameThread);
		//调用方法，启动多线程
		thread.start();
	}
	/**
	 * 游戏面板无参构造函数
	 */
	public GamePanel(){
		
	}
	
	/**
	 * 绘制窗口所有
	 * g  画笔
	 */
	public void paintComponent(final Graphics g) {
		
		//绘制背景方法
		drawBackground(g);
		
		//画出道具
		drawProp(g);
		
		//绘制地图
		drawMap(g);
		
		//绘制玩家的炸弹
		drawBomb(g);
		
		//绘制玩家
		drawmeme(g);
		
		//玩家气泡爆炸碰撞障碍物，障碍物既消失
		bubbleHitmap(g);
		
		//玩家碰撞道具有属性加成
		playerHitProp();
		
		//玩家碰撞到不是自身的爆炸效果
		playerHitExplode();
		
		//游戏结束
		if (player.isOver || players.isOver) {
			//画出gameOver 
			gameOver(g);
		}
		
		//绘制时间与得分信息
		drawTime(g);
	}
	/**
	 * 绘制更新时间信息
	 * @param g  画笔
	 */
	private void drawTime(Graphics g) {
		//调用得分 的display方法
		scoring.display(g);
	}
	/**
	 * 画出游戏结束
	 * @param g 画笔
	 */
	private void gameOver(Graphics g) {
		//获取游戏结束图片
		ImageIcon gameOverImg = Constant.imageMap.get("gameover.png");
		//画出游戏结束的图片
		g.drawImage(gameOverImg.getImage(), 550, 370, 500, 89, null);
	}
	/**
	 * 玩家碰撞到不是自身的爆炸效果
	 */
	private void playerHitExplode() {
		//玩家一 和 玩家二不等于空
		if (player != null && players != null) {
			//获取玩家一的矩形框
			Rectangle playerRect = player.getRect();
			//获取玩家二的矩形框
			Rectangle playersRect = players.getRect();
			//玩家一的爆炸效果不等于空
			if (player.explode != null) {
				//获取玩家一爆炸效果方向上的矩形框
				Rectangle upRect =  player.explode.getUpRect();
				//获取玩家一爆炸效果方向下的矩形框
				Rectangle downRect = player.explode.getDownRect();
				//获取玩家一爆炸效果方向左的矩形框
				Rectangle leftRect = player.explode.getLeftRect();
				//获取玩家一爆炸效果方向右的矩形框
				Rectangle rightRect = player.explode.getRightRect();
				//如果玩家一的炸弹的爆炸效果变量 isbomb  为true 既执行以下代码
				if (player.bubble.isBomb) {
					//如果玩家二矩形框与玩家一的爆炸各方向的矩形框重叠
					if (playersRect.intersects(upRect) || playersRect.intersects(downRect) || playersRect.intersects(leftRect) || playersRect.intersects(rightRect)) {
						//玩家二的 isOver 变为true
						players.isOver = true;
						//玩家一的炸弹爆炸效果变为 null
						player.explode = null;
					}else {  //如果没有炸到玩家一的炸弹效果对象 变为空
						player.explode = null;
					}
				}
			}
			//玩家二的爆炸效果不等于空
			if (players.explode != null) {
				//获取玩家二炸弹方向上的矩形框
				Rectangle upRect2 =  players.explode.getUpRect();
				//获取玩家二炸弹方向下的矩形框
				Rectangle downRect2 = players.explode.getDownRect();
				//获取玩家二炸弹方向左的矩形框
				Rectangle leftRect2 = players.explode.getLeftRect();
				//获取玩家二炸弹方向右的矩形框
				Rectangle rightRect2 = players.explode.getRightRect();
				//如果玩家二的炸弹的爆炸效果变量 isbomb  为true 既执行以下代码
				if (players.bubble.isBomb) {
					//如果玩家二矩形框与玩家一的爆炸各方向的矩形框重叠
					if (playerRect.intersects(upRect2) || playerRect.intersects(downRect2) || playerRect.intersects(leftRect2) || playerRect.intersects(rightRect2)) {
						//玩家一的 isOver 变为true
						player.isOver = true;
						//玩家二的炸弹爆炸效果变为 null
						players.explode = null;
					}else {  //如果没有炸到玩家二的炸弹效果对象 变为空
						players.explode = null;
					}
				}
			}
		}
	}
	/**
	 * 玩家碰撞道具
	 */
	private void playerHitProp() {
		//获取玩家一的矩形框
		Rectangle playerRect = player.getRect();
		//获取玩家二的矩形框
		Rectangle playersRect = players.getRect();
		//道具矩形框
		Rectangle propRect = null;
		//获取所有道具的矩形框
		for (int i = 0; i < propList.size(); i++) {
			//道具矩形框保存 循环遍历的道具集合 propList (道具集合)
			propRect = propList.get(i).getRect();
			//判断玩家一与道具碰撞
			if (playerRect.intersects(propRect)) {
				//如果碰撞的道具属于Speed
				if (propList.get(i) instanceof Speed) {
					//玩家一的速度属性 +1
					player.setSpeed(player.getSpeed() + 1);
				//如果玩家二的碰撞的道具属于 Gold 既加玩家二的金币值
				}else if (propList.get(i) instanceof Gold) {
					//玩家一的金币属性 +1
					player.setGold(player.getGold() + 1);
				}
				//碰到了道具同时把道具移除
				propList.remove(i);
				//调用播放音乐
				music.startMusic();
				
				
				//玩家二与道具碰撞
			}else if (playersRect.intersects(propRect)) { 
				//如果碰撞的道具属于Speed
				if (propList.get(i) instanceof Speed) { 
					//玩家二的速度属性 +1
					players.setSpeed(players.getSpeed() + 1);
					//如果玩家二的碰撞的道具属于 Gold 既加玩家二的金币值
				}else if (propList.get(i) instanceof Gold) {
					//玩家二的金币属性 +1
					players.setGold(players.getGold() + 1);
				}
				//碰到了道具同时把道具移除
				propList.remove(i);
				
				//调用播放音乐
				music.startMusic();
			}
		}
	}

	/**
	 * 画出所有道具
	 * @param g  画笔
	 */
	private void drawProp(Graphics g) {
		//循环遍历道具(propList)集合
		for (int i = 0; i < propList.size(); i++) {
			//调用道具集合里每一个display的方法
			propList.get(i).display(g);
		}
	}

	/**
	 * 玩家气泡爆炸碰撞到障碍物
	 * @param g  画笔
	 */
	private void bubbleHitmap(Graphics g) {
		//玩家一的炸弹不等于null 并且 玩家一的炸弹爆炸效果不等于null
		if (player.bubble != null && player.bubble.explode != null) {  //玩家一
			//获取玩家一炸弹的爆炸效果方向上的矩形框
			Rectangle upRect =  player.bubble.explode.getUpRect();
			//获取玩家一炸弹的爆炸效果方向下的矩形框
			Rectangle downRect = player.bubble.explode.getDownRect();
			//获取玩家一炸弹的爆炸效果方向左的矩形框
			Rectangle leftRect = player.bubble.explode.getLeftRect();
			//获取玩家一炸弹的爆炸效果方向右的矩形框
			Rectangle rightRect = player.bubble.explode.getRightRect();
			//循环遍历障碍物集合
			for (int j = 0; j < mapList.size(); j++) {
				//用 mapRect 保存mapList 集合每一个矩形框
				mapRect = mapList.get(j).getRect();
				//判断玩家气泡爆炸碰撞障碍物
				if (upRect.intersects(mapRect) || downRect.intersects(mapRect) || leftRect.intersects(mapRect) || rightRect.intersects(mapRect)){
					//在气泡爆炸之后既把障碍物对象从集合中移除
					if (player.bubble.isBomb) {
						//移除障碍物
						mapList.remove(j);
					}
				}
			}
		}
		//玩家二的炸弹不等于null 并且 玩家二的炸弹爆炸效果不等于null
		if (players.bubble != null && players.bubble.explode != null) {  //玩家二
			//获取玩家二炸弹的爆炸效果方向上的矩形框
			Rectangle upRect =  players.bubble.explode.getUpRect();
			//获取玩家二炸弹的爆炸效果方向下的矩形框
			Rectangle downRect = players.bubble.explode.getDownRect();
			//获取玩家二炸弹的爆炸效果方向左的矩形框
			Rectangle leftRect = players.bubble.explode.getLeftRect();
			//获取玩家二炸弹的爆炸效果方向右的矩形框
			Rectangle rightRect = players.bubble.explode.getRightRect();
			//循环遍历障碍物集合
			for (int i = 0; i < mapList.size(); i++) {
				//用 mapRect 保存mapList 集合每一个矩形框
				mapRect = mapList.get(i).getRect();
				//判断玩家气泡爆炸碰撞障碍物
				if (upRect.intersects(mapRect) || downRect.intersects(mapRect) || leftRect.intersects(mapRect) || rightRect.intersects(mapRect)) {
					//在气泡爆炸之后既把障碍物对象从集合中移除
					if (players.bubble.isBomb) {
						//移除障碍物
						mapList.remove(i);
						//玩家二炸弹的爆炸效果为null
						players.bubble.explode = null;
					}
				}
			}
		}
	}

	/**
	 * 绘制气泡技能
	 * @param g  画笔
	 */
	private void drawBomb(Graphics g) {
		//玩家一炸弹集合不等于 0 
		if (player.bubbleList.size() != 0) {
			//循环遍历玩家一的炸弹集合
			for (Bubble bubble : player.bubbleList) {
				//调用炸弹对象的display方法
				bubble.display(g);
			}
		}
		//玩家一的炸弹集合大于 0 
		if (player.bubbleList.size() > 0) {
			//当爆炸效果出来后即可把集合里气泡对象移除进行回收
			for (int i = 0; i < player.bubbleList.size(); i++) {
				//如果玩家一的炸弹集合对象里的isbomb 为true 既执行以下代码
				if (player.bubbleList.get(i).isBomb) {
					//玩家一 ：移除玩家一炸弹对象进行回收
					player.bubbleList.remove(i);
					//玩家一的count 气泡数量 ++
					player.count++;
				}
			}
		}
		//玩家二炸弹集合不等于 0 
		if (players.bubbleList.size() != 0) {
			//循环遍历玩家二的炸弹集合
			for (Bubble bubble : players.bubbleList) {
				//调用炸弹对象的display方法
				bubble.display(g);
			}
		}
		//玩家二的炸弹集合大于 0 
		if (players.bubbleList.size() > 0) {
			//当爆炸效果出来后即可把集合里气泡对象移除进行回收
			for (int i = 0; i < players.bubbleList.size(); i++) {
				//如果玩家二的炸弹集合对象里的isbomb 为true 既执行以下代码
				if (players.bubbleList.get(i).isBomb) {
					//玩家二 ：移除玩家二炸弹对象进行回收
					players.bubbleList.remove(i);
					//玩家二的count 气泡数量 ++
					players.count++;
				}
			}
		}
		
	}
	/**
	 * 绘制玩家
	 * @param g  画笔
	 */
	private void drawmeme(Graphics g) {
		//如果玩家一的 isOver 为false
		if (!player.isOver) {
			//绘制玩家1
			player.display(g);
		}
		//如果玩家二的 isOver 为false
		if (!players.isOver) {
			//绘制玩家2
			players.display(g);
		}
	}
	/**
	 * 绘制地图
	 * @param g  画笔
	 */
	private void drawMap(Graphics g) {
		//如果障碍物集合数量大于0
		if (mapList.size() > 0) {
			//循环遍历障碍物集合
			for (MapImg mapImg : mapList) {
				//画出障碍物
				mapImg.display(g);
			}
		}
	}
	/**
	 *  绘制背景
	 *  @param g  画笔
	 */
	private void drawBackground(Graphics g) {
		//获取计分图
		ImageIcon scoreImg = Constant.imageMap.get("score.png");
		//画出计分图
		g.drawImage(scoreImg.getImage(), 0, 0, 1600, 122, null);
		//获取背景图片
		ImageIcon mapImg = Constant.imageMap.get("backDrop0.png");
		//循环20次 
		for (int i = 0; i < 20; i++) {
			//循环10次
			for (int j = 0; j < 10; j++) {
				//画出地图。
				g.drawImage(mapImg.getImage(), i*150, j*150 + 122, 150, 150, null);
			}
		}
	}
	/**
	 * 将各个角色显示
	 */
	public void showAll(){
		//调用画板类的刷新画面
		this.repaint();
	}
	/**
	 * 多线程刷新窗口
	 * @author 全涛
	 *
	 */
	class GameThread implements Runnable{
		public void run() {
			//无限循环
			while(true){
				//调用角色显示方法
				showAll();
				try {
					//休眠 20 毫秒
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
