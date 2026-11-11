package co.appointment.shared.security;

import java.util.List;
import java.util.UUID;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public interface AuthenticationFacade {
    /**
     * Returns user authentication from {@link SecurityContextHolder} instance.
     *
     * @return {@link Authentication}
     */
    Authentication getAuthentication();

    /**
     * Get LoggedIn user id.
     *
     * @return user id
     */
    UUID getUserId();

    /**
     * Returns claim values as list.
     * @param claimName claim name
     * @return List of claims
     */
    default List<String> getClaimAsList(String claimName) {
        return List.of();
    }

    default boolean hasRole(String role) {
        return false;
    }
}
