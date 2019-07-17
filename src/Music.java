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
 * ������
 * @author С��ħ
 * @date 2019/7/1
 */
public class Music {
	//����·��
	private String musicPath;
	//����״̬  1.��δ��ʼ  2.���ڲ���  3.���Ž���
	private int musicCondition;
	/**
	 * ������Ĺ��캯��
	 * @param musicPath  ����·��
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
    	//��ʼ����
    	new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					//���ֲ����ļ�
					File file = new File(musicPath);
					
					//���ֲ������
					AudioInputStream musicRukou = AudioSystem.getAudioInputStream(file);
					//��ʽ����Ϣ��������ڣ���Ϊ�˵õ���������Ϣ
					AudioFormat musicFormat = musicRukou.getFormat();
					//�����������Ϣ
					DataLine.Info musicShujvhang = new DataLine.Info(SourceDataLine.class, musicFormat);
					//ǿת��������Ϣ
					SourceDataLine musicLine = (SourceDataLine) AudioSystem.getLine(musicShujvhang);
					  //�����ֽ���
					byte[] buf = new byte[512 * 1024];
			        musicLine.open();//�������ļ�
			        musicLine.start();//��ʼ��������
			        int i=0;
			        while(i!=-1) {
			        	 if(musicCondition==3) 
			        	 	{break ;}//�����жϣ�ֹͣ����
			        	i = musicRukou.read(buf, 0,buf.length );//��ڶ�ȡ
			        	if(i>=0) {
			        		musicLine.write(buf, 0,i);//������д����
			        	}
			        }
			        musicLine.drain();//����һ������ղ�һ�������
		        	musicLine.close();//�������
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
    //ֹͣ��������
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
