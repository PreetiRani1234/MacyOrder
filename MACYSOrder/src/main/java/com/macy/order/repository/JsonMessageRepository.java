package com.macy.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macy.order.entity.json.OrderMessageJsonEntity;

public interface JsonMessageRepository extends JpaRepository<OrderMessageJsonEntity, Integer> {
}