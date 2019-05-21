package com.example.demo.biz;

import com.example.demo.bo.Yao;
import com.example.demo.service.YaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:27
 */
@Component
public class YaoBiz {

    @Autowired
    private YaoService yaoService;

    public void saveYao(Yao yao) {
        yaoService.insertYao(yao);
    }

    public List<Yao> selectByCondition(String phone) {
        List<Yao> yaos = yaoService.selectById(phone);
        return yaos;
    }

    public void delete(String name){
        yaoService.delete(name);
    }

}