package cn.itcast.bigdata.socket.ioReview.io01;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class BufferedWriterDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("/Users/yeyonghao/test.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("hello");
		bw.flush();
		bw.newLine();
		bw.write("xpleaf");
		bw.close();
	}
}
