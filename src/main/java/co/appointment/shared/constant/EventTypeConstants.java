package co.appointment.shared.constant;

@SuppressWarnings({"InterfaceIsType"})
public interface EventTypeConstants {
    String EVENT_TYPE = "eventType";
    String VERIFY_EMAIL_EVENT = "verifyEmail";
    String BOOKING_CONFIRMED_EVENT = "bookingConfirmed";
    String BOOKING_PENDING_CONFIRMATION_EVENT = "bookingPendingConfirmation";
    String BOOKING_CANCELLED_EVENT = "bookingCancelled";
    String PASSWORD_RESET_EVENT = "passwordReset";
}
