package com.angular.angulartest.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 支付表
 * </p>
 *
 * @author liuwei
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CD_PAYMENT")
public class Payment extends Model<Payment> {

    private static final long serialVersionUID = 1L;

    /**
     * 表内ID
     */
    @TableField("PAY_ID")
    private String payId;

    /**
     * 流水号
     */
    @TableField("PAY_SERIAL")
    private String paySerial;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
