package com.atguigu.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.bean.Cellphone;
import com.atguigu.service.CellPhoneService;
import com.github.pagehelper.PageInfo;



@Controller
public class CellPhoneController {

    @Autowired
    CellPhoneService cellPhoneService;

    /**
     * 查询所有手机
     * 
     * @return
     */
    @RequestMapping("/phones")
    public String getphones(Model model) {
        List<Cellphone> all = cellPhoneService.getAll();
        PageInfo<Cellphone> info = new PageInfo<>(all, 5);
        model.addAttribute("phones", info);
        return "list";
    }
    
    /**
     * 删除
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param id
     * @return
     */
    @RequestMapping(value="/phone/{id}",method=RequestMethod.DELETE)
    public String deletephone(@PathVariable("id")Integer id){
        cellPhoneService.delete(id);
        return "redirect:/phones";
    }

    /**
     * 查询手机，来到修改页面回显
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/phone/{id}", method = RequestMethod.GET)
    public String getPhone(@PathVariable("id") Integer id, Model model) {
        // 1、查出手机信息
        Cellphone phone = cellPhoneService.get(id);
        // 2、放在请求域中
        model.addAttribute("phone", phone);
        return "edit";
    }

  

    @RequestMapping(value = "/phone/{id}", method = RequestMethod.PUT)
    public String updatephone(@ModelAttribute("phone")Cellphone phone) {
        System.out.println("要修改的手机：" + phone);
        // xxxx 更新保存二合一；
        cellPhoneService.save(phone);
        return "redirect:/phones";
    }

    @ModelAttribute
    public void myModelAttribute(
            @RequestParam(value = "id", required = false) Integer id,Model model) {
        if (id != null) {
            Cellphone phone = cellPhoneService.get(id);
            model.addAttribute("phone", phone);
        }
        System.out.println("hahha ");
    }

    /**
     * 添加手机
     * 
     * @param phoneloyee
     * @return
     */
    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    public String addPhone(Cellphone phone) {
        System.out.println("要添加的手机：" + phone);
        cellPhoneService.save(phone);
        // 返回列表页面；重定向到查询所有手机的请求
        return "redirect:/phones";
    }
    

   

}
