package user.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.model.User;

public class UserJDBCDao implements UserDao {
	
	Connection conn;
	
	public void setConnection(Connection connection) {
		this.conn = connection;
	}

	public User find(String email) {
		User user = null;

		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM user WHERE email=?");
			statement.setString(1, email);

			ResultSet rs = statement.executeQuery();

			String nom = rs.getString("lastname");
			String prenom = rs.getString("firstname");
			String motdepasse = rs.getString("pwd");

			user = new User(email, nom, prenom, motdepasse);
			
			rs.close();
		} catch ( SQLException e ) {
			throw new Error("Unable to find User " + email, e);
		}
		
		return user;
	}

	public void delete(String email) {
		try {
			PreparedStatement statement = conn.prepareStatement("DELETE FROM user where email=?");
			statement.setString(1, email);

			statement.executeUpdate();
		} catch(SQLException e) {
			throw new Error("Unable to delete User " + email, e);
		}
	}

	public void create(User user) {
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO user VALUES(?, ?, ?, ?)");
			statement.setString(1, user.getMail());
			statement.setString(2, user.getNom());
			statement.setString(3, user.getPrenom());
			statement.setString(4, user.getMotDePasse());
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new Error("Unable to insert User " + user, e);
		}
	}

	public void update(User user) {
		try {
			PreparedStatement statement = conn.prepareStatement("UPDATE user SET lastname=?, firstname=?, pwd=? WHERE email=?");
			statement.setString(1, user.getNom());
			statement.setString(2, user.getPrenom());
			statement.setString(3, user.getMotDePasse());
			statement.setString(4, user.getMail());
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new Error("Unable to insert User " + user, e);
		}
	}


	public boolean checkPassword(String email, String password) {
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT email FROM user WHERE email=? AND pwd=?");
			statement.setString(1, email);
			statement.setString(2, password);
		

			ResultSet rs = statement.executeQuery();
			boolean exists = rs.next();
			rs.close();
			return exists;
		} catch(SQLException e) {
			throw new Error("Unable to identified User " + email, e);
		}
	}
}
