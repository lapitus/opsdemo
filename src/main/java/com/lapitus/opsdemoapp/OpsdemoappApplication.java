package com.lapitus.opsdemoapp;

import com.lapitus.opsdemoapp.services.EmployeeServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class OpsdemoappApplication {


	private static EmployeeServiceImpl employeeService;

	@Autowired
	public OpsdemoappApplication(EmployeeServiceImpl employeeService) {
		this.employeeService = employeeService;
	}


	public static void main(String[] args) throws IOException, InterruptedException {



		SpringApplication.run(OpsdemoappApplication.class, args);

		Server server = ServerBuilder.forPort(8081).addService(employeeService).build();
		server.start();
		System.out.println("Grpc server started!");
		server.awaitTermination();

	}

}
