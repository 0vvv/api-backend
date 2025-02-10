package com.lin.apibackend.model.dto.userinterfaceinfo;

import lombok.Data;

import java.io.Serializable;
// 请求参数定义
/**
 * 创建请求
 *
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {
    /**
     * 调用用户 id
     */
    private Long userid;

    /**
     * 接口 id
     */
    private Long interfaceinfoid;

    /**
     * 总调用次数
     */
    private Integer totalnum;

    /**
     * 剩余调用次数
     */
    private Integer leftnum;
}