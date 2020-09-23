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
 * angular用户表
 * </p>
 *
 * @author liuwei
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("AN_USER")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户表表内ID
     */
    @TableId("USER_ID")
    private String userId;

    /**
     * 用户名称
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 用户密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    private String roleId;

    /**
     * 用户启用状态 0-未启用,1-启用
     */
    @TableField("ENABLE_STATUS")
    private String enableStatus;

    /**
     * 所属机构
     */
    @TableField("AFFILIATED_INSTITUTIONS")
    private String affiliatedInstitutions;

    /**
     * 手机号
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 电子邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private String createTime;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
