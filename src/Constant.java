package com.yidu.QQTang.quantao;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

/**
 * 常量类，保存飞机高度、宽度，游戏面板高度、宽度等信息
 * @author 小恶魔
 *
 */
public final class Constant {
	/**
	 * 玩家图片宽度
	 */
	public static final int MEME_WIDTH = 44;
	/**
	 * 玩家图片高度
	 */
	public static final int MEME_HEIGHT = 59;
	/**
	 * 游戏面板的宽度
	 */
	public static final int GAMEPANEL_WIDTH = 800;
	/**
	 * 游戏面板的高度
	 */
	public static final int GAMEPANEL_HEIGHT = 600;
	/**
	 * 气泡（炸弹）图片宽度
	 */
	public static final int XIGUA_WIDTH = 40;
	/**
	 * 气泡（炸弹）图片高度
	 */
	public static final int XIGUA_HEIGHT = 48;
	/**
	 * 爆炸效果图片高度
	 */
	public static final int BOOM_HEIGHT = 41;
	/**
	 * 爆炸效果图片宽度
	 */
	public static final int BOOM_WIDTH = 41;
	/**
	 * 道具高度
	 */
	public static final int PROP_HEIGHT = 40;
	/**
	 * 道具宽度
	 */
	public static final int PROP_WIDTH = 40;
	//public static final int ENEMY_HEALTH = 1;
	
	//public static final int BOSS_WIDTH = 80;
	//public static final int BOSS_HEIGHT = 100;
	

	
	/**
	 * 将构造方法私有，外界不可创建本类对象
	 */
	private Constant(){}
	
    /**
     * 一个存放图片的映射 键值图片为名称，value值为该图片的BufferImage对象
     */
	public static Map<String,ImageIcon> imageMap = new HashMap<String,ImageIcon>();
	
	/**
	 * 在游戏启动，就执行该代码块，而且只执行一次
	 * 该静态代码块的作用是将各图片读入到imageMap中
	 */
	static{
		//这里获取爆炸效果的图片
		try { 
			//拿到资源文件夹的URL（统一资源定位符）
			URL url = Constant.class.getResource("/com/yidu/QQTang/quantao/Images/Exploding"); 
			//将url转换为uri  uri: 统一资源识别符
			URI uri = url.toURI();
		    //根据uri创建文件对象	
			File resFile = new File(uri);
			//列出该资源文件夹下所有子文件的对象数组
			File[] files = resFile.listFiles();
			//遍历资源文件夹下的子文件对象数组
			for(File file:files){
				//获得文件名
				String fileName= file.getName();
				//判断文件是否为图片格式：*.png,*.jpg,*.bmp,*.jpeg,*.gif
				if (fileName.endsWith(".jpg") || fileName.endsWith(".png")
						|| fileName.endsWith(".jpeg") || fileName.endsWith(".bmp")
						|| fileName.endsWith(".gif")) {
					//利用ImageIO类将图片读入，并生成ImageIcon对象
					ImageIcon img = new ImageIcon("src\\com\\yidu\\QQTang\\quantao\\Images\\Exploding\\"+fileName);
					
					//将BufferedImage对象存入imageMap映射中
					imageMap.put(fileName,img);
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//这里获取地图相关图片
		try { 
			//拿到资源文件夹的URL（统一资源定位符）
			URL url = Constant.class.getResource("/com/yidu/QQTang/quantao/Images/Map"); 
			//将url转换为uri  uri: 统一资源识别符
			URI uri = url.toURI();
		    //根据uri创建文件对象	
			File resFile = new File(uri);
			//列出该资源文件夹下所有子文件的对象数组
			File[] files = resFile.listFiles();
			//遍历资源文件夹下的子文件对象数组
			for(File file:files){
				//获得文件名
				String fileName= file.getName();
				//判断文件是否为图片格式：*.png,*.jpg,*.bmp,*.jpeg,*.gif
				if (fileName.endsWith(".jpg") || fileName.endsWith(".png")
						|| fileName.endsWith(".jpeg") || fileName.endsWith(".bmp")
						|| fileName.endsWith(".gif")) {
					//利用ImageIO类将图片读入，并生成BufferImage对象
					ImageIcon img = new ImageIcon("src\\com\\yidu\\QQTang\\quantao\\Images\\Map\\"+fileName);
					//将BufferedImage对象存入imageMap映射中
					imageMap.put(fileName,img);
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//这里获取人物图片
		try { 
			//拿到资源文件夹的URL（统一资源定位符）
			URL url = Constant.class.getResource("/com/yidu/QQTang/quantao/Images/SunWuKong"); 
			//将url转换为uri  uri: 统一资源识别符
			URI uri = url.toURI();
		    //根据uri创建文件对象	
			File resFile = new File(uri);
			//列出该资源文件夹下所有子文件的对象数组
			File[] files = resFile.listFiles();
			//遍历资源文件夹下的子文件对象数组
			for(File file:files){
				//获得文件名
				String fileName= file.getName();
				//判断文件是否为图片格式：*.png,*.jpg,*.bmp,*.jpeg,*.gif
				if (fileName.endsWith(".jpg") || fileName.endsWith(".png")
						|| fileName.endsWith(".jpeg") || fileName.endsWith(".bmp")
						|| fileName.endsWith(".gif")) {
					//利用ImageIO类将图片读入，并生成BufferImage对象
					ImageIcon img = new ImageIcon("src\\com\\yidu\\QQTang\\quantao\\Images\\SunWuKong\\"+fileName);
					//将BufferedImage对象存入imageMap映射中
					imageMap.put(fileName,img);
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
