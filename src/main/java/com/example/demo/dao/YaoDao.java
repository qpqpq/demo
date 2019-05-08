package com.example.demo.dao;

import com.example.demo.bo.Yao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午10:29
 */
@Mapper
@Repository("yaoDao")
public interface YaoDao {

    int insertYao(Yao yao);

    List<Yao> selectById(String phone);

}
