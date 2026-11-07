package co.appointment.shared.service.grcp;

import co.appointment.shared.record.UserSummary;
import co.appointment.shared.record.VerificationTokenSummary;
import java.util.UUID;

public interface GrpcAuthClient {
    /**
     * Get User details from Auth Service via gRPC protocol that matches the provided email.
     *
     * @param email user email
     * @return {@link UserSummary}
     */
    UserSummary getUserByEmail(String email);

    /**
     * Get User details from Auth Service via gRPC protocol that matches the provided id.
     *
     * @param id user id
     * @return {@link UserSummary}
     */
    UserSummary getUserById(UUID id);

    VerificationTokenSummary getVerificationTokenByEmail(String email);
}
