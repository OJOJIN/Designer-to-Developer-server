package com.example.dtod.company.controller;

import com.example.dtod.company.dto.CompanyFindByCompanyNameResponseDto;
import com.example.dtod.company.dto.CompanyRequestDto;
import com.example.dtod.company.dto.CompanyResponseDto;
import com.example.dtod.company.entity.Company;
import com.example.dtod.company.repository.CompanyRepository;
import com.example.dtod.exception.BusinessException;
import com.example.dtod.response.BaseResponseDto;
import com.example.dtod.response.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.dtod.response.ErrorMessage.ALREADY_EXISTED_COMPANY;


@RequiredArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyRepository companyRepository;

    @PostMapping("")
    public BaseResponseDto<CompanyResponseDto> create(@RequestBody CompanyRequestDto companyRequestDto){
        Company companyInfo = Company.builder()
                .companyName(companyRequestDto.getCompanyName())
                .mainProduct(companyRequestDto.getMainProduct())
                .sales(companyRequestDto.getSales())
                .employeeNum(companyRequestDto.getEmployeeNum())
                .reputation(companyRequestDto.getReputation())
                .capital(companyRequestDto.getCapital())
                .location(companyRequestDto.getLocation())
                .build();

        companyRepository.save(companyInfo);
        if(companyInfo.getId() == -1) return new BaseResponseDto(ALREADY_EXISTED_COMPANY);
        else return new BaseResponseDto(new CompanyResponseDto(companyInfo.getId()));
    }

    @GetMapping("/{companyName}")
    public BaseResponseDto<CompanyFindByCompanyNameResponseDto> findByCompanyName(@PathVariable String companyName){
        if(!companyRepository.existsCompanyByCompanyName(companyName))
            throw new BusinessException(ErrorMessage.COMPANY_NOT_FOUND);
        Company company = companyRepository.findAllByCompanyName(companyName);

        return new BaseResponseDto<>(new CompanyFindByCompanyNameResponseDto(
                company.getCompanyName(),
                company.getMainProduct(),
                company.getSales(),
                company.getEmployeeNum(),
                company.getReputation(),
                company.getCapital(),
                company.getLocation())
        );
    }

}
