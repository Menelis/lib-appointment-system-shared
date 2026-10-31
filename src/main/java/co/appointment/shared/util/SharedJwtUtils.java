package co.appointment.shared.util;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.util.StringUtils;

@SuppressWarnings({"HideUtilityClassConstructor"})
public class SharedJwtUtils {
    /**
     * Map Granted Authorities to JWT. By default, Spring Security maps SCOPE(s) to granted
     * authorities.
     *
     * @param grantedAuthoritiesClaimName - JWT Claim Name
     * @param grantedAuthoritiesClaimPrefix - JWT Claim Prefix
     * @return {@link JwtAuthenticationConverter}
     */
    public static JwtAuthenticationConverter convertJwtGrantedAuthorities(
            final String grantedAuthoritiesClaimName, final String grantedAuthoritiesClaimPrefix) {
        final JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        if (StringUtils.hasText(grantedAuthoritiesClaimName)) {
            grantedAuthoritiesConverter.setAuthorityPrefix(grantedAuthoritiesClaimPrefix);
        }
        if (StringUtils.hasText(grantedAuthoritiesClaimName)) {
            grantedAuthoritiesConverter.setAuthoritiesClaimName(grantedAuthoritiesClaimName);
        }
        final JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return converter;
    }
}
