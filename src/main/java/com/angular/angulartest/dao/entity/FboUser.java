package com.angular.angulartest.dao.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuwei
 * @since 2020-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FboUser extends Model<FboUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户表内ID
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户店面
     */
    private String userShopName;

    /**
     * 用户组织ID
     */
    private String userOrgId;

    /**
     * 用户店面组织ID
     */
    private String userShopOrgId;

    /**
     * 用户外部ID
     */
    private String userK3Code;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
