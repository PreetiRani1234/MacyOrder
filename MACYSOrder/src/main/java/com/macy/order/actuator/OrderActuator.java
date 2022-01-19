package com.macy.order.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.macy.order.repository.JsonMessageRepository;
import com.macy.order.repository.XmlMessageRepository;

@Component
public class OrderActuator implements InfoContributor {

    @Autowired
    JsonMessageRepository jsonMessageRepository;

    @Autowired
    XmlMessageRepository xmlMessageRepository;

    @Override
    public void contribute(Info.Builder builder) {
        builder
                .withDetail("Total XML Messages Consumed : ", xmlMessageRepository.count())
                .withDetail("Total JSON Messages Consumed : ", jsonMessageRepository.count())
                .build();
    }
}
