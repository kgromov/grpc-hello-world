package com.kgromov.client;

import com.kgromov.grpc.demo.HelloWorldRequest;
import com.kgromov.grpc.demo.HelloWorldResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.UUID;

public class GrpcClient {
    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloWorldBlockingClient client = new HelloWorldBlockingClient(channel);
        try {
            HelloWorldRequest request1 = HelloWorldRequest.newBuilder()
                    .setRequestId(UUID.randomUUID().toString())
                    .setMessage("Hello World")
                    .build();
            HelloWorldRequest request2 = HelloWorldRequest.newBuilder()
                    .setRequestId(UUID.randomUUID().toString())
                    .setMessage("Hello from hell!!!")
                    .build();
            HelloWorldResponse response1 = client.request(request1);
            System.out.println("Response for 1st request = " + response1);
            HelloWorldResponse response2 = client.request(request2);
            System.out.println("Response for 2nd request = " + response2);
        } finally {
            client.shutdown();
        }
    }
}
