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
 * 气泡类 （炸弹）
 * @author 小恶魔
 *
 */
public class Bubble {
	//气泡长度
	int width;
	//气泡宽度
	int height;
	//气泡横坐标
	int positionX;
	//气泡纵坐标
	int positionY;
	//气泡图片
	ImageIcon bubbleImg;
	//玩家
	Player player;
	//爆炸效果
	Explode explode;
	//定时参数
	int timer;
	//气泡爆炸之后删除的判断
	boolean isBomb = false;
	//判断玩家
	boolean isPlayer = true;
	//爆炸效果集合
	List<Explode> explodeList = new ArrayList<Explode>();
	//爆炸音乐
	Music music;
	
	/**
	 * 气泡构造函数 
	 * @param positionX  横坐标
	 * @param positionY  纵坐标
	 * @param player  玩家一
	 * @param explodeList  爆炸效果集合
	 */
	public Bubble(int positionX,int positionY,Player player,List<Explode> explodeList){
		this.width = Constant.XIGUA_WIDTH;
		this.height = Constant.XIGUA_HEIGHT;
		this.positionX = positionX;
		this.positionY = positionY;
		this.player = player;
		this.explodeList = explodeList;
		explode = new Explode(this.positionX, this.positionY);
		//创建爆炸音效
		music = new Music("src\\com\\yidu\\QQTang\\quantao\\Music\\bubbleBomb.wav");
	}
	/**
	 * 绘制炸弹
	 * @param g 画笔
	 */
	public void display(Graphics g){
		//获取炸弹图片
		bubbleImg = Constant.imageMap.get("西瓜1.png");
		timer++;
		if (timer < 150) {
			//画出气泡图片
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
			//当炸弹爆炸的时候既调用判断有无炸到玩家的方法
			player.plyaerHitExplode();
			//调用炸弹爆炸声音的方法
			music.startMusic();
		}
		if (timer >= 180) {
			explode = null;
		}
		
	}
}
