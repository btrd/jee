package utils;

import java.sql.SQLException;
import org.sqlite.SQLiteDataSource;

import user.dao.UserDao;
import user.dao.UserJDBCDao;

public class DaoFactory {
	
	private static UserDao userDao; 

	public static UserDao createUserDao() throws SQLException {
		if ( userDao != null ) return userDao;
		
		UserJDBCDao dao = new UserJDBCDao();
		SQLiteDataSource dataSource = new SQLiteDataSource();
		dataSource.setUrl("jdbc:sqlite:/Users/janus24/Documents/Cours/Master/S3/JEE/java_ee_spring-16/week202/data.db");
		dao.setConnection(dataSource.getConnection());
		return dao;
	}
}
