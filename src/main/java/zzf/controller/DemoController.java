package zzf.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zzf.mapper.UserInfoMapper;

import javax.annotation.Resource;

/**
 * Created by zhangxinwei on 03/11/2018.
 */
@Controller
public class DemoController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    @ResponseBody
    public String demo1() {
        return "demo";
    }

    @RequestMapping(value = "/demopage", method = RequestMethod.GET)
    public ModelAndView demoPage() {
        System.out.println(userInfoMapper.selectUserByID(1).getUserName());
        return new ModelAndView("demopage");
    }
    
}
