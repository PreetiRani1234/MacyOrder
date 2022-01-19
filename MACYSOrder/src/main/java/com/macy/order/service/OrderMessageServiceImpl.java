package com.macy.order.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.macy.order.dto.OrderStatus;
import com.macy.order.dto.UpdateOrderStatusRequest;
import com.macy.order.entity.json.OrderMessageJsonEntity;
import com.macy.order.entity.xml.FulfillmentOrderEntity;
import com.macy.order.exception.CustomEntityNotFoundException;
import com.macy.order.repository.JsonMessageRepository;
import com.macy.order.repository.XmlMessageRepository;

@Service
	public class OrderMessageServiceImpl implements OrderMessageService {

	    @Autowired
	    XmlMessageRepository xmlMessageRepository;

	    @Autowired
	    JsonMessageRepository jsonMessageRepository;

	    @ExceptionHandler(CustomEntityNotFoundException.class)
	    @Override
	    public ResponseEntity<Boolean> updateOrder(UpdateOrderStatusRequest updateOrderStatusRequest) {
	        try {
	            FulfillmentOrderEntity xmlEntity = xmlMessageRepository.getById(updateOrderStatusRequest.getId());
	            return updateXmlOrder(xmlEntity, updateOrderStatusRequest);
	        } catch (EntityNotFoundException e) {
	            try {
	                OrderMessageJsonEntity jsonEntity = jsonMessageRepository.getById(updateOrderStatusRequest.getId());
	                return updateJsonOrder(jsonEntity, updateOrderStatusRequest);
	            } catch (EntityNotFoundException ex) {
	                throw new CustomEntityNotFoundException();
	            }
	        }
	    }

	    private ResponseEntity<Boolean> updateXmlOrder(FulfillmentOrderEntity entity, UpdateOrderStatusRequest updateOrderStatusRequest) throws EntityNotFoundException {
	        entity.setOrderStatus(OrderStatus.valueOf(updateOrderStatusRequest.getStatus().toUpperCase()));
	        xmlMessageRepository.save(entity);
	        return new ResponseEntity<>(true, HttpStatus.OK);
	    }

	    public ResponseEntity<Boolean> updateJsonOrder(OrderMessageJsonEntity jsonEntity, UpdateOrderStatusRequest updateOrderStatusRequest) throws EntityNotFoundException {
	        jsonEntity.setOrderStatus(OrderStatus.valueOf(updateOrderStatusRequest.getStatus().toUpperCase()));
	        jsonMessageRepository.save(jsonEntity);
	        return new ResponseEntity<>(true, HttpStatus.OK);
	    }

}
