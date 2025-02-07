package com.lin.apibackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 发布下线接口-仅传递接口id
 *
 */
@Data
public class IdRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}