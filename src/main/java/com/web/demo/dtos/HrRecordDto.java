package com.web.demo.dtos;

import java.io.Serializable;

public record HrRecordDto(
        Long id,
        Long empId,
        String namePrefix,
        String firstName,
        String middleInitial,
        String lastName,
        String gender,
        String email,
        String fatherName,
        String motherName,
        String motherMaidenName,
        String dateOfBirth,
        String timeOfBirth,
        String ageInYrs,
        String weightInKgs,
        String dateOfJoining,
        String quarterOfJoining,
        String halfOfJoining,
        Integer yearOfJoining,
        String monthOfJoining,
        String monthNameOfJoining,
        String shortMonth,
        String dayOfJoining,
        String dowOfJoining,
        String shortDow,
        String ageInCompanyYears,
        Long salary,
        String lastHike,
        String ssn,
        String phoneNo,
        String placeName,
        String county,
        String city,
        String state,
        String zip,
        String region,
        String userName,
        String password
) implements Serializable {
}

