package com.lin.apicommon.service;

import com.lin.apicommon.model.entity.User;

/**
 * @author LIN
 * @description 针对表【user(用户)】的数据库操作Service
 * @createDate 2025-01-16 18:53:44
 */
public interface InnerUserService {
    //    a. 从数据库中查询接口是否已分配给用户（accessKey、secretKey，bool）；
    User getInvokeUser(String accessKey, String secretKey);
}
