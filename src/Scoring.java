package com.yidu.QQTang.quantao;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 得分类
 * @author 小恶魔
 * @date 2019/7/1
 */
public class Scoring {
	//时间限制
	int time;
	//得分数
	int score;
	//改变时间辅助变量
	int k;
	//图片宽度
	int width;
	//图片高度
	int height;
	//得分图片数组
	ImageIcon[] scoreImg = new ImageIcon[10];
	//玩家一
	Player player;
	//玩家二
	Player players;
	//时间个位图片
	ImageIcon timeSingle;
	//时间十位图片
	ImageIcon timeTen;
	//时间百位图片
	ImageIcon timeHundred;
	//玩家一得分个位图片
	ImageIcon playerSingle;
	//玩家一得分十位图片
	ImageIcon playerTen;
	//玩家二得分个位图片
	ImageIcon playersSingle;
	//玩家二得分十位图片
	ImageIcon playersTen;
	//游戏界面窗口
	JFrame gameFrame;
	//结束
	boolean over;
	/**
	 * 得分类构造函数
	 * @param player  玩家一
	 * @param players  玩家二
	 * @param gameFrame  开始窗口
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
		//循环获取得分图片
		for (int i = 0; i < scoreImg.length; i++) {
			scoreImg[i] = Constant.imageMap.get("number"+i+".png");
		}
		//时间个位图片初始图片
		timeSingle = scoreImg[0];
		//时间十位图片初始图片
		timeTen = scoreImg[0];
		//时间百位图片初始图片
		timeHundred = scoreImg[0];
		//玩家一得分个位数初始图片
		playerSingle = scoreImg[0];
		//玩家一得分十位数初始图片
		playerTen = scoreImg[0];
		//玩家二得分个位数初始图片
		playersSingle = scoreImg[0];
		//玩家二得分十位数初始图片
		playersTen = scoreImg[0];
	}
	/**
	 * 绘制自己
	 * @param g  画笔
	 */
	public void display(Graphics g){
		//画出时间百位图片
		g.drawImage(timeHundred.getImage(), 1400, 30, this.width, this.height, null);
		//画出时间十位图片
		g.drawImage(timeTen.getImage(), 1450, 30, this.width, this.height, null);
		//画出时间个位图片
		g.drawImage(timeSingle.getImage(), 1500, 30, this.width, this.height, null);
		//画出玩家一得分个位图片
		g.drawImage(playerSingle.getImage(), 110, 45, this.width, this.height, null);
		//画出玩家一得分十位图片
		g.drawImage(playerTen.getImage(), 70, 45, this.width, this.height, null);
		//画出玩家二得分个位图片
		g.drawImage(playersSingle.getImage(), 550, 45, this.width, this.height, null);
		//画出玩家二得分十位图片
		g.drawImage(playersTen.getImage(), 510, 45, this.width, this.height, null);
		k++;
		//当k 等于50 并且 time 大于 0 
		if (k == 50 && time >0) {
			//时间 --
			time--;
			//调用更新时间方法
			updataTime();
			//重新赋值k = 0
			k = 0;
		}
		//调用更新得分信息
		updataScore();
		//当时间等于0的时候计算出谁胜利
		if (time == 0 ) {
			//游戏结束信息
			String message = "";
			//游戏时间重置
			time = 600;
//			if (player.isOver) {
//				//既玩家二获胜
//				message = "恭喜你，玩家二获得胜利。";
//				over = true;
//			}else if (players.isOver) {
//				//既玩家二获胜
//				message = "恭喜你，玩家一获得胜利。";
//				over = true;
//			//如果玩家一与玩家二的分数相对
//			}else 
			if (player.gold == players.gold) {
				//既平局
				message = "你们都很棒哟！这局平局！";
			//如果玩家一的分数大于玩家二的分数
			}else if (player.gold > players.gold) {
				//既玩家一获胜
				message = "恭喜你，玩家一获得胜利。";
			//如果玩家二的分数大于玩家一的分数
			}else if (player.gold < players.gold) {
				//既玩家二获胜
				message = "恭喜你，玩家二获得胜利。";
			}
			//算出两个玩家获胜之后的结果，既弹出一个信息框
			JOptionPane.showConfirmDialog(null, message, "游戏结算", JOptionPane.PLAIN_MESSAGE);
		}
	}
	/**
	 * 更新得分信息
	 */
	public void updataScore(){
		//循环更新玩家一的个位得分信息
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
		//循环更新玩家一的十位得分信息
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
		//循环更新玩家二的个位得分信息
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
		//循环更新玩家一的十位得分信息
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
	 * 更新时间方法
	 */
	public void updataTime(){
		//时间个位图片循环更新
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
		//时间十位图片循环更新
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
		//时间百位图片循环更新
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
