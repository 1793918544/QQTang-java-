package com.yidu.QQTang.quantao;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 游戏的入口
 * @author 小恶魔
 * @date  2019/7/1
 *
 */
public class Game {
	/**
	 * main方法
	 * @param args 字符串数组
	 */
	public static void main(String[] args) {
		//调用游戏入口的窗口初始化方法
		new Game().init();
	}
	 //窗口
	JFrame frame; 
	//玩家
	Player player;  
	//玩家2
	Player players;
	//游戏面板、舞台
	GamePanel gamePanel;  
	//控制器
	Controller controller; 
	//地图
	MapImg mapImg;  
	//速度道具
	Speed speed;
	//加命道具
	Count count;
	//威力道具
	Might might;
	//金钱道具
	Gold gold;
	//道具集合
	List<Prop> propList = new ArrayList<Prop>();
	//地图障碍物集合
	List<MapImg> mapList = new ArrayList<MapImg>();
	//分别定义：黄砖，红砖，花瓶，仙人掌
	MapImg brick1,brick2,vase,cactus;
	//地图数据，制定规则，1画黄砖，2画红砖，3画花瓶，4画仙人掌
	int[][] map = null;
	{
		//实例代码块中初始化地图资源的数据
		Map mp = new Map();
		//读取  mp 数据，用map保存
		map = mp.readMap();
	}
	//音乐
	Music music;
	//得分与时间
	Scoring scoring;
	/**
	 * 窗口初始化
	 */
	public void init(){
		frame = new JFrame("QQ堂 - 一度最火热游戏");
		mapRule();
		//获取游戏Ico
		ImageIcon imgIcon = Constant.imageMap.get("Icon.png");
		//设置窗体小图标
	    frame.setIconImage(imgIcon.getImage());
		//创建玩家对象
		player = new Player(50,142,mapList);
		//创建玩家2对象
		players = new Player(1450,142,mapList,false);
		//eMemes.add(eMeme);
		//创建生命值道具
		count = new Count(30, 0);
		//创建时间得分显示对象
		scoring = new Scoring(player,players,frame);
		//创建游戏平台
		gamePanel = new GamePanel(player, null, mapList, count,brick1,brick2,vase,cactus,map,propList,players,scoring);
		//把画板添加到窗口
		frame.add(gamePanel);
		//添加监听事件
		controller = new Controller(player,players);
		//音乐播放
		music = new Music("src\\com\\yidu\\QQTang\\quantao\\Music\\bgm.wav");
		//播放
		music.startMusic();
		//绑定窗口
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				music.musicStop();
			}
			
		});
		//窗口初始设置
		frame.addKeyListener(controller);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(1608, 950);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//Music();
	}
	/**
	 * 定义地图的规则
	 */
	private void mapRule() {
		//读取地图，并配置地图  map二维数组的长度
		for (int i = 0; i < map.length; i++) {
			//循环map[0]一维数组
			for (int j = 0; j < map[0].length; j++) {
				//读取到的是1 画黄砖
				if (map[i][j] == 1) {
					//创建原始砖块对象 X轴为 j*50 Y轴为 i*50+122
					brick1 = new MapImg(j*50,i*50 + 122,50,50,Constant.imageMap.get("原始砖块.png"));
					mapList.add(brick1);
					//当砖块的横坐标能被余11 为0  并且 砖块的Y坐标 余 8 等于 0 既添加一个速度道具
					if (brick1.positionX %11 == 0 && brick1.positionY % 8 == 0) {
						//创建速度道具
						speed = new Speed(brick1.positionX, brick1.positionY);
						//把速度道具加入道具集合
						propList.add(speed);
					}
					//当砖块的横坐标能余6 = 0 既添加一个金币道具
					if (brick1.positionX %6 == 0) {
						//创建金币对象
						gold = new Gold(brick1.positionX, brick1.positionY);
						//把金币对象加入道具集合
						propList.add(gold);
					}
				}
				//读取到的是3 画花瓶
				if (map[i][j] == 3) {
					//创建花瓶对象 X轴为 j*50 Y轴为 i*50+122
					vase = new MapImg(j*50,i*50 + 122,50,50,Constant.imageMap.get("花瓶.png"));
					//把花瓶对象加入到地图集合
					mapList.add(vase);
				}
			}
		}
	}
}
