package com.example.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

/**
 * @author pangkun
 * @date 2019/5/5 下午2:17
 */
@RestController
@RequestMapping("/pressure")
public class Pressure {

    @GetMapping("/{id}")
    public String f(@PathVariable("id")String id, @RequestParam("start")String start,@RequestParam("end")String end){
        System.out.println(id+" "+start+" "+end);
        return id+" "+start+" "+end;
    }
}
