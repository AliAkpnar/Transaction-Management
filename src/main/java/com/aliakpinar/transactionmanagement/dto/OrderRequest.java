package com.aliakpinar.transactionmanagement.dto;

import com.aliakpinar.transactionmanagement.entity.OrderEntity;
import com.aliakpinar.transactionmanagement.entity.PaymentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private OrderEntity order;
    private PaymentEntity payment;
}

