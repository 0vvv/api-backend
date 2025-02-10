package com.lin.apibackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.apibackend.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.lin.apibackend.model.entity.InterfaceInfo;

/**
* @author LIN
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2025-01-16 18:33:14
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);
}
