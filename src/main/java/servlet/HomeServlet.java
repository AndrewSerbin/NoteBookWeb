package servlet;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ResourceBundle bundle = getBundle(request, response);

	HttpSession session = request.getSession();
	session.setAttribute("bundle", bundle);

	// Forward to /WEB-INF/views/form.html
	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/form.jsp");

	dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

    private ResourceBundle getBundle(HttpServletRequest request, HttpServletResponse response) {
	switch (request.getParameter("language")) {
	case "en":
	    return ResourceBundle.getBundle("input_en", new Locale("en", "GB"));

	case "ru":
	    return ResourceBundle.getBundle("input_ru", new Locale("ru", "RU"));

	default:
	    throw new RuntimeException("Unsupported language");
	}
    }
}
