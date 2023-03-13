package com.kgromov.service;

import com.kgromov.grpc.demo.HelloWorldRequest;
import com.kgromov.grpc.demo.HelloWorldResponse;
import com.kgromov.grpc.demo.HelloWorldServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class HelloWorldService extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {
    @Override
    public void request(HelloWorldRequest request, StreamObserver<HelloWorldResponse> responseObserver) {
        HelloWorldResponse response = HelloWorldResponse.newBuilder()
                .setStatus(request.getMessage())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
//        responseObserver.onError(new RuntimeException("Unable to write response from request: " + request));
    }

    public static void main(String[] args) throws Exception{
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new HelloWorldService()).build();

        server.start();
        System.out.println("Server started...");
        server.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Server is shutdown");
    }
}
