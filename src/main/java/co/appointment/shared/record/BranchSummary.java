package co.appointment.shared.record;

public record BranchSummary(
        String name,
        String addressLine1,
        String addressLine2,
        String suburb,
        String city,
        String province,
        String postalCode,
        String email,
        String landLine,
        String faxNo) {}
