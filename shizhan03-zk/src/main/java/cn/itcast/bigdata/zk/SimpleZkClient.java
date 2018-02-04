package cn.itcast.bigdata.zk;

import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.junit.Before;
import org.junit.Test;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class SimpleZkClient {

	private static final String connectString = "mini1:2181,mini2:2181,mini3:2181";
	private static final int sessionTimeout = 2000;
	ZooKeeper zkClient = null;

	@Before
	public void init() throws Exception {
		zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			public void process(WatchedEvent event) {
				// 收到事件通知后的回调函数，事件处理逻辑
				System.out.println(event.getType() + "---" + event.getPath());
				try {
					zkClient.getChildren("/", true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	@Test
	public void testExist() throws Exception {
		Stat stat = zkClient.exists("/eclipse", false);
		System.out.println(stat==null ? "not exist":"exist");
	}

	@Test
	public void testCreate() throws Exception {
		String nodeCreated = zkClient.create("/eclipse", "hellozk".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.PERSISTENT);
	}
	
	@Test
	public void testGetChildren() throws Exception {
		List<String> children = zkClient.getChildren("/", true);
		for (String child : children) {
			System.out.println(child);
		}
		System.in.read();
	}
	
	@Test
	public void getData() throws Exception {
		byte[] data = zkClient.getData("/eclipse", false, null);
		System.out.println(new String(data));
	}
	
	@Test
	public void deleteZnode() throws Exception {
		zkClient.delete("/eclipse", -1);
	}
	
	@Test
	public void setData() throws Exception {
		zkClient.setData("/app1", "hello".getBytes(), -1);
		byte[] data = zkClient.getData("/app1", false, null);
		System.out.println(new String(data));
	}
}
