package servlet.util.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class EnBundleMaker implements BundleMaker {

    @Override
    public ResourceBundle makeBundle() {
	return ResourceBundle.getBundle("input_en", new Locale("en", "GB"));
    }

}
