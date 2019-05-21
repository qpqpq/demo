package com.example.demo.service;

import com.example.demo.bo.State;
import com.example.demo.dao.StateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:25
 */
@Service
public class StateService {

    @Autowired
    private StateDao stateDao;

    public void insertState(State state){
        stateDao.insertState(state);
    }

    public List<State>selectById(String phone){
        return stateDao.selectById(phone);
    }


}
