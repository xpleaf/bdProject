package cn.xpleaf.test;

public class TestDaemon {
	public static void main(String[] args) {
		System.out.println("主线程开始了...");
		Thread thread = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("非主线程开始了...");
				while(true) {
					
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
	}
}
