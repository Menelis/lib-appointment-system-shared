package co.appointment.shared.event;

import java.util.UUID;

public interface DomainEvent {
    UUID getEventId();
}
