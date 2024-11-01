package org.example.app.dto.employee;

import org.example.app.entity.employee.Employee;
import org.springframework.http.HttpStatus;
public record EmployeeDtoCreateResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
       Employee employee) {

    public static final String SUCCESS_MESSAGE = "Employee has been created successfully.";
    public static final String FAILURE_MESSAGE = "Employee has not been created!";

    public static org.example.app.dto.employee.EmployeeDtoCreateResponse of(boolean isEmployeeCreated, Employee employee) {
        // ternary operator usage
        return (isEmployeeCreated) ?
                new org.example.app.dto.employee.EmployeeDtoCreateResponse(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        true, SUCCESS_MESSAGE, employee) :
                new org.example.app.dto.employee.EmployeeDtoCreateResponse(
                        HttpStatus.NO_CONTENT.value(),
                        HttpStatus.NO_CONTENT.getReasonPhrase(),
                        false, FAILURE_MESSAGE, null);
    }
}

