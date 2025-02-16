package com.lin.apicommon.service;

import com.lin.apicommon.model.entity.InterfaceInfo;


/**
 * @author LIN
 * @description 针对表【interface_info(接口信息)】的数据库操作Service
 * @createDate 2025-01-16 18:33:14
 */
public interface InnerInterfaceInfoService {
    //    b. 从数据库中查询接口是否存在，以及请求方法是否匹配（请求方法、请求路径、请求参数，bool）；
    InterfaceInfo getInterfaceInfo(String path, String method);
}
