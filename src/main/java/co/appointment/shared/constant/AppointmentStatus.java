package co.appointment.shared.constant;

@SuppressWarnings({"InterfaceIsType"})
public interface AppointmentStatus {
    /**
     * Appointment booking confirmed.
     */
    String BOOKING_CONFIRMED = "CONFIRMED";
    /**
     * Appointment booking canceled.
     */
    String BOOKING_CANCELLED = "CANCELLED";
    /**
     * Appointment status when the user book an appointment.
     */
    String BOOKING_PENDING_CONFIRMATION = "PENDING CONFIRMATION";
}
