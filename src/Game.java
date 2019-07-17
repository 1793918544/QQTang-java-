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
 * ��Ϸ�����
 * @author С��ħ
 * @date  2019/7/1
 *
 */
public class Game {
	/**
	 * main����
	 * @param args �ַ�������
	 */
	public static void main(String[] args) {
		//������Ϸ��ڵĴ��ڳ�ʼ������
		new Game().init();
	}
	 //����
	JFrame frame; 
	//���
	Player player;  
	//���2
	Player players;
	//��Ϸ��塢��̨
	GamePanel gamePanel;  
	//������
	Controller controller; 
	//��ͼ
	MapImg mapImg;  
	//�ٶȵ���
	Speed speed;
	//��������
	Count count;
	//��������
	Might might;
	//��Ǯ����
	Gold gold;
	//���߼���
	List<Prop> propList = new ArrayList<Prop>();
	//��ͼ�ϰ��Ｏ��
	List<MapImg> mapList = new ArrayList<MapImg>();
	//�ֱ��壺��ש����ש����ƿ��������
	MapImg brick1,brick2,vase,cactus;
	//��ͼ���ݣ��ƶ�����1����ש��2����ש��3����ƿ��4��������
	int[][] map = null;
	{
		//ʵ��������г�ʼ����ͼ��Դ������
		Map mp = new Map();
		//��ȡ  mp ���ݣ���map����
		map = mp.readMap();
	}
	//����
	Music music;
	//�÷���ʱ��
	Scoring scoring;
	/**
	 * ���ڳ�ʼ��
	 */
	public void init(){
		frame = new JFrame("QQ�� - һ���������Ϸ");
		mapRule();
		//��ȡ��ϷIco
		ImageIcon imgIcon = Constant.imageMap.get("Icon.png");
		//���ô���Сͼ��
	    frame.setIconImage(imgIcon.getImage());
		//������Ҷ���
		player = new Player(50,142,mapList);
		//�������2����
		players = new Player(1450,142,mapList,false);
		//eMemes.add(eMeme);
		//��������ֵ����
		count = new Count(30, 0);
		//����ʱ��÷���ʾ����
		scoring = new Scoring(player,players,frame);
		//������Ϸƽ̨
		gamePanel = new GamePanel(player, null, mapList, count,brick1,brick2,vase,cactus,map,propList,players,scoring);
		//�ѻ�����ӵ�����
		frame.add(gamePanel);
		//��Ӽ����¼�
		controller = new Controller(player,players);
		//���ֲ���
		music = new Music("src\\com\\yidu\\QQTang\\quantao\\Music\\bgm.wav");
		//����
		music.startMusic();
		//�󶨴���
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				music.musicStop();
			}
			
		});
		//���ڳ�ʼ����
		frame.addKeyListener(controller);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(1608, 950);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//Music();
	}
	/**
	 * �����ͼ�Ĺ���
	 */
	private void mapRule() {
		//��ȡ��ͼ�������õ�ͼ  map��ά����ĳ���
		for (int i = 0; i < map.length; i++) {
			//ѭ��map[0]һά����
			for (int j = 0; j < map[0].length; j++) {
				//��ȡ������1 ����ש
				if (map[i][j] == 1) {
					//����ԭʼש����� X��Ϊ j*50 Y��Ϊ i*50+122
					brick1 = new MapImg(j*50,i*50 + 122,50,50,Constant.imageMap.get("ԭʼש��.png"));
					mapList.add(brick1);
					//��ש��ĺ������ܱ���11 Ϊ0  ���� ש���Y���� �� 8 ���� 0 �����һ���ٶȵ���
					if (brick1.positionX %11 == 0 && brick1.positionY % 8 == 0) {
						//�����ٶȵ���
						speed = new Speed(brick1.positionX, brick1.positionY);
						//���ٶȵ��߼�����߼���
						propList.add(speed);
					}
					//��ש��ĺ���������6 = 0 �����һ����ҵ���
					if (brick1.positionX %6 == 0) {
						//������Ҷ���
						gold = new Gold(brick1.positionX, brick1.positionY);
						//�ѽ�Ҷ��������߼���
						propList.add(gold);
					}
				}
				//��ȡ������3 ����ƿ
				if (map[i][j] == 3) {
					//������ƿ���� X��Ϊ j*50 Y��Ϊ i*50+122
					vase = new MapImg(j*50,i*50 + 122,50,50,Constant.imageMap.get("��ƿ.png"));
					//�ѻ�ƿ������뵽��ͼ����
					mapList.add(vase);
				}
			}
		}
	}
}
