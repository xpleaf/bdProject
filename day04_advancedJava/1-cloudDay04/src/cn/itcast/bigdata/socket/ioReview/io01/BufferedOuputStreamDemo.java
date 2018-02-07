package cn.itcast.bigdata.socket.ioReview.io01;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOuputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("/Users/yeyonghao/test.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write("hello".getBytes());
		bos.close();
	}
}
