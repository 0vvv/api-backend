package com.lin.apibackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.apibackend.model.entity.UserInterfaceInfo;

/**
* @author LIN
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2025-02-07 15:55:10
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    // 统计接口调用次数
    boolean invokeCount(long interfaceInfoId, long userId);
}
