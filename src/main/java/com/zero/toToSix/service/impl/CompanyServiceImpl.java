package com.zero.toToSix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zero.toToSix.mapper.CompanyMapper;
import com.zero.toToSix.model.Company;
import com.zero.toToSix.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> testCompanySql(Integer id) {
        return companyMapper.testCompanySql(id);
    }

    @Override
    public Company getById(Integer id) {
        return companyMapper.getById(id);
    }
}
