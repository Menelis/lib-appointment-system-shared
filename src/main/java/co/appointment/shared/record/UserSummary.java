package co.appointment.shared.record;

import java.util.UUID;

public record UserSummary(UUID id, String fullName, String email) {}
