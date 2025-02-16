package com.lin.apibackend.service.impl;

import com.lin.apicommon.model.entity.InterfaceInfo;
import com.lin.apicommon.service.InnerInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {
//    @Resource
//    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String path, String method) {
//        if (StringUtils.isAnyBlank(path, method)) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("url", path);
//        queryWrapper.eq("method", method);
//        InterfaceInfo interfaceInfo = interfaceInfoMapper.selectOne(queryWrapper);
//        return interfaceInfo;
        return null;
    }
}
