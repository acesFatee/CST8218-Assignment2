package cst8218.assignment2.soha0021_bhan0075.presentation;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Locale;

@Named("localeBean")
@SessionScoped
public class LocaleBean implements Serializable {

    private Locale locale = Locale.ENGLISH;

    public Locale getLocale() {
        return locale;
    }

    public void setLanguage(String language) {
        this.locale = new Locale(language);
    }

    public String getLanguage() {
        return locale.getLanguage();
    }
}
