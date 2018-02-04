package cn.itcast.bigdata.zkdist;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class DistributedServer {

	private static final String connectString = "mini1:2181,mini2:2181,mini3:2181";
	private static final int sessionTimeout = 2000;
	private static final String parentNode = "/servers";

	private ZooKeeper zk = null;

	public void getConnect() throws Exception {
		zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			public void process(WatchedEvent event) {
				// 收到事件通知后的回调函数，事件处理逻辑
				System.out.println(event.getType() + "---" + event.getPath());
				try {
					zk.getChildren("/", true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void registerServer(String hostname) throws Exception {
		String create = zk.create(parentNode + "/server", hostname.getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println(hostname + " is online..." + create);
	}
	
	public void handleBussiness(String hostname) throws Exception {
		System.out.println(hostname + " start working...");
		System.in.read();
	}

	public static void main(String[] args) throws Exception {

		// 获取zk连接
		DistributedServer server = new DistributedServer();
		server.getConnect();

		// 向zk注册服务器信息
		String hostname = args[0];
		server.registerServer(hostname);
		
		// 启用业务功能
		server.handleBussiness(hostname);
		
	}

}
