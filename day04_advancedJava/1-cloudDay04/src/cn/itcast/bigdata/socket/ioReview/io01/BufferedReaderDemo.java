package cn.itcast.bigdata.socket.ioReview.io01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("/Users/yeyonghao/test.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
