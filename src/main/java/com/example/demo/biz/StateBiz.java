package com.example.demo.biz;

import com.example.demo.bo.State;
import com.example.demo.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:27
 */
@Component
public class StateBiz {

    @Autowired
    private StateService stateService;

    public void saveState(State state) {
        stateService.insertState(state);
    }

    public List<State> selectByCondition(String phone) {
        List<State> states = stateService.selectById(phone);
        return states;
    }
}
