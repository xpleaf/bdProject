package cn.itcast.bigdata.socket.ioReview.io01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("/Users/yeyonghao/test.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] bytes = new byte[1024];
		int len = 0;
		while((len = bis.read(bytes)) != -1) {
			System.out.println(new String(bytes, 0, len));
		}
	}
}
