package cn.itcast_04_springannotation.userdefinedannotation.service.impl;

import cn.itcast_04_springannotation.userdefinedannotation.annotation.RpcService;
import cn.itcast_04_springannotation.userdefinedannotation.service.HelloService;


@RpcService("HelloServicebb")
public class HelloServiceImpl implements HelloService {
    public String hello(String name) {
        return "Hello! " + name;
    }
    
    public void test(){
    	System.out.println("test");
    }
}
