package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @ClassName SysUser
 * @Author lz
 * @Description 系统用户表
 * @Date 2018/11/16 16:36
 * @Version V1.0
 **/
@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends SuperEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 名称
     */
    private String name;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 登录名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机
     */
    private String phone;
    /**
     * 状态 0 可用 1 不可用
     */
    private Integer status;

}
