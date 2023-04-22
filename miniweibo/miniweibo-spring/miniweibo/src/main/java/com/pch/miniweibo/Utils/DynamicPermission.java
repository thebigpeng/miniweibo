package com.pch.miniweibo.Utils;

import com.pch.miniweibo.service.ApiManngerService;
import com.pch.miniweibo.Enums.MyaccessDeniedException;
import com.pch.miniweibo.VO.BackendApiVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @className: DynamicPermission
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/18
 */
@Component
public class DynamicPermission {

    @Autowired
    private ApiManngerService apiManngerService;

    /**
     * 判断有访问API的权限
     * @param request
     * @param authentication
     * @return
     * @throws MyaccessDeniedException
     */
    public boolean checkPermisstion(HttpServletRequest request,
                                    Authentication authentication) throws MyaccessDeniedException {
        Object principal = authentication.getPrincipal();
        System.out.printf("DynamicPermission principal"+principal);

        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();
            //Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
            //通过账号获取资源鉴权
            List<BackendApiVO> backendApiVOS = apiManngerService.getApiUrlByUserName(username);

            AntPathMatcher antPathMatcher = new AntPathMatcher();
            //获取当前请求的URI
            String curURI = request.getRequestURI();
            String reqMethod = request.getMethod();
        }else {

        }
        return false;
    }
}
