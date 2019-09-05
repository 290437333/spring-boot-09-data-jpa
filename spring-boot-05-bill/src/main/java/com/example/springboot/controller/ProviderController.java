package com.example.springboot.controller;

import com.example.springboot.dao.ProviderDao;
import com.example.springboot.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * 供应商的控制层
 */
@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProviderDao providerDao;

    @GetMapping("/providers")
    public String list(Map<String,Object> map , @RequestParam(value = "providerName", required = false) String providerName){
        logger.info("供应商列表查询。。。" + providerName);
        Collection<Provider> providers = providerDao.getAll(providerName);
        map.put("providerName",providerName);
        map.put("providers",providers);
        return "provider/list";
    }

    /**
     * 查看详情页面
     * @param pid 供应商id
     * @param type
     * @param map
     * @return
     */
    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid,
                       @RequestParam(value = "type",defaultValue = "view") String type,
                       Map<String,Object> map){
        logger.info("查询"+ pid + "供应商的信息" );
        Provider provider = providerDao.getProvider(pid);
        map.put("provider",provider);
//        return "provider/view";
        //若type为空，则进入view.html，若为update,则进入update.html
        return "provider/"+type;
    }

    //修改供应商信息
    @PutMapping("/provider")
    public String update(Provider provider){
        logger.info("更新供应商。。。");
        //更新操作
        providerDao.save(provider);
        return "redirect:/providers";
    }

    //前往添加页面
    @GetMapping("/provider")
    public String toAddpage(){
        return "provider/add";
    }

    //添加数据
    @PostMapping("/provider")
    public String add(Provider provider){
        logger.info("添加数据："+provider);
        providerDao.save(provider);
        return "redirect:/providers";
    }

    //删除数据
    @DeleteMapping("/provider/{pid}")
    public String del(@PathVariable("pid") Integer pid){
        logger.info("删除供应商"+pid);
        providerDao.delete(pid);
        return "redirect:/providers";
    }
}
