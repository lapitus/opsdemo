package com.lapitus.opsdemoapp.services;

import com.lapitus.grpc.EmployeeServiceGrpc;
import com.lapitus.grpc.EmployeeServiceOuterClass;
import com.lapitus.opsdemoapp.entity.Employee;
import com.lapitus.opsdemoapp.exceptions.EmployeeNotFoundException;
import com.lapitus.opsdemoapp.repositories.EmployeeRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    private final EmployeeRepository repository;

    @Autowired
    EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository=repository;
    }


    @Override
    public void getEmployee(EmployeeServiceOuterClass.EmployeeRequest request,
                            StreamObserver<EmployeeServiceOuterClass.EmployeeResponse> responseObserver) {

        Employee employee;

        employee = repository.findById(request.getEmployeeId())
                .orElseThrow(() -> new EmployeeNotFoundException(request.getEmployeeId()));

        System.out.println(employee);


        EmployeeServiceOuterClass.EmployeeResponse response = EmployeeServiceOuterClass.EmployeeResponse.
                newBuilder().setEmployeeName(employee.getName()).
                setEmployeeRole(employee.getRole())
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
