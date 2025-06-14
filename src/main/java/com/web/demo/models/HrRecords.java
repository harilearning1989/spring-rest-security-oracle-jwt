package com.web.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HR_RECORDS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HrRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "EMP_ID")
    private Long empId;

    @Column(name = "NAME_PREFIX", length = 5)
    private String namePrefix;

    @Column(name = "FIRST_NAME", length = 15)
    private String firstName;

    @Column(name = "MIDDLE_INITIAL", length = 1)
    private String middleInitial;

    @Column(name = "LAST_NAME", length = 15)
    private String lastName;

    @Column(name = "GENDER", length = 1)
    private String gender;

    @Column(name = "E_MAIL", length = 40)
    private String email;

    @Column(name = "FATHER_S_NAME", length = 25)
    private String fatherName;

    @Column(name = "MOTHER_S_NAME", length = 25)
    private String motherName;

    @Column(name = "MOTHER_S_MAIDEN_NAME", length = 13)
    private String motherMaidenName;

    @Column(name = "DATE_OF_BIRTH", length = 10)
    private String dateOfBirth;

    @Column(name = "TIME_OF_BIRTH", length = 11)
    private String timeOfBirth;

    @Column(name = "AGE_IN_YRS", length = 5)
    private String ageInYrs;

    @Column(name = "WEIGHT_IN_KGS", length = 5)
    private String weightInKgs;

    @Column(name = "DATE_OF_JOINING", length = 10)
    private String dateOfJoining;

    @Column(name = "QUARTER_OF_JOINING", length = 2)
    private String quarterOfJoining;

    @Column(name = "HALF_OF_JOINING", length = 3)
    private String halfOfJoining;

    @Column(name = "YEAR_OF_JOINING")
    private Integer yearOfJoining;

    @Column(name = "MONTH_OF_JOINING", length = 2)
    private String monthOfJoining;

    @Column(name = "MONTH_NAME_OF_JOINING", length = 9)
    private String monthNameOfJoining;

    @Column(name = "SHORT_MONTH", length = 3)
    private String shortMonth;

    @Column(name = "DAY_OF_JOINING", length = 2)
    private String dayOfJoining;

    @Column(name = "DOW_OF_JOINING", length = 9)
    private String dowOfJoining;

    @Column(name = "SHORT_DOW", length = 3)
    private String shortDow;

    @Column(name = "AGE_IN_COMPANY_YEARS", length = 5)
    private String ageInCompanyYears;

    @Column(name = "SALARY")
    private Long salary;

    @Column(name = "LAST_HIKE", length = 6)
    private String lastHike;

    @Column(name = "SSN", length = 11)
    private String ssn;

    @Column(name = "PHONE_NO", length = 14)
    private String phoneNo;

    @Column(name = "PLACE_NAME", length = 30)
    private String placeName;

    @Column(name = "COUNTY", length = 25)
    private String county;

    @Column(name = "CITY", length = 25)
    private String city;

    @Column(name = "STATE", length = 2)
    private String state;

    @Column(name = "ZIP", length = 5)
    private String zip;

    @Column(name = "REGION", length = 10)
    private String region;

    @Column(name = "USER_NAME", length = 25)
    private String userName;

    @Column(name = "PASSWORD", length = 20)
    private String password;

}

