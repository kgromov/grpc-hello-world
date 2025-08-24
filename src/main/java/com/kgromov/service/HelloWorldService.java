package com.kgromov.service;

import com.kgromov.grpc.demo.HelloWorldRequest;
import com.kgromov.grpc.demo.HelloWorldResponse;
import com.kgromov.grpc.demo.HelloWorldServiceGrpc;
import io.grpc.stub.StreamObserver;

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

}
