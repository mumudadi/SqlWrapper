package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @ClassName SysRole
 * @Author lz
 * @Description 角色表
 * @Date 2018/9/30 9:00
 * @Version V1.0
 **/
@Data
@TableName("sys_role")
@EqualsAndHashCode(callSuper = true)
public class SysRole extends SuperEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 角色名
     */
    private String name;

    /**
     * 角色标识
     */
    private String role;

}
