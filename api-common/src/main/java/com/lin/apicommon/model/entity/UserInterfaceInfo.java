package com.lin.apicommon.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 用户调用接口关系
 * @TableName user_interface_info
 */
@TableName(value ="user_interface_info")
@Data
public class UserInterfaceInfo {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

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

    /**
     * 0-正常，1-禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 是否删除(0-未删, 1-已删)
     */
    @TableLogic
    private Integer isdelete;

    @TableField
    private static final long serialVersionUID = 1L;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}