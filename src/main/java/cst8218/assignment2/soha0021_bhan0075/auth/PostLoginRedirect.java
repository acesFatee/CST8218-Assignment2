package cst8218.assignment2.soha0021_bhan0075.auth;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.IOException;

@Named("postLoginRedirect")
@RequestScoped
public class PostLoginRedirect {
    public void redirect() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
    }
}
