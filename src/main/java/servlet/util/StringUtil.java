package servlet.util;

public class StringUtil {

    public static String truncateName(String surname, String name) {
	String space = new String(" ");
	String point = new String(".");

	return new StringBuilder()
		.append(surname)
		.append(space)
		.append(name.charAt(0))
		.append(point)
		.toString();
    }

    public static String createFullAddress(String index, String city, String street, String houseNumber,
	    String apartmentNumber) {
	String comma = new String(", ");

	return new StringBuilder()
		.append(index)
		.append(comma)
		.append(city)
		.append(comma)
		.append(street)
		.append(comma)
		.append("house: ")
		.append(houseNumber)
		.append(comma)
		.append("apartment: ")
		.append(apartmentNumber)
		.toString();
    }
}
