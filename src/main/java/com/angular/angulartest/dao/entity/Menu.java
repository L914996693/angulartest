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
 * angular菜单
 * </p>
 *
 * @author liuwei
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("AN_MENU")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单表表内ID
     */
    @TableId("MENU_ID")
    private String menuId;

    /**
     * 菜单名称
     */
    @TableField("MENU_NAME")
    private String menuName;

    /**
     * 菜单地址
     */
    @TableField("MENU_URL")
    private String menuUrl;

    /**
     * 是否启用
     */
    @TableField("MENU_STATUS")
    private String menuStatus;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private String createTime;

    /**
     * 父级菜单ID
     */
    @TableField("PARENT_MENU_ID")
    private String parentMenuId;


    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }

}
