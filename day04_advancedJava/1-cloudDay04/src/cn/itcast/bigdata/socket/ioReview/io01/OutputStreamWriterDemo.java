package cn.itcast.bigdata.socket.ioReview.io01;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class OutputStreamWriterDemo {
	
	@Test
	public void writeUTF() throws Exception {
		FileOutputStream fos = new FileOutputStream("/Users/yeyonghao/test.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		osw.write("你好");
		osw.flush();
		osw.close();
	}
	
	@Test
	public void writeGBK() throws Exception {
		FileOutputStream fos = new FileOutputStream("/Users/yeyonghao/test.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		osw.write("你好");
		osw.close();
	}
}
