package com.yidu.QQTang.quantao;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * 音乐类
 * @author 小恶魔
 * @date 2019/7/1
 */
public class Music {
	//音乐路径
	private String musicPath;
	//音乐状态  1.尚未开始  2.正在播放  3.播放结束
	private int musicCondition;
	/**
	 * 音乐类的构造函数
	 * @param musicPath  音乐路径
	 */
	public Music(String musicPath) {
    	this.musicPath = musicPath;
    	this.musicCondition = 1;
    }
    
    public void startMusic() {
    	if(musicCondition != 1) {
    		return;
    	}
    	musicCondition = 2;
    	//开始播放
    	new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					//音乐播放文件
					File file = new File(musicPath);
					
					//音乐播放入口
					AudioInputStream musicRukou = AudioSystem.getAudioInputStream(file);
					//格式化信息（根据入口），为了得到数据行信息
					AudioFormat musicFormat = musicRukou.getFormat();
					//获得数据行信息
					DataLine.Info musicShujvhang = new DataLine.Info(SourceDataLine.class, musicFormat);
					//强转数据行信息
					SourceDataLine musicLine = (SourceDataLine) AudioSystem.getLine(musicShujvhang);
					  //设置字节流
					byte[] buf = new byte[512 * 1024];
			        musicLine.open();//打开音乐文件
			        musicLine.start();//开始播放音乐
			        int i=0;
			        while(i!=-1) {
			        	 if(musicCondition==3) 
			        	 	{break ;}//音乐中断，停止音乐
			        	i = musicRukou.read(buf, 0,buf.length );//入口读取
			        	if(i>=0) {
			        		musicLine.write(buf, 0,i);//读到哪写到哪
			        	}
			        }
			        musicLine.drain();//数据一排排清空不一下子清空
		        	musicLine.close();//彻底清空
				}  catch (LineUnavailableException e) {
					e.printStackTrace();
				} catch (IOException e) {	
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				}
			}
    		
    	}).start();
    }
    //停止播放音乐
    public void musicStop(){
    	musicCondition = 3;
    }
    
    //---------------set/get-----------------------

	public String getMusicPath() {
		return musicPath;
	}

	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}

	public int getmusicCondition() {
		return musicCondition;
	}

	public void setmusicCondition(int musicZhuangtai) {
		this.musicCondition = musicZhuangtai;
	}
}
