package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value="通讯录对象模型")
public class ContactsEntity implements Serializable {
    @ApiModelProperty(value="id" )
    private int id;
    @ApiModelProperty(value="姓名")
    private String name;
    @ApiModelProperty(value="号码" )
    private String number;
    @ApiModelProperty(value="备注")
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
