package com.yidu.QQTang.quantao;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

/**
 * �����࣬����ɻ��߶ȡ���ȣ���Ϸ���߶ȡ���ȵ���Ϣ
 * @author С��ħ
 *
 */
public final class Constant {
	/**
	 * ���ͼƬ���
	 */
	public static final int MEME_WIDTH = 44;
	/**
	 * ���ͼƬ�߶�
	 */
	public static final int MEME_HEIGHT = 59;
	/**
	 * ��Ϸ���Ŀ��
	 */
	public static final int GAMEPANEL_WIDTH = 800;
	/**
	 * ��Ϸ���ĸ߶�
	 */
	public static final int GAMEPANEL_HEIGHT = 600;
	/**
	 * ���ݣ�ը����ͼƬ���
	 */
	public static final int XIGUA_WIDTH = 40;
	/**
	 * ���ݣ�ը����ͼƬ�߶�
	 */
	public static final int XIGUA_HEIGHT = 48;
	/**
	 * ��ըЧ��ͼƬ�߶�
	 */
	public static final int BOOM_HEIGHT = 41;
	/**
	 * ��ըЧ��ͼƬ���
	 */
	public static final int BOOM_WIDTH = 41;
	/**
	 * ���߸߶�
	 */
	public static final int PROP_HEIGHT = 40;
	/**
	 * ���߿��
	 */
	public static final int PROP_WIDTH = 40;
	//public static final int ENEMY_HEALTH = 1;
	
	//public static final int BOSS_WIDTH = 80;
	//public static final int BOSS_HEIGHT = 100;
	

	
	/**
	 * �����췽��˽�У���粻�ɴ����������
	 */
	private Constant(){}
	
    /**
     * һ�����ͼƬ��ӳ�� ��ֵͼƬΪ���ƣ�valueֵΪ��ͼƬ��BufferImage����
     */
	public static Map<String,ImageIcon> imageMap = new HashMap<String,ImageIcon>();
	
	/**
	 * ����Ϸ��������ִ�иô���飬����ִֻ��һ��
	 * �þ�̬�����������ǽ���ͼƬ���뵽imageMap��
	 */
	static{
		//�����ȡ��ըЧ����ͼƬ
		try { 
			//�õ���Դ�ļ��е�URL��ͳһ��Դ��λ����
			URL url = Constant.class.getResource("/com/yidu/QQTang/quantao/Images/Exploding"); 
			//��urlת��Ϊuri  uri: ͳһ��Դʶ���
			URI uri = url.toURI();
		    //����uri�����ļ�����	
			File resFile = new File(uri);
			//�г�����Դ�ļ������������ļ��Ķ�������
			File[] files = resFile.listFiles();
			//������Դ�ļ����µ����ļ���������
			for(File file:files){
				//����ļ���
				String fileName= file.getName();
				//�ж��ļ��Ƿ�ΪͼƬ��ʽ��*.png,*.jpg,*.bmp,*.jpeg,*.gif
				if (fileName.endsWith(".jpg") || fileName.endsWith(".png")
						|| fileName.endsWith(".jpeg") || fileName.endsWith(".bmp")
						|| fileName.endsWith(".gif")) {
					//����ImageIO�ཫͼƬ���룬������ImageIcon����
					ImageIcon img = new ImageIcon("src\\com\\yidu\\QQTang\\quantao\\Images\\Exploding\\"+fileName);
					
					//��BufferedImage�������imageMapӳ����
					imageMap.put(fileName,img);
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�����ȡ��ͼ���ͼƬ
		try { 
			//�õ���Դ�ļ��е�URL��ͳһ��Դ��λ����
			URL url = Constant.class.getResource("/com/yidu/QQTang/quantao/Images/Map"); 
			//��urlת��Ϊuri  uri: ͳһ��Դʶ���
			URI uri = url.toURI();
		    //����uri�����ļ�����	
			File resFile = new File(uri);
			//�г�����Դ�ļ������������ļ��Ķ�������
			File[] files = resFile.listFiles();
			//������Դ�ļ����µ����ļ���������
			for(File file:files){
				//����ļ���
				String fileName= file.getName();
				//�ж��ļ��Ƿ�ΪͼƬ��ʽ��*.png,*.jpg,*.bmp,*.jpeg,*.gif
				if (fileName.endsWith(".jpg") || fileName.endsWith(".png")
						|| fileName.endsWith(".jpeg") || fileName.endsWith(".bmp")
						|| fileName.endsWith(".gif")) {
					//����ImageIO�ཫͼƬ���룬������BufferImage����
					ImageIcon img = new ImageIcon("src\\com\\yidu\\QQTang\\quantao\\Images\\Map\\"+fileName);
					//��BufferedImage�������imageMapӳ����
					imageMap.put(fileName,img);
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�����ȡ����ͼƬ
		try { 
			//�õ���Դ�ļ��е�URL��ͳһ��Դ��λ����
			URL url = Constant.class.getResource("/com/yidu/QQTang/quantao/Images/SunWuKong"); 
			//��urlת��Ϊuri  uri: ͳһ��Դʶ���
			URI uri = url.toURI();
		    //����uri�����ļ�����	
			File resFile = new File(uri);
			//�г�����Դ�ļ������������ļ��Ķ�������
			File[] files = resFile.listFiles();
			//������Դ�ļ����µ����ļ���������
			for(File file:files){
				//����ļ���
				String fileName= file.getName();
				//�ж��ļ��Ƿ�ΪͼƬ��ʽ��*.png,*.jpg,*.bmp,*.jpeg,*.gif
				if (fileName.endsWith(".jpg") || fileName.endsWith(".png")
						|| fileName.endsWith(".jpeg") || fileName.endsWith(".bmp")
						|| fileName.endsWith(".gif")) {
					//����ImageIO�ཫͼƬ���룬������BufferImage����
					ImageIcon img = new ImageIcon("src\\com\\yidu\\QQTang\\quantao\\Images\\SunWuKong\\"+fileName);
					//��BufferedImage�������imageMapӳ����
					imageMap.put(fileName,img);
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
