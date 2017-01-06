package user.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.model.User;
import utils.DaoFactory;

@WebServlet("/signin")
public class SignIn extends HttpServlet {
	
	UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		try {
			userDao = DaoFactory.createUserDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
	    if(email.equals("") || password.equals("") || firstname.equals("") || lastname.equals("") || email == null || password == null || firstname == null || lastname == null) {
			req.setAttribute("error", "Params manquant");
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		} else {
			try {
				User user = new User(email, lastname, firstname, password);
				userDao.create(user);
				resp.sendRedirect("/user-web/welcome.html");
			} catch(Exception e) {
				req.setAttribute("error", e.toString());
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
			}
			
		}
	}
	

}
