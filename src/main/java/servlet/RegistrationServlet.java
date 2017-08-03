package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.Address;
import model.entity.FullName;
import model.entity.Group;
import model.entity.NoteBookSingleton;
import model.entity.Telephone;
import model.entity.builder.RecordBuilder;
import model.exception.EmailAlreadyExistsException;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static NoteBookSingleton noteBook = NoteBookSingleton.getInstance();

    private String surname;
    private String name;
    private String patronymic;
    private String truncatedName;

    private String nick;

    private String description;

    private String group;

    private String mainTelephone;
    private String spareTelephone;

    private String email;

    private String skype;

    private String index;
    private String city;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String fullAddress;

    private Hashtable<String, String> errors = new Hashtable<>();
    private boolean validation;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	validation = true;
	
	setAll(request);
	checkAll();

	HttpSession session = request.getSession();

	RequestDispatcher dispatcher;
	if (validation) {
	    try {
		noteBook.add(new RecordBuilder()
		    		.setFullName(surname, name, patronymic, truncatedName)
		    		.setNick(nick)
		    		.setDesription(description)
		    		.setGroup(group)
		    		.setTelephone(mainTelephone, spareTelephone)
		    		.setEmail(email)
		    		.setSkype(skype)
		    		.setAddress(index, city, street, houseNumber, apartmentNumber, fullAddress)
		    		.build());
		
		dispatcher = this.getServletContext().getRequestDispatcher("/success.jsp");
	    } catch (EmailAlreadyExistsException e) {
		errors.put("email", RegexConstants.REGEX_EMAIL);
		session.setAttribute("errors", errors);
		
		dispatcher = this.getServletContext().getRequestDispatcher("/retry.jsp");
	    }
	} else {
	    session.setAttribute("errors", errors);
	    
	    dispatcher = this.getServletContext().getRequestDispatcher("/retry.jsp");
	}
	dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

    private void checkAll() {
	// TODO: Separate on methods
	checkWithRegex("name", name, RegexConstants.REGEX_NAME);
	checkWithRegex("surname", surname, RegexConstants.REGEX_NAME);
	checkWithRegex("patronymic", patronymic, RegexConstants.REGEX_NAME);
	checkWithRegex("nick", nick, RegexConstants.REGEX_NICK);
	checkWithRegex("description", description, RegexConstants.REGEX_DESCRIPTION);
	checkWithRegex("group", group, RegexConstants.REGEX_GROUP);
	checkWithRegex("mainTelephone", mainTelephone, RegexConstants.REGEX_TELEPHONE);
	checkWithRegex("spareTelephone", spareTelephone, RegexConstants.REGEX_TELEPHONE);
	checkWithRegex("email", email, RegexConstants.REGEX_EMAIL);
	checkWithRegex("skype", skype, RegexConstants.REGEX_SKYPE);
	checkWithRegex("index", index, RegexConstants.REGEX_INDEX);
	checkWithRegex("city", city, RegexConstants.REGEX_CITY_AND_STREET);
	checkWithRegex("street", street, RegexConstants.REGEX_CITY_AND_STREET);
	checkWithRegex("houseNumber", houseNumber, RegexConstants.REGEX_HOUSE_AND_APARTMENT_NUMBER);
	checkWithRegex("apartmentNumber", apartmentNumber, RegexConstants.REGEX_HOUSE_AND_APARTMENT_NUMBER);
    }

    public void checkWithRegex(String parameterName, String input, String regex) {
	if (!input.matches(regex)) {
	    errors.put(parameterName, regex);
	    validation = false;
	}
    }

    private void setAll(HttpServletRequest request) {
	setFullName(request);
	setNick(request);
	setDescription(request);
	setGroup(request);
	setTelephone(request);
	setEmail(request);
	setSkype(request);
	setAddress(request);
    }

    private void setFullName(HttpServletRequest request) {
	name = request.getParameter("name");
	surname = request.getParameter("surname");
	patronymic = request.getParameter("patronymic");
	truncatedName = truncateName(surname, name);
    }

    private void setNick(HttpServletRequest request) {
	nick = request.getParameter("nick");
    }

    private void setDescription(HttpServletRequest request) {
	description = request.getParameter("description");
    }

    private void setGroup(HttpServletRequest request) {
	group = request.getParameter("group");
    }

    private void setTelephone(HttpServletRequest request) {
	mainTelephone = request.getParameter("mainTelephone");
	spareTelephone = request.getParameter("spareTelephone");
    }

    private void setEmail(HttpServletRequest request) {
	email = request.getParameter("email");
    }

    private void setSkype(HttpServletRequest request) {
	skype = request.getParameter("skype");
    }

    private void setAddress(HttpServletRequest request) {
	index = request.getParameter("index");
	city = request.getParameter("city");
	street = request.getParameter("street");
	houseNumber = request.getParameter("houseNumber");
	apartmentNumber = request.getParameter("apartmentNumber");
	fullAddress = createFullAddress(index, city, street, houseNumber, apartmentNumber);
    }

    private String truncateName(String surname, String name) {
	String space = new String(" ");
	String point = new String(".");

	return new StringBuilder()
		.append(surname)
		.append(space)
		.append(name.charAt(0))
		.append(point)
		.toString();
    }

    String createFullAddress(String index, String city, String street, String houseNumber, String apartmentNumber) {
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