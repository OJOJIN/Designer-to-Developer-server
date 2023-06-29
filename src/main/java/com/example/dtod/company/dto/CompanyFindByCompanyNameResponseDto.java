package com.example.dtod.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompanyFindByCompanyNameResponseDto {
    private String companyName;

    private String mainProduct;

    //매출액
    private String sales;

    private Long employeeNum;

    //평판
    private String reputation;

    //자본
    private String capital;

    private String location;
}
