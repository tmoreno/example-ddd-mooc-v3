package com.tmoreno.mooc.backoffice.shared.domain.events;

import com.tmoreno.mooc.backoffice.shared.domain.Identifier;

import java.time.Instant;

public abstract class DomainEvent {

    private final String eventId;
    private final String aggregateId;
    private final int version;
    private final Instant occurredOn;

    protected DomainEvent(String aggregateId, int version) {
        this.eventId = new Identifier().getValue();
        this.aggregateId = aggregateId;
        this.version = version;
        this.occurredOn = Instant.now();
    }

    public final String getEventId() {
        return eventId;
    }

    public final String getAggregateId() {
        return aggregateId;
    }

    public final int getVersion() {
        return version;
    }

    public final Instant getOccurredOn() {
        return occurredOn;
    }
}
