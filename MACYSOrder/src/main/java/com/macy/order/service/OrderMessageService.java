package com.macy.order.service;


import org.springframework.http.ResponseEntity;

import com.macy.order.dto.UpdateOrderStatusRequest;

public interface OrderMessageService {
    ResponseEntity<Boolean> updateOrder(UpdateOrderStatusRequest updateOrderStatusRequest);
}
