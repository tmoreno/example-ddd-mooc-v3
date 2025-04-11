package com.tmoreno.mooc.backoffice.shared;

import com.tmoreno.mooc.backoffice.shared.events.DomainEvent;

import java.util.List;

public interface EventBus {

    void publish(DomainEvent event);
    void publish(List<DomainEvent> events);

}
