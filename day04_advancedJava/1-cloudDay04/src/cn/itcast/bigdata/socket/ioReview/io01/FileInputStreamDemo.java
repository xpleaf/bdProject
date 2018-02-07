package cn.itcast.bigdata.socket.ioReview.io01;

import java.io.FileInputStream;

public class FileInputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("/Users/yeyonghao/test.txt");
		byte[] bytes = new byte[1024];
		int len = 0;
		while((len = in.read(bytes)) != -1) {
			System.out.println(new String(bytes, 0, len));
		}
	}
}
