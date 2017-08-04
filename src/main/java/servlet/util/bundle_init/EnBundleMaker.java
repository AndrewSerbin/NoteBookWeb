package servlet.util.bundle_init;

import java.util.Locale;
import java.util.ResourceBundle;

public class EnBundleMaker implements BundleMaker {

    @Override
    public ResourceBundle makeBundle() {
	return ResourceBundle.getBundle("input_en", new Locale("en", "GB"));
    }

}
