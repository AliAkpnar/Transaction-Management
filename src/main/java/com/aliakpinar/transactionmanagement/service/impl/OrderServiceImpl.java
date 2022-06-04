package com.aliakpinar.transactionmanagement.service.impl;

import com.aliakpinar.transactionmanagement.dto.OrderRequest;
import com.aliakpinar.transactionmanagement.dto.OrderResponse;
import com.aliakpinar.transactionmanagement.entity.OrderEntity;
import com.aliakpinar.transactionmanagement.entity.PaymentEntity;
import com.aliakpinar.transactionmanagement.exception.PaymentException;
import com.aliakpinar.transactionmanagement.repository.OrderRepository;
import com.aliakpinar.transactionmanagement.repository.PaymentRepository;
import com.aliakpinar.transactionmanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        OrderEntity order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        PaymentEntity payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
