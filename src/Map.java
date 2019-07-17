package com.yidu.QQTang.quantao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 地图配置类
 * @author 小恶魔
 *
 */
public class Map {
	//数据容器
	List<String> list = new ArrayList<String>();
	
	//二位数组元素
	int[][] map = null;
	//把地图文件加载成二维数组
	public void testResult(){
		
	}
	/**
	 * 读取地图
	 * @return 返回二位数组
	 */
	public int[][] readMap(){
		  // 构造文件输入流
        FileInputStream fis;
		try {
			fis = new FileInputStream("src\\com\\yidu\\QQTang\\quantao\\map.txt");
			InputStreamReader isr = new InputStreamReader(fis);
	        BufferedReader br = new BufferedReader(isr);
	        //直接读取一行数据
	        String value = br.readLine();

	        while(value != null){
	        	//将读取到的一行数据放入容器中
	        	list.add(value);
	        	value = br.readLine();
	        }
	        br.close();
	        //得到多少行多少列
	        int row = list.size();
	        int cloum = 0;
	        for (int i = 0; i < 1; i++) {
				String str = list.get(i);
				String[] values = str.split(",");
				cloum = values.length;
			}
	        
	        map = new int[row][cloum];
	        
	        //将读到的字符串转换成整数，并赋值给二维数组map[][]
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
