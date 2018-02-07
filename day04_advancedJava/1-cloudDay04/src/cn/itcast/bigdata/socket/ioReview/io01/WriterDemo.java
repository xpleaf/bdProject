package cn.itcast.bigdata.socket.ioReview.io01;

import java.io.FileWriter;

public class WriterDemo {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("/Users/yeyonghao/test.txt");
		
		fw.write(100);
		fw.flush();
		
		char[] c = {'a','b','c','d','e'};
		fw.write(c);
		fw.flush();
		
		fw.write(c, 2, 2);
		fw.flush();
		
		fw.write("hello");
		fw.flush();
		
		fw.close();
	}
}
