package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName SysUserRole
 * @Author lz
 * @Description 用户与角色关联表
 * @Date 2018/10/9 11:40
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user_role")
@EqualsAndHashCode(callSuper = true)
public class SysUserRole extends SuperEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

}
