package cst8218.assignment2.soha0021_bhan0075.auth;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.IOException;

/**
 * A managed bean that handles redirection after a successful login.
 * This bean is request-scoped and redirects the user to the index page after login.
 */
@Named("postLoginRedirect")
@RequestScoped
public class PostLoginRedirect {

    /**
     * Redirects the user to the index page after a successful login.
     * 
     * This method gets the current ExternalContext and uses it to perform a redirect 
     * to the index.xhtml page.
     * 
     * @throws IOException if an error occurs during the redirection process.
     */
    public void redirect() throws IOException {
        // Get the ExternalContext instance from the current FacesContext
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        
        // Redirect the user to the index.xhtml page
        ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
    }
}
