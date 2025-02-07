package com.lin.apibackend.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;
// 请求参数定义

/**
 * 调用测试接口请求参数
 *
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {
    // 接口信息ID
    private Long id;

    //用户请求参数
    private String userRequestParams;

    public static final long serialVersionUID = 1L;
}