package com.yidu.QQTang.quantao;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * 游戏开始界面
 * @author 小恶魔
 * @date  2019/7/1
 */
public class StartFrame{
	public static void main(String[] args) {
		new StartFrame().init();
	}
	//创建画板对象
	MyJPanel jPanel = new MyJPanel();
	//鼠标进入窗口的图案
	Cursor customecur;
	//鼠标点击按钮的图案
	Cursor handcur;
	//游戏开始按钮
	JButton start;
	//游戏设置按钮
	JButton set;
	//游戏退出按钮
	JButton exitButton;
	//窗口
	JFrame frame = new JFrame("泡泡堂 - 开始游戏");;
	/**
	 * 窗口初始化
	 */
	public void init(){
		
		//背景图片
		ImageIcon imageIcon = new ImageIcon("src\\com\\yidu\\QQTang\\quantao\\Images\\Map\\start.png");
		// 把背景图片显示在一个标签里面
		JLabel imageLb = new JLabel(imageIcon);
		// 把标签的大小位置设置为图片刚好填充整个面板
		imageLb.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
		// 把背景图片添加到分层窗格的最底层作为背景
		frame.getLayeredPane().add(imageLb, new Integer(Integer.MIN_VALUE));
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		JPanel imagePanel= (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		//获取游戏Ico
		ImageIcon imgIcon = Constant.imageMap.get("Icon.png");
		//设置窗体小图标
	    frame.setIconImage(imgIcon.getImage());
		frame.add(jPanel);
		//设置窗口自由布局
		frame.setLayout(null);
		//鼠标点击的图案
		handcur = Toolkit.getDefaultToolkit().createCustomCursor(Constant.imageMap.get("mouse2.png").getImage(), new Point(10,10), "hand");
		//设置鼠标进入窗口的图案
		customecur = Toolkit.getDefaultToolkit().createCustomCursor(Constant.imageMap.get("mouse1.png").getImage(), new Point(10,10), "custom");
		frame.setCursor(customecur);
		//获取开始游戏的图片
		ImageIcon startImg = Constant.imageMap.get("startGame.png");
		//创建按钮
		start = new JButton(startImg);
		//按钮的设置
		start.setBounds(100, 200, 200, 70);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		start.setFocusPainted(false);
		start.setPressedIcon(Constant.imageMap.get("startGame2.png"));
		//匿名点击事件
		start.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new Game().init();
			}
		});
		frame.add(start);
		//获取游戏设置的图片
		ImageIcon setGame = Constant.imageMap.get("setGame.png");
		//创建游戏设置按钮
		set = new JButton(setGame);
		//按钮的设置
		set.setBounds(100, 300, 200, 70);
		set.setContentAreaFilled(false);
		set.setBorderPainted(false);
		set.setFocusPainted(false);
		set.setPressedIcon(Constant.imageMap.get("setGame2.png"));
		//匿名点击事件
		set.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFrame setFrame = new JFrame("游戏设置");
				//设置背景颜色
				//获取背景图片
				ImageIcon bgImage = Constant.imageMap.get("background.png");
				// 把背景图片显示在一个标签里面
				JLabel imageLb = new JLabel(bgImage);
				// 把标签的大小位置设置为图片刚好填充整个面板
				imageLb.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());
				// 把背景图片添加到分层窗格的最底层作为背景
				setFrame.getLayeredPane().add(imageLb, new Integer(Integer.MIN_VALUE));
				// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
				JPanel imagePanel= (JPanel) setFrame.getContentPane();
				imagePanel.setOpaque(false);
				//设置鼠标进入窗口的图案
				Cursor customecur = Toolkit.getDefaultToolkit().createCustomCursor(Constant.imageMap.get("mouse1.png").getImage(), new Point(10,10), "custom");
				setFrame.setCursor(customecur);
				//初始化设置
				setFrame.setLayout(null);
				setFrame.setResizable(false);
				setFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setFrame.setSize(500, 500);
				setFrame.setLocationRelativeTo(null);
				setFrame.setVisible(true);
			}
		});
		frame.add(set);
		//获取退出游戏的图片
		ImageIcon exit = Constant.imageMap.get("Game.png");
		//创建退出游戏按钮
		exitButton = new JButton(exit);
		//按钮的设置
		exitButton.setBounds(100, 400, 200, 70);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.setFocusPainted(false);
		exitButton.setPressedIcon(Constant.imageMap.get("Game2.png"));
		//匿名点击事件
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.add(exitButton);
		//初始化设置
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(805, 605);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//创建多线程画板刷新
		GameThread gameThread = new GameThread();
		Thread thread = new Thread(gameThread);
		thread.start();
	}

	/**
	 * 多线程刷新窗口
	 * @author 小恶魔
	 *
	 */
	class GameThread implements Runnable{
		public void run() {
			while(true){
				jPanel.repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 内部画板类
	 */
	class MyJPanel extends JPanel{
		
		/**
		 * 画板
		 */
		public void paintComponent(Graphics g) {
			//获取开始界面的图片
			ImageIcon start = Constant.imageMap.get("start.png");
			
			//画出开始界面
			g.drawImage(start.getImage(), 0, 0, 800, 600, null);
		}
	}
}
