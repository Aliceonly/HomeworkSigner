package com.example.myspring;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.myspring.CheckPermission;
import com.example.myspring.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
public class CheckPermissionInterceptor implements HandlerInterceptor {

    static List<String> userPermissionList = new ArrayList<>();

    public static void addPermisstion(String permission){
        userPermissionList.add(permission);
    }

    public static void delPermisstion(String permission){
        userPermissionList.remove(permission);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        CheckPermission methodAnnotation = method.getAnnotation(CheckPermission.class);
        if (methodAnnotation != null) {
            String per = methodAnnotation.per();
            if(StringUtils.isNotBlank(per)){
                if(!userPermissionList.contains(per)){
                    throw new MyException("您暂无权限进行此操作");
                }
            }
        }
        return true;
    }
}