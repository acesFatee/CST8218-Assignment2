package cst8218.assignment2.soha0021_bhan0075.auth;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named("authLogoutBean")
@RequestScoped
public class LogoutBean implements Serializable {

    public String logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Assignment2");
        return null;
    }
}
