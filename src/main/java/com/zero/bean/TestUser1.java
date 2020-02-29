package com.zero.bean;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestUser1 implements BeanNameAware {

    private String userName;

    @Override
    public void setBeanName(String name) {
        userName = name;
    }

}
