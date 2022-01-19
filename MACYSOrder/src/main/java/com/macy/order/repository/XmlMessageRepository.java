package com.macy.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macy.order.entity.xml.FulfillmentOrderEntity;

public interface XmlMessageRepository extends JpaRepository<FulfillmentOrderEntity, Integer> {
}