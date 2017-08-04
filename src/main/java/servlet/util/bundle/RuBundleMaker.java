package servlet.util.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class RuBundleMaker implements BundleMaker {

    @Override
    public ResourceBundle makeBundle() {
	return ResourceBundle.getBundle("input_ru", new Locale("ru", "RU"));
    }

}
