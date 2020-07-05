package com.example.demo.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.demo.entity.SysUser;
import com.example.demo.support.Conditions;
import com.example.demo.support.SqlKeywords;

public class SysUserVO extends SysUser {
    @TableField("r.name")
    private String roleName;
    @TableField("u.id")
    private String id;
    @TableField("u.create_date")
    private String createDate;
    @TableField("u.modify_date")
    private String modifyDate;
    @Conditions(SqlKeywords.IGNORE)
    private String name;
}
