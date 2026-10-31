package co.appointment.shared.constant;

@SuppressWarnings({"InterfaceIsType"})
public interface SharedConstants {
    /** Internal Server Error message. */
    String INTERNAL_SERVER_ERROR = "Oops! Something went wrong!!";

    /** Page Number default value - 1. */
    String PAGE_NUMBER_DEFAULT_VALUE = "1";

    /** Page Size default value = 10. */
    String PAGE_SIZE_DEFAULT_VALUE = "10";

    /** Page Number parameter name. */
    String PAGE_NUMBER_PARAMETER_NAME = "pageNo";

    /** Page Size parameter name. */
    String PAGE_SIZE_PARAMETER_NAME = "pageSize";

    String SEARCH_TERM_PARAMETER_NAME = "searchTerm";
    String APPOINTMENT_SYSTEM_EMAIL_FOOTER = "Kind Regards,<br/>Appointment System Team.";
    String X_CORRELATION_ID = "X-Correlation-Id";
}
