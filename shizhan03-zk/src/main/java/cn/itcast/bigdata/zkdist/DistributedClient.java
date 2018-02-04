package cn.itcast.bigdata.zkdist;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class DistributedClient {

	private static final String connectString = "mini1:2181,mini2:2181,mini3:2181";
	private static final int sessionTimeout = 2000;
	private static final String parentNode = "/servers";

	private volatile List<String> serverList;
	private ZooKeeper zk = null;

	public void getConnect() throws Exception {
		zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			public void process(WatchedEvent event) {
				// 收到事件通知后的回调函数，事件处理逻辑
				System.out.println(event.getType() + "---" + event.getPath());
				try {
					getServerList();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getServerList() throws Exception {
		List<String> children = zk.getChildren(parentNode, true);
		List<String> servers = new ArrayList<String>();
		for (String child : children) {
			byte[] data = zk.getData(parentNode + "/" + child, false, null);
			servers.add(new String(data));
		}
		serverList = servers;
		System.out.println(serverList);
	}

	public void handleBussiness() throws Exception {
		System.out.println("client start working...");
		System.in.read();
	}

	public static void main(String[] args) throws Exception {
		// 获取zk连接
		DistributedClient client = new DistributedClient();
		client.getConnect();

		// 获取servers的子节点信息（同时侦听），从中获取服务器信息列表
		client.getServerList();

		// 业务线程启动
		client.handleBussiness();
	}
}
