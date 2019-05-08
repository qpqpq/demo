package com.example.demo.service;

import com.example.demo.bo.Exercise;
import com.example.demo.bo.Yao;
import com.example.demo.dao.ExerciseDao;
import com.example.demo.dao.YaoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:25
 */
@Service
public class YaoService {

    @Autowired
    private YaoDao yaoDao;

    public void insertYao(Yao yao) {
        yaoDao.insertYao(yao);
    }

    public List<Yao> selectById(String phone) {
        return yaoDao.selectById(phone);
    }


}
