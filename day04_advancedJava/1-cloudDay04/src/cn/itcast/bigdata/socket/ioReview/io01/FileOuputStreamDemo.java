package cn.itcast.bigdata.socket.ioReview.io01;

import java.io.FileOutputStream;

public class FileOuputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("/Users/yeyonghao/test.txt", true);
		fos.write("\n".getBytes());
		fos.write(97);

		byte[] bytes = {65,66,67,68};
		fos.write(bytes);
		fos.write(bytes, 0, 2);
		fos.write("hello".getBytes());
		fos.close();
	}
}
