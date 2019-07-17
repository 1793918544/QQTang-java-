package com.yidu.QQTang.quantao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ͼ������
 * @author С��ħ
 *
 */
public class Map {
	//��������
	List<String> list = new ArrayList<String>();
	
	//��λ����Ԫ��
	int[][] map = null;
	//�ѵ�ͼ�ļ����سɶ�ά����
	public void testResult(){
		
	}
	/**
	 * ��ȡ��ͼ
	 * @return ���ض�λ����
	 */
	public int[][] readMap(){
		  // �����ļ�������
        FileInputStream fis;
		try {
			fis = new FileInputStream("src\\com\\yidu\\QQTang\\quantao\\map.txt");
			InputStreamReader isr = new InputStreamReader(fis);
	        BufferedReader br = new BufferedReader(isr);
	        //ֱ�Ӷ�ȡһ������
	        String value = br.readLine();

	        while(value != null){
	        	//����ȡ����һ�����ݷ���������
	        	list.add(value);
	        	value = br.readLine();
	        }
	        br.close();
	        //�õ������ж�����
	        int row = list.size();
	        int cloum = 0;
	        for (int i = 0; i < 1; i++) {
				String str = list.get(i);
				String[] values = str.split(",");
				cloum = values.length;
			}
	        
	        map = new int[row][cloum];
	        
	        //���������ַ���ת��������������ֵ����ά����map[][]
	        for (int i = 0; i < list.size(); i++) {
				String str = list.get(i);
				String[] values = str.split(",");
				for (int j = 0; j < values.length; j++) {
					map[i][j] = Integer.parseInt(values[j]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
