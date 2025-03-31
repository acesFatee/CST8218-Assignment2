package cst8218.assignment2.soha0021_bhan0075.auth;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;

/**
 * A managed bean responsible for handling user logout functionality in the application.
 * This bean is request-scoped and will invalidate the session and redirect the user to the homepage upon logout.
 */
@Named("authLogoutBean")
@RequestScoped
public class LogoutBean implements Serializable {

    /**
     * Logs out the current user by invalidating the session and redirecting them to the homepage.
     * 
     * @return null since the redirection is handled directly by the FacesContext.
     * @throws IOException if an error occurs during the redirection process.
     */
    public String logout() throws IOException {
        // Invalidate the current session to log the user out
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        // Redirect the user to the homepage after logout
        FacesContext.getCurrentInstance().getExternalContext().redirect("/CST8218-Assignment2");

        // Return null as the redirection has already been handled
        return null;
    }
}
