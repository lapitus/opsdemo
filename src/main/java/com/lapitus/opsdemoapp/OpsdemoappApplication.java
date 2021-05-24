package com.lapitus.opsdemoapp;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class OpsdemoappApplication {

	public static void main(String[] args) throws IOException, InterruptedException {

		Server server = ServerBuilder.forPort(8081).addService(new EmployeeServiceImpl()).build();
		server.start();
		System.out.println("Grpc server started!");
		SpringApplication.run(OpsdemoappApplication.class, args);
		server.awaitTermination();

	}

}
