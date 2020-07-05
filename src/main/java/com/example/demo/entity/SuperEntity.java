package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class SuperEntity implements Serializable {

    private static final long serialVersionUID = 8728799151227728315L;
    /**
     * 主键ID
     */
    @TableId
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 修改时间
     */
    @TableField(value = "modify_date", fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;

}
