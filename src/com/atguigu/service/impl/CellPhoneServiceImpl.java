package com.atguigu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Cellphone;
import com.atguigu.dao.CellphoneMapper;
import com.atguigu.service.CellPhoneService;

@Service
public class CellPhoneServiceImpl implements CellPhoneService{
    @Autowired
    CellphoneMapper cellphoneMapper;

    public List<Cellphone> getAll() {
        return cellphoneMapper.selectByExample(null);
    }


    public void delete(Integer id) {
        cellphoneMapper.delete(id);
    }


    public Cellphone get(Integer id) {
        Cellphone cellphone = cellphoneMapper.selectByPrimaryKey(id);
        return cellphone;
    }


    public void save(Cellphone phone) {
        cellphoneMapper.insert(phone);
    }

}
