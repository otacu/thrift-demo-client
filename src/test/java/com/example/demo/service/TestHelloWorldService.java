package com.example.demo.service;

import com.example.demo.component.ThriftClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHelloWorldService {

    @Autowired
    private ThriftClient thriftClient;

    @Test
    public void testSayHello() throws Exception {
        thriftClient.open();
        String result = thriftClient.getHelloWorldService().sayHello("Geralt");
        thriftClient.close();
        System.out.println("#######################################################");
        System.out.println(result);
    }
}
