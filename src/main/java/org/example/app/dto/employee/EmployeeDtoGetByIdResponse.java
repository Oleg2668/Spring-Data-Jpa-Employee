package org.example.app.dto.employee;

import org.example.app.entity.employee.Employee;
import org.springframework.http.HttpStatus;

public record EmployeeDtoGetByIdResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Employee employee) {

    public static final String SUCCESS_MESSAGE = "Employee with id %s has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "Employee with id %s has not been found!";

    public static org.example.app.dto.employee.EmployeeDtoGetByIdResponse of(Long id, boolean isEmployeeFound, Employee employee) {
        return isEmployeeFound ?
                new org.example.app.dto.employee.EmployeeDtoGetByIdResponse(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        true, SUCCESS_MESSAGE.formatted(id), employee) :
                new org.example.app.dto.employee.EmployeeDtoGetByIdResponse(
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        false, FAILURE_MESSAGE.formatted(id), null);
    }
}
