package com.angular.angulartest.dao.service.impl;

import com.angular.angulartest.dao.entity.Payment;
import com.angular.angulartest.dao.mapper.PaymentMapper;
import com.angular.angulartest.dao.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付表 服务实现类
 * </p>
 *
 * @author liuwei
 * @since 2020-10-25
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

}
