package cn.itcast.bigdata.socket.ioReview.io01;

import java.io.FileReader;
import java.io.OutputStream;

public class ReaderDemo {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("/Users/yeyonghao/test.txt");
		char[] ch = new char[1024];
		int len = 0;
		while((len = fr.read(ch)) != -1) {
			System.out.println(new String(ch, 0, len));
		}
		fr.close();
	}
}
