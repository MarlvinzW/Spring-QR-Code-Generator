package zw.dreamhub.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 19/5/2023
 */
@Configuration
@Component
class OpenApiConfig(private val env: InfoEnv) {

    private val schemeName = "bearerScheme"
    private val scheme = "Bearer"

    @Bean
    fun openAPI(): OpenAPI? {
        val openAPI = OpenAPI()
            .info(
                Info().title(env.app?.name)
                    .description(env.app?.description)
                    .version(env.app?.version.toString())
                    .contact(
                        Contact()
                            .name(env.contact?.name)
                            .email(env.contact?.email)
                            .url(env.contact?.url)
                    )
                    .license(License().name("Apache 2.0").url(env.contact?.url))
            )
        addSecurity(openAPI)
        return openAPI
    }

    private fun addSecurity(openApi: OpenAPI) {
        val components = createComponents()
        val securityItem = SecurityRequirement().addList(schemeName)
        openApi
            .components(components)
            .addSecurityItem(securityItem)
    }

    private fun createComponents(): Components {
        val components = Components()
        components.addSecuritySchemes(schemeName, createSecurityScheme())
        return components
    }

    private fun createSecurityScheme(): SecurityScheme? {
        return SecurityScheme()
            .name(schemeName)
            .type(SecurityScheme.Type.HTTP)
            .scheme(scheme)
    }

}