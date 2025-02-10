package com.lin.apibackend.controller;

import com.lin.apibackend.annotation.AuthCheck;
import com.lin.apibackend.common.*;
import com.lin.apibackend.constant.UserConstant;
import com.lin.apibackend.exception.BusinessException;
import com.lin.apibackend.exception.ThrowUtils;
import com.lin.apibackend.model.dto.userinterfaceinfo.UserInterfaceInfoAddRequest;
import com.lin.apibackend.model.dto.userinterfaceinfo.UserInterfaceInfoUpdateRequest;
import com.lin.apibackend.model.entity.UserInterfaceInfo;
import com.lin.apibackend.model.entity.User;
import com.lin.apibackend.service.UserInterfaceInfoService;
import com.lin.apibackend.service.UserService;
import com.lin.apiclientsdk.client.ApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户调用接口
 *
 */
@RestController
@RequestMapping("/userInterfaceInfo")
@Slf4j
public class UserInterfaceInfoController {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Resource
    private UserService userService;

    @Resource
    private ApiClient apiClient;
    // region 增删改查

    /**
     * 增加
     */
    @PostMapping("/add")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Long> addInterfaceInfo(@RequestBody UserInterfaceInfoAddRequest userInterfaceInfoAddRequest, HttpServletRequest request) {
        if (userInterfaceInfoAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo userInterfaceInfo = new UserInterfaceInfo();
        BeanUtils.copyProperties(userInterfaceInfoAddRequest, userInterfaceInfo);
        userInterfaceInfoService.validUserInterfaceInfo(userInterfaceInfo, true);
        User loginUser = userService.getLoginUser(request);
        userInterfaceInfo.setId(loginUser.getId());
        boolean result = userInterfaceInfoService.save(userInterfaceInfo);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newInterfaceInfoId = userInterfaceInfo.getId();
        return ResultUtils.success(newInterfaceInfoId);
    }

    /**
     * 删除
     *
     */
    @PostMapping("/delete")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> deleteInterfaceInfo(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.getLoginUser(request);
        long id = deleteRequest.getId();
        // 判断是否存在
        UserInterfaceInfo oldInterfaceInfo = userInterfaceInfoService.getById(id);
        ThrowUtils.throwIf(oldInterfaceInfo == null, ErrorCode.NOT_FOUND_ERROR);
        // 仅本人或管理员可删除
        if (!oldInterfaceInfo.getId().equals(user.getId()) && !userService.isAdmin(request)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        boolean b = userInterfaceInfoService.removeById(id);
        return ResultUtils.success(b);
    }

    /**
     * 更新
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateInterfaceInfo(@RequestBody UserInterfaceInfoUpdateRequest userInterfaceInfoUpdateRequest) {
        if (userInterfaceInfoUpdateRequest == null || userInterfaceInfoUpdateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo userInterfaceInfo = new UserInterfaceInfo();
        BeanUtils.copyProperties(userInterfaceInfoUpdateRequest, userInterfaceInfo);
        // 参数校验
        userInterfaceInfoService.validUserInterfaceInfo(userInterfaceInfo, false);
        long id = userInterfaceInfoUpdateRequest.getId();
        // 判断是否存在
        UserInterfaceInfo oldInterfaceInfo = userInterfaceInfoService.getById(id);
        ThrowUtils.throwIf(oldInterfaceInfo == null, ErrorCode.NOT_FOUND_ERROR);
        boolean result = userInterfaceInfoService.updateById(userInterfaceInfo);
        return ResultUtils.success(result);
    }

    /**
     * 根据 id 获取
     *
     * @param id
     * @return
     */
//    @GetMapping("/get/vo")
//    public BaseResponse<InterfaceInfoVO> getInterfaceInfoVOById(long id, HttpServletRequest request) {
//        if (id <= 0) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoService.getById(id);
//        if (userInterfaceInfo == null) {
//            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
//        }
//        return ResultUtils.success(userInterfaceInfoService.getInterfaceInfoVO(userInterfaceInfo, request));
//    }

    /**
     * 分页获取列表（仅管理员）
     *
     * @param interfaceInfoQueryRequest
     * @return
     */
//    @PostMapping("/list/page")
////    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
//    public BaseResponse<Page<UserInterfaceInfo>> listInterfaceInfoByPage(@RequestBody InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
//        long current = interfaceInfoQueryRequest.getCurrent();
//        long size = interfaceInfoQueryRequest.getPageSize();
//        Page<UserInterfaceInfo> interfaceInfoPage = userInterfaceInfoService.page(new Page<>(current, size),
//                userInterfaceInfoService.getQueryWrapper(interfaceInfoQueryRequest));
//        return ResultUtils.success(interfaceInfoPage);
//    }

    /**
     * 分页获取列表（封装类）
     *
     * @return
     */
//    @PostMapping("/list/page/vo")
//    public BaseResponse<Page<InterfaceInfoVO>> listInterfaceInfoVOByPage(@RequestBody InterfaceInfoQueryRequest interfaceInfoQueryRequest,
//            HttpServletRequest request) {
//        long current = interfaceInfoQueryRequest.getCurrent();
//        long size = interfaceInfoQueryRequest.getPageSize();
//        // 限制爬虫
//        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
//        Page<UserInterfaceInfo> interfaceInfoPage = userInterfaceInfoService.page(new Page<>(current, size),
//                userInterfaceInfoService.getQueryWrapper(interfaceInfoQueryRequest));
//        return ResultUtils.success(userInterfaceInfoService.getInterfaceInfoVOPage(interfaceInfoPage, request));
//    }

    /**
     * 分页获取当前用户创建的资源列表
     *
     * @return
     */
//    @PostMapping("/my/list/page/vo")
//    public BaseResponse<Page<InterfaceInfoVO>> listMyInterfaceInfoVOByPage(@RequestBody InterfaceInfoQueryRequest interfaceInfoQueryRequest,
//            HttpServletRequest request) {
//        if (interfaceInfoQueryRequest == null) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        User loginUser = userService.getLoginUser(request);
//        interfaceInfoQueryRequest.setUserId(loginUser.getId());
//        long current = interfaceInfoQueryRequest.getCurrent();
//        long size = interfaceInfoQueryRequest.getPageSize();
//        // 限制爬虫
//        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
//        Page<UserInterfaceInfo> interfaceInfoPage = userInterfaceInfoService.page(new Page<>(current, size),
//                userInterfaceInfoService.getQueryWrapper(interfaceInfoQueryRequest));
//        return ResultUtils.success(userInterfaceInfoService.getInterfaceInfoVOPage(interfaceInfoPage, request));
//    }

    // endregion

    /**
     * 分页搜索（从 ES 查询，封装类）
     */
//    @PostMapping("/search/page/vo")
//    public BaseResponse<Page<InterfaceInfoVO>> searchInterfaceInfoVOByPage(@RequestBody InterfaceInfoQueryRequest interfaceInfoQueryRequest,
//            HttpServletRequest request) {
//        long size = interfaceInfoQueryRequest.getPageSize();
//        // 限制爬虫
//        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
//        Page<UserInterfaceInfo> interfaceInfoPage = userInterfaceInfoService.searchFromEs(interfaceInfoQueryRequest);
//        return ResultUtils.success(userInterfaceInfoService.getInterfaceInfoVOPage(interfaceInfoPage, request));
//    }
}
