package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName SysRoleResource
 * @Author lz
 * @Description 角色和资源关联表
 * @Date 2018/10/9 11:47
 * @Version V1.0
 **/
@Data
@TableName("sys_role_resource")
@EqualsAndHashCode(callSuper = true)
public class SysRoleResource extends SuperEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 资源ID
     */
    private Long resourceId;

}
