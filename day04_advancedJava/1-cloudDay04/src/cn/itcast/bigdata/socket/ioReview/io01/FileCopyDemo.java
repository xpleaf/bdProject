package cn.itcast.bigdata.socket.ioReview.io01;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyDemo {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("/Users/yeyonghao/hadoop-common-2.6.4.jar");
		FileOutputStream fos = new FileOutputStream("/Users/yeyonghao/copy.jar");
		byte[] data = new byte[1024];
		int len = 0;
		while((len = fis.read(data)) != -1) {
			fos.write(data, 0, len);
		}
		fis.close();
		fos.close();
	}
}
