package com.example.demo.aop;

import com.example.demo.bo.User;
import com.example.demo.dao.UserDao;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author pangkun
 * @date 2019/5/7 上午7:33
 */
@Aspect
@Component
public class ValidateAspect {
    @Autowired
    private UserDao userDao;

    @Pointcut("@annotation(com.example.demo.annotation.Validator)")
    public void validatePointCut() {
    }

    @Around("validatePointCut()")
    public Object arround(ProceedingJoinPoint point) throws Throwable {
        Map<String, String> header = (Map<String, String>) point.getArgs()[0];
        String token = header.get("token");
        try {
            String phone = token.substring(0, 11);
            String sha = token.substring(11);
            User user = userDao.selectById(phone);
            if (user != null && user.getPassword().equals(sha)) {
                Object result = point.proceed();
                return result;
            } else {
                return "{\"msg\":\"token错误\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
