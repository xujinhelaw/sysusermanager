package com.unity.authentication.manager.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by xuhelaw on 2020/10/18.
 */
@Data
public class WebInfo implements Serializable {
    //@JSONField(name = "site")
    private String site;
}
