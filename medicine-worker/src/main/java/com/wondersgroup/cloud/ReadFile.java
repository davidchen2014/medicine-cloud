package com.wondersgroup.cloud;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class ReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readFile1();
	}
	
	public void readFile(){
		 //声明流对象
        FileInputStream fis = null;                 
        try{
             //创建流对象
             fis = new FileInputStream("d:\\upload.txt");
             //读取数据，并将读取到的数据存储到数组中
             byte[] data = new byte[1024]; //数据存储的数组
             int i = 0; //当前下标
             //读取流中的第一个字节数据
             int n = fis.read();
             //依次读取后续的数据
             while(n != -1){ //未到达流的末尾
                  //将有效数据存储到数组中
                  data[i] = (byte)n;
                  //下标增加
                  i++;
                  //读取下一个字节的数据
                   n = fis.read();
             }

             //解析数据
             String s = new String(data,0,i);
             //输出字符串
             System.out.println(s);
        }catch(Exception e){
                 e.printStackTrace();
        }finally{
             try{
                      //关闭流，释放资源
                      fis.close();
             }catch(Exception e){}
        }
	}
	
	public static void readFile1(){
		// read file content from file
		StringBuffer sb= null;
		FileReader reader = null;
		BufferedReader br = null;
		try{
			sb= new StringBuffer("");
			reader = new FileReader("d://upload.txt");
			br = new BufferedReader(reader);
	        String str = null;
	        while((str = br.readLine()) != null) {
	              sb.append(str+"/n");
	              System.out.println(str);
	        }
	       
		}catch(Exception e){
            e.printStackTrace();
		}finally{
            try{
                //关闭流，释放资源
            	br.close();
     	        reader.close();
            }catch(Exception e){
            	
            }
		}
	}
}
