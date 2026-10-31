package co.appointment.shared.constant;

/** Role Constants. */
@SuppressWarnings({"InterfaceIsType"})
public interface RoleConstants {
    /** Role for customers. */
    String CUSTOMER_ROLE = "CUSTOMER";

    /** Role for admins. */
    String ADMIN_ROLE = "ADMINISTRATOR";

    /**
     * Role for users working on the branch.
     * These users can reject or approve appointments on the branch
     */
    String TELLER_ROLE = "TELLER";
}
