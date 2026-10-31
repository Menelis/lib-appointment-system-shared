package co.appointment.shared.util;

import co.appointment.shared.model.OpenApiSettings;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@SuppressWarnings({"HideUtilityClassConstructor"})
public class OpenApiUtils {

    private static SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }

    public static OpenAPI openAPI(final OpenApiSettings openApiSettings) {

        OpenApiSettings.OpenApiInfo info = openApiSettings.getInfo();

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info()
                        .title(info.getTitle())
                        .description(info.getDescription())
                        .version(info.getVersion()));
    }
}
