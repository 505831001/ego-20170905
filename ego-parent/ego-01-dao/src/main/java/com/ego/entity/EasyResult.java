package com.ego.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author liuweiwei
 * @since 2020-09-06
 */
@Data
@ToString
public class EasyResult implements Serializable {
    private int status;
    private Object data;
}
