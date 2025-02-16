package com.lin.apicommon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.apicommon.model.entity.UserInterfaceInfo;

public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    //    c. 调用接口成功后，接口调用次数+1（accessKey、secretKey、接口路径）
    boolean invokeCount(long interfaceInfoId, long userId);
}
