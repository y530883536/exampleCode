package com.zero.toToSix.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zero.toToSix.model.Company;

import java.util.List;

public interface ICompanyService extends IService<Company> {
    List<Company> testCompanySql(Integer id);
    Company getById(Integer id);
}
