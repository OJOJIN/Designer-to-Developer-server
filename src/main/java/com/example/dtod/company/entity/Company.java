package com.example.dtod.company.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String mainProduct;

    @Column(nullable = false)
    //매출액
    private String sales;

    @Column(nullable = false)
    private Long employeeNum;

    @Column(nullable = false)
    //평판
    private String reputation;

    @Column(nullable = false)
    //자본
    private String capital;

    @Column(nullable = false)
    private String location;

    @Builder
    public Company(String companyName, String mainProduct, String sales, Long employeeNum,
                String reputation,String capital, String location){
        this.companyName = companyName;
        this.mainProduct = mainProduct;
        this.sales = sales;
        this.employeeNum = employeeNum;
        this.reputation = reputation;
        this.capital = capital;
        this.location = location;
    }

}
