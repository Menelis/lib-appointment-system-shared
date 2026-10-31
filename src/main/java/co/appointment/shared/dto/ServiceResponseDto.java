package co.appointment.shared.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponseDto {
    private boolean success;
    private String errorDescription;
    private UUID correlationId;
    private String referenceNo;

    @Builder.Default
    private OffsetDateTime responseTime = OffsetDateTime.now();
}
