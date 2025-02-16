package com.lin.apibackend.service.impl;

import com.lin.apibackend.mapper.UserMapper;
import com.lin.apicommon.model.entity.User;
import com.lin.apicommon.service.InnerUserService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {
//    @Resource
//    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey, String secretKey) {
//        if (StringUtils.isAnyBlank(accessKey, secretKey)) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("accessKey", accessKey);
//        queryWrapper.eq("secretKey", secretKey);
//        User user = userMapper.selectOne(queryWrapper);
//        return user;
        return null;
    }
}
