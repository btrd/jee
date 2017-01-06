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

@WebServlet("/auth")
public class AuthControl extends HttpServlet {
	
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
		try {
			if(userDao.checkPassword(email, password)) {
				resp.sendRedirect("/welcome.html");
			} else {
				req.setAttribute("error", "<div class='alert alert-danger'>Mauvais mot de passe</div>");
				req.setAttribute("email", email);
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
		} catch(Exception e) {
			req.setAttribute("error", e.toString());
			req.setAttribute("email", email);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
	

}
