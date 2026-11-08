package co.appointment.shared.event;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthEvent implements DomainEvent {

    private String email;
    private String tokenType;
    private UUID eventId;

    @Override
    public UUID getEventId() {
        if (eventId == null) {
            return UUID.randomUUID();
        }
        return eventId;
    }
}
