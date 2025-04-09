package com.tmoreno.mooc.backoffice.shared.domain;

import java.time.Instant;

public abstract class DomainEvent {

    private final Identifier eventId;
    private final Identifier aggregateId;
    private final String eventName;
    private final int version;
    private final Instant occurredOn;

    protected DomainEvent(Identifier aggregateId, String eventName, int version) {
        this.eventId = new Identifier();
        this.aggregateId = aggregateId;
        this.eventName = eventName;
        this.version = version;
        this.occurredOn = Instant.now();
    }

    public Identifier getEventId() {
        return eventId;
    }

    public Identifier getAggregateId() {
        return aggregateId;
    }

    public String getEventName() {
        return eventName;
    }

    public int getVersion() {
        return version;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }
}
