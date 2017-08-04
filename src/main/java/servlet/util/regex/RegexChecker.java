package servlet.util.regex;

import java.util.Hashtable;

public class RegexChecker {

    // Validation data
    private Hashtable<String, String> errors;
    private boolean validation;

    public RegexChecker() {
	errors = new Hashtable<>();
	validation = true;
    }

    public void checkWithRegex(String parameterName, String input, String regex) {
	if (input == null || !input.matches(regex)) {
	    errors.put(parameterName, regex);
	    validation = false;
	}
    }

    public void putInErrors(String key, String value) {
	errors.put(key, value);
    }

    public Hashtable<String, String> getErrors() {
	return errors;
    }

    public void setErrors(Hashtable<String, String> errors) {
	this.errors = errors;
    }

    public boolean isValidation() {
	return validation;
    }

    public void setValidation(boolean validation) {
	this.validation = validation;
    }
}
