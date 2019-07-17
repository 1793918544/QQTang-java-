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
 * ��Ϸ��ʼ����
 * @author С��ħ
 * @date  2019/7/1
 */
public class StartFrame{
	public static void main(String[] args) {
		new StartFrame().init();
	}
	//�����������
	MyJPanel jPanel = new MyJPanel();
	//�����봰�ڵ�ͼ��
	Cursor customecur;
	//�������ť��ͼ��
	Cursor handcur;
	//��Ϸ��ʼ��ť
	JButton start;
	//��Ϸ���ð�ť
	JButton set;
	//��Ϸ�˳���ť
	JButton exitButton;
	//����
	JFrame frame = new JFrame("������ - ��ʼ��Ϸ");;
	/**
	 * ���ڳ�ʼ��
	 */
	public void init(){
		
		//����ͼƬ
		ImageIcon imageIcon = new ImageIcon("src\\com\\yidu\\QQTang\\quantao\\Images\\Map\\start.png");
		// �ѱ���ͼƬ��ʾ��һ����ǩ����
		JLabel imageLb = new JLabel(imageIcon);
		// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		imageLb.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
		// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		frame.getLayeredPane().add(imageLb, new Integer(Integer.MIN_VALUE));
		// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		JPanel imagePanel= (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		//��ȡ��ϷIco
		ImageIcon imgIcon = Constant.imageMap.get("Icon.png");
		//���ô���Сͼ��
	    frame.setIconImage(imgIcon.getImage());
		frame.add(jPanel);
		//���ô������ɲ���
		frame.setLayout(null);
		//�������ͼ��
		handcur = Toolkit.getDefaultToolkit().createCustomCursor(Constant.imageMap.get("mouse2.png").getImage(), new Point(10,10), "hand");
		//���������봰�ڵ�ͼ��
		customecur = Toolkit.getDefaultToolkit().createCustomCursor(Constant.imageMap.get("mouse1.png").getImage(), new Point(10,10), "custom");
		frame.setCursor(customecur);
		//��ȡ��ʼ��Ϸ��ͼƬ
		ImageIcon startImg = Constant.imageMap.get("startGame.png");
		//������ť
		start = new JButton(startImg);
		//��ť������
		start.setBounds(100, 200, 200, 70);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		start.setFocusPainted(false);
		start.setPressedIcon(Constant.imageMap.get("startGame2.png"));
		//��������¼�
		start.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new Game().init();
			}
		});
		frame.add(start);
		//��ȡ��Ϸ���õ�ͼƬ
		ImageIcon setGame = Constant.imageMap.get("setGame.png");
		//������Ϸ���ð�ť
		set = new JButton(setGame);
		//��ť������
		set.setBounds(100, 300, 200, 70);
		set.setContentAreaFilled(false);
		set.setBorderPainted(false);
		set.setFocusPainted(false);
		set.setPressedIcon(Constant.imageMap.get("setGame2.png"));
		//��������¼�
		set.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFrame setFrame = new JFrame("��Ϸ����");
				//���ñ�����ɫ
				//��ȡ����ͼƬ
				ImageIcon bgImage = Constant.imageMap.get("background.png");
				// �ѱ���ͼƬ��ʾ��һ����ǩ����
				JLabel imageLb = new JLabel(bgImage);
				// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
				imageLb.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());
				// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
				setFrame.getLayeredPane().add(imageLb, new Integer(Integer.MIN_VALUE));
				// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
				JPanel imagePanel= (JPanel) setFrame.getContentPane();
				imagePanel.setOpaque(false);
				//���������봰�ڵ�ͼ��
				Cursor customecur = Toolkit.getDefaultToolkit().createCustomCursor(Constant.imageMap.get("mouse1.png").getImage(), new Point(10,10), "custom");
				setFrame.setCursor(customecur);
				//��ʼ������
				setFrame.setLayout(null);
				setFrame.setResizable(false);
				setFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setFrame.setSize(500, 500);
				setFrame.setLocationRelativeTo(null);
				setFrame.setVisible(true);
			}
		});
		frame.add(set);
		//��ȡ�˳���Ϸ��ͼƬ
		ImageIcon exit = Constant.imageMap.get("Game.png");
		//�����˳���Ϸ��ť
		exitButton = new JButton(exit);
		//��ť������
		exitButton.setBounds(100, 400, 200, 70);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.setFocusPainted(false);
		exitButton.setPressedIcon(Constant.imageMap.get("Game2.png"));
		//��������¼�
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.add(exitButton);
		//��ʼ������
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(805, 605);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//�������̻߳���ˢ��
		GameThread gameThread = new GameThread();
		Thread thread = new Thread(gameThread);
		thread.start();
	}

	/**
	 * ���߳�ˢ�´���
	 * @author С��ħ
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
	 * �ڲ�������
	 */
	class MyJPanel extends JPanel{
		
		/**
		 * ����
		 */
		public void paintComponent(Graphics g) {
			//��ȡ��ʼ�����ͼƬ
			ImageIcon start = Constant.imageMap.get("start.png");
			
			//������ʼ����
			g.drawImage(start.getImage(), 0, 0, 800, 600, null);
		}
	}
}
