package com.ego.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author liuweiwei
 * @since 2020-09-06
 */
@Data
@ToString
public class TbContentCategory {
    private Long id;

    private Long parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Boolean isParent;

    private Date created;

    private Date updated;
}