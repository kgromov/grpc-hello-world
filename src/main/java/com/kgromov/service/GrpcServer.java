package com.kgromov.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.util.concurrent.TimeUnit;

public class GrpcServer {
    public static void main(String[] args) throws Exception{
        Server server = ServerBuilder
                .forPort(9090)
                .addService(new HelloWorldService())
                .addService(ProtoReflectionService.newInstance())
                .build();

        server.start();
        System.out.println("Server started...");
        server.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Server is shutdown");
    }
}
