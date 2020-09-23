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
 * angular角色&菜单表
 * </p>
 *
 * @author liuwei
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("AN_RM")
public class Rm extends Model<Rm> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色&菜单表内ID
     */
    @TableId("RO_MU_ID")
    private String roMuId;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    private String roleId;

    /**
     * 菜单组
     */
    @TableField("MENU_ID_ARR")
    private String menuIdArr;


    @Override
    protected Serializable pkVal() {
        return this.roMuId;
    }

}
