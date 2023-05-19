package zw.dreamhub.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 19/5/2023
 */

@ConfigurationProperties(prefix = "info")
@Component
class InfoEnv {

    var app: App? = null
    var contact: Contact? = null

    class App(
        var name: String,
        var description: String,
        var version: Double,
        var basePackage: String
    )


    class Contact(
        var name: String,
        var url: String,
        var email: String
    )

}
