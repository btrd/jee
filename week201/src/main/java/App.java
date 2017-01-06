import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

import org.sqlite.SQLiteDataSource;

public class App {

	public static void main(String[] args) throws SQLException {
		System.out.println("___ App ___");
		
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl("jdbc:sqlite:data.db");
		
		Connection conn = ds.getConnection();

		ResultSet rs = conn
		.createStatement()
		.executeQuery("select * from user");

		while( rs.next() ) {
			String prenom = rs.getString("firstname");
			String nom = rs.getString("lastname");
			String email = rs.getString("email");
			System.out.println(prenom + nom + email);
		}
		conn.close();
	}
}
