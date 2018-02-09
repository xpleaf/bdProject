package cn.itcast_01_hadooprpc.client;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import cn.itcast_01_hadooprpc.protocol.SomeService;

public class MyClient {
	public static void main(String[] args) throws Exception{
		SomeService someService = RPC.getProxy(
				SomeService.class, Long.MAX_VALUE, new InetSocketAddress(
						"localhost", 5555), new Configuration());
		String ret = someService.heartBeat("wilson");
		System.out.println(ret);
	}
}
