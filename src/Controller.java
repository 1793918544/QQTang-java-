package com.yidu.QQTang.quantao;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * 控制器类，实现事件监听
 * @author 小恶魔
 *
 */
public class Controller implements KeyListener{
	//玩家
	Player player;
	//玩家2
	Player players;
	//判断是否打拳
	public static boolean b = false;
	/**
	 * 控制器类构造函数
	 * @param player  玩家一
	 * @param players  玩家二
	 */ 
	public Controller(Player player,Player players){
		this.player = player;
		this.players = players;
		
	}
	/**
	 * 控制器无参构造函数
	 */
	public Controller(){
		
	}
	/*
	 * 玩家一的按键判断
	 */
	boolean right1 = false; // 判断初始值
	boolean left1 = false;   //判断初始值
	boolean up1 = false;   //判读初始值
	boolean down1 = false;  //判断初始值
	/*
	 * 玩家二的按键判断
	 */
	boolean right2 = false;
	boolean left2 = false;
	boolean up2 = false;
	boolean down2 = false;
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
//		//玩家1 控制按键
		if (key == 'd') {
			right1 = true;  //如果按下d既变为true
			player.right = true;
		}
//		if (right1 == true) {
//			player.moveRight();  //调用向右移动方法
//		}
		if (key == 'a') {
			left1 = true;
			player.left = true;
		}
//		if (left1 == true) {
//			player.moveLeft();  //调用向左移动方法
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
//			player.attack();  //调用攻击的方法
//		}
//			//玩家二控制按键
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
//			//玩家二攻击按键
//			if (e.getKeyCode() == 17) {
//				players.attack();
//			}
		//玩家一
		player.KeyPressed(e);
		//玩家二
		players.KeyPressed2(e);
	}
	public void keyReleased(KeyEvent e) {
		//玩家一
		player.KeyReleased(e);
		//玩家二
		players.KeyReleased2(e);
		/*
		 * 只要我一松开，run的状态被改变为false,人物不再跑动，
		 * 如果跑动过程中按下发射子弹键，因为人物run为true,所以不受影响。
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
		//玩家二
		
		//玩家二按键判断
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
