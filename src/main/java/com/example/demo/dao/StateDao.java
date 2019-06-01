package com.example.demo.dao;

import com.example.demo.bo.State;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:17
 */
@Mapper
@Repository("stateDao")
public interface StateDao {

    int insertState(State state);

    List<State> selectById(String phone);

    void updateState(State state);
}
