package com.tmoreno.mooc.backoffice.shared.domain;

import java.time.Instant;
import java.util.Map;

public abstract class DomainEvent {

    private final Identifier eventId;
    private final Identifier aggregateId;
    private final String eventName;
    private final int version;
    private final Instant occurredOn;
    private final Map<String, Object> payload;

    protected DomainEvent(Identifier aggregateId, String eventName, int version, Map<String, Object> payload) {
        this.eventId = new Identifier();
        this.aggregateId = aggregateId;
        this.eventName = eventName;
        this.version = version;
        this.occurredOn = Instant.now();
        this.payload = payload;
    }

    public final Identifier getEventId() {
        return eventId;
    }

    public final Identifier getAggregateId() {
        return aggregateId;
    }

    public final String getEventName() {
        return eventName;
    }

    public final int getVersion() {
        return version;
    }

    public final Instant getOccurredOn() {
        return occurredOn;
    }

    public final Map<String, Object> getPayload() {
        return payload;
    }
}
