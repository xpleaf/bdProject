package cn.itcast.bigdata.socket.ioReview.io01;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class InputStreamReaderDemo {
	
	@Test
	public void readUTF() throws Exception {
		FileInputStream fis = new FileInputStream("/Users/yeyonghao/test.txt");
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		char[] ch = new char[1024];
		int len = isr.read(ch);
		System.out.println(new String(ch, 0, len));
		isr.close();
	}
	
	@Test
	public void readGBK() throws Exception {
		FileInputStream fis = new FileInputStream("/Users/yeyonghao/test.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		char[] ch = new char[1024];
		int len = isr.read(ch);
		System.out.println(new String(ch, 0, len));
		isr.close();
	}
}
