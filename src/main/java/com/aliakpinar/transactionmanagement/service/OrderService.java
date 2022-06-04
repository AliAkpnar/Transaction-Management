package com.aliakpinar.transactionmanagement.service;

import com.aliakpinar.transactionmanagement.dto.OrderRequest;
import com.aliakpinar.transactionmanagement.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
