package co.appointment.shared.record;

import java.util.UUID;

public record VerificationTokenSummary(UUID id, String token, long expiryDate, String tokenType) {}
