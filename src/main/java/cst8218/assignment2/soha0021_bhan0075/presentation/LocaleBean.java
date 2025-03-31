package cst8218.assignment2.soha0021_bhan0075.presentation;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Locale;

/**
 * A managed bean that manages the user's language locale during a session.
 * This bean allows the user to change the language and retrieves the current locale.
 */
@Named("localeBean")
@SessionScoped
public class LocaleBean implements Serializable {

    // The current locale, defaulted to English
    private Locale locale = Locale.ENGLISH;

    /**
     * Gets the current locale of the user.
     * 
     * @return the current Locale object representing the user's language setting.
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Sets the language of the current locale.
     * 
     * @param language the language code (e.g., "en" for English, "fr" for French).
     */
    public void setLanguage(String language) {
        // Set the locale based on the provided language code
        this.locale = new Locale(language);
    }

    /**
     * Gets the current language code of the user's locale.
     * 
     * @return the language code (e.g., "en" for English, "fr" for French).
     */
    public String getLanguage() {
        return locale.getLanguage();
    }
}
