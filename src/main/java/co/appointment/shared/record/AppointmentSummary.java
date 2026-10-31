package co.appointment.shared.record;

import java.time.LocalDate;
import java.util.UUID;

public record AppointmentSummary(
        UUID id,
        UUID customerId,
        UUID branchId,
        LocalDate appointmentDate,
        String slotStart,
        String slotEnd,
        String description,
        String referenceNo,
        String status,
        String cancellationReason) {}
