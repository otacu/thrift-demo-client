package com.example.demo.component;

import com.example.demo.service.HelloWorldService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.stereotype.Component;

@Component
public class ThriftClient {
    public static final int SERVER_PORT = 7099;
    public static final String SERVER_IP = "localhost";

    private HelloWorldService.Client helloWorldService;
    private TBinaryProtocol protocol;
    private TSocket transport;

    public ThriftClient() {
        transport = new TSocket(SERVER_IP, SERVER_PORT);
        protocol = new TBinaryProtocol(transport);
        helloWorldService = new HelloWorldService.Client(protocol);
    }

    public HelloWorldService.Client getHelloWorldService() {
        return helloWorldService;
    }

    public void open() throws TTransportException {
        transport.open();
    }

    public void close() {
        transport.close();
    }

}
