package com.lapitus.opsdemoapp;

import com.lapitus.grpc.EmployeeServiceGrpc;
import com.lapitus.grpc.EmployeeServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class EmployeeServiceImpl extends EmployeeServiceGrpc.EmployeeServiceImplBase {
    @Override
    public void getEmployee(EmployeeServiceOuterClass.EmployeeRequest request,
                            StreamObserver<EmployeeServiceOuterClass.EmployeeResponse> responseObserver) {

        System.out.println("Thats request:" + request);

        EmployeeServiceOuterClass.EmployeeResponse response = EmployeeServiceOuterClass.EmployeeResponse.
                newBuilder().setEmployeeName("Alex-" + request.getEmployeeId()).
                setEmployeeRole("Vaskov")
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
