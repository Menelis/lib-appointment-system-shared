package co.appointment.shared.event;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DomainEventMessage<T extends DomainEvent> {
    private String eventType;
    private String messageKey;
    private String correlationId;
    private T event;
}
