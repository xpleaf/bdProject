package cn.itcast_01_hadooprpc.client;

public interface SomeService {
	public long versionID = Long.MAX_VALUE;

	public String heartBeat(String name);
}
