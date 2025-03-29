package cst8218.assignment2.soha0021_bhan0075;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author bhan
 */
@FormAuthenticationMechanismDefinition(
    loginToContinue = @LoginToContinue(
        loginPage = "/faces/login.xhtml",
        errorPage = "/faces/login.xhtml"
    )
)
@DatabaseIdentityStoreDefinition(
    dataSourceLookup = "jndi/mariadb",
    callerQuery = "SELECT password FROM appuser WHERE BINARY userid = ?",
    groupsQuery = "SELECT groupname FROM appuser WHERE BINARY userid = ?",
    hashAlgorithm = Pbkdf2PasswordHash.class,
    priority = 10
)
@Named
@ApplicationScoped
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {
}