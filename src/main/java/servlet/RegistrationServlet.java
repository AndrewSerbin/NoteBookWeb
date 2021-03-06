package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.NoteBookSingleton;
import model.entity.Record;
import model.entity.builder.RecordBuilder;
import model.exception.EmailAlreadyExistsException;
import servlet.util.StringUtil;
import servlet.util.regex.RegexChecker;
import servlet.util.regex.RegexConstants;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private HttpSession session;

    private static NoteBookSingleton noteBook = NoteBookSingleton.getInstance();

    // Record data
    private String surname;
    private String name;
    private String patronymic;

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

    private RegexChecker checker;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	setValidation();

	setAll(request);
	checkAll();

	session = request.getSession();

	redirect(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	Record record = buildRecord();
	RequestDispatcher dispatcher;

	if (checker.isValidation()) {
	    try {
		noteBook.add(record);

		dispatcher = this.getServletContext().getRequestDispatcher("/success.jsp");
	    } catch (EmailAlreadyExistsException e) {
		checker.putInErrors("email", RegexConstants.REGEX_EMAIL);
		session.setAttribute("errors", checker.getErrors());

		dispatcher = this.getServletContext().getRequestDispatcher("/retry.jsp");
	    }
	} else {
	    session.setAttribute("errors", checker.getErrors());

	    dispatcher = this.getServletContext().getRequestDispatcher("/retry.jsp");
	}

	dispatcher.forward(request, response);
    }

    private Record buildRecord() {
	return new RecordBuilder()
		.setFullName(surname, name, patronymic, StringUtil.truncateName(surname, name))
		.setNick(nick)
		.setDesription(description)
		.setGroup(group)
		.setTelephone(mainTelephone, spareTelephone)
		.setEmail(email)
		.setSkype(skype)
		.setAddress(index, city, street, houseNumber, apartmentNumber,
			StringUtil.createFullAddress(index, city, street, houseNumber, apartmentNumber))
		.build();
    }

    private void setValidation() {
	checker = new RegexChecker();
    }

    private void checkAll() {
	// TODO: Separate on methods
	checker.checkWithRegex("name", name, RegexConstants.REGEX_NAME);
	checker.checkWithRegex("surname", surname, RegexConstants.REGEX_NAME);
	checker.checkWithRegex("patronymic", patronymic, RegexConstants.REGEX_NAME);
	checker.checkWithRegex("nick", nick, RegexConstants.REGEX_NICK);
	checker.checkWithRegex("description", description, RegexConstants.REGEX_DESCRIPTION);
	checker.checkWithRegex("group", group, RegexConstants.REGEX_GROUP);
	checker.checkWithRegex("mainTelephone", mainTelephone, RegexConstants.REGEX_TELEPHONE);
	checker.checkWithRegex("spareTelephone", spareTelephone, RegexConstants.REGEX_TELEPHONE);
	checker.checkWithRegex("email", email, RegexConstants.REGEX_EMAIL);
	checker.checkWithRegex("skype", skype, RegexConstants.REGEX_SKYPE);
	checker.checkWithRegex("index", index, RegexConstants.REGEX_INDEX);
	checker.checkWithRegex("city", city, RegexConstants.REGEX_CITY_AND_STREET);
	checker.checkWithRegex("street", street, RegexConstants.REGEX_CITY_AND_STREET);
	checker.checkWithRegex("houseNumber", houseNumber, RegexConstants.REGEX_HOUSE_AND_APARTMENT_NUMBER);
	checker.checkWithRegex("apartmentNumber", apartmentNumber, RegexConstants.REGEX_HOUSE_AND_APARTMENT_NUMBER);
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
    }
}