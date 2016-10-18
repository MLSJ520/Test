package DangAn;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public abstract class User {
	private String name;
	protected String password;
	private String role;

	User(String name, String password, String role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public abstract void ShowMenu() throws IllegalStateException, SQLException, IOException;
}