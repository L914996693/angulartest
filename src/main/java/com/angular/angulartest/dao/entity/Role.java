package com.angular.angulartest.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * angualr角色表
 * </p>
 *
 * @author liuwei
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("AN_ROLE")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色表表内ID
     */
    @TableId("ROLE_ID")
    private String roleId;

    /**
     * 父级角色ID
     */
    @TableField("PARENT_ROLE_ID")
    private String parentRoleId;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private String createTime;

    /**
     * 角色描述
     */
    @TableField("ROLE_DESCRIPTION")
    private String roleDescription;


    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}
