package com.atguigu.service;

import java.util.List;


import com.atguigu.bean.Cellphone;


public interface CellPhoneService {
    
    public List<Cellphone> getAll() ;

    public void delete(Integer id) ;

    public Cellphone get(Integer id);

    public void save(Cellphone phone) ;


    

   
    
    
    
}
