package com.macy.order.util;


import org.modelmapper.ModelMapper;

import com.macy.order.dto.json.OrderMessageJson;
import com.macy.order.dto.xml.FulfillmentOrder;
import com.macy.order.entity.json.OrderMessageJsonEntity;
import com.macy.order.entity.xml.FulfillmentOrderEntity;

public class EntityPojoConverterUtil {

    public static OrderMessageJson jsonEntityToPojo(ModelMapper modelMapper, OrderMessageJsonEntity orderMessageJsonEntity) {
        return modelMapper.map(orderMessageJsonEntity, OrderMessageJson.class);
    }

    public static OrderMessageJsonEntity jsonPojoToEntity(ModelMapper modelMapper, OrderMessageJson orderMessageJson) {
        return modelMapper.map(orderMessageJson, OrderMessageJsonEntity.class);
    }

    public static FulfillmentOrderEntity xmlPojoToEntity(ModelMapper modelMapper, FulfillmentOrder fulfillmentOrder) {
        return modelMapper.map(fulfillmentOrder, FulfillmentOrderEntity.class);
    }

    public static FulfillmentOrder xmlEntityToPojo(ModelMapper modelMapper, FulfillmentOrderEntity fulfillmentOrderEntity) {
        return modelMapper.map(fulfillmentOrderEntity, FulfillmentOrder.class);
    }
}
