package co.appointment.shared.model;

import lombok.Data;

@Data
public class JwtSettings {
    private String secret;
    private int expirationMs;
}
