package co.appointment.shared.infastructure;

import co.appointment.shared.event.DomainEvent;
import co.appointment.shared.event.DomainEventMessage;
import java.util.Map;

public interface KafkaPublisher {
    void publish(String topic, DomainEventMessage<? extends DomainEvent> eventMessage, Map<String, Object> headers);
}
