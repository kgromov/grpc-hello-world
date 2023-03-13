package com.kgromov.client;

import com.kgromov.grpc.demo.HelloWorldRequest;
import com.kgromov.grpc.demo.HelloWorldResponse;
import com.kgromov.grpc.demo.HelloWorldServiceGrpc;
import io.grpc.ManagedChannel;

public class HelloWorldBlockingClient {
    private final ManagedChannel channel;
    private final HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub;

    public HelloWorldBlockingClient(ManagedChannel channel) {
        this.channel = channel;
        this.stub = HelloWorldServiceGrpc.newBlockingStub(channel);
    }

    public HelloWorldResponse request(HelloWorldRequest request) {
        System.out.println("Requesting " + request);
        return stub.request(request);
    }

    public void shutdown() {
        this.channel.shutdown();
        System.out.println("Client is shutdown");
    }
}
