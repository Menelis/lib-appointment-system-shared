package co.appointment.shared.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class CorsSettings {
    private List<String> allowedOrigins = new ArrayList<>();
    private List<String> allowedHeaders = new ArrayList<>();
    private List<String> allowedMethods = new ArrayList<>();
    private long maxAge = 3600;
}
