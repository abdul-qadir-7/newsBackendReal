package habeeb.news.models;

import java.util.List;

public class User {

	private int output;
	private String name;
	private String email;
	private String password;
	private int countryPk;
	private List<Integer> userSubscribedCategories;
	public List<Integer> getUserSubscribedCategories() {
		return userSubscribedCategories;
	}
	public void setUserSubscribedCategories(List<Integer> userSubscribedCategories) {
		this.userSubscribedCategories = userSubscribedCategories;
	}
	private int superAdmin;
	private int admin;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCountryPk() {
		return countryPk;
	}
	public void setCountryPk(int countryPk) {
		this.countryPk = countryPk;
	}
	public int getSuperAdmin() {
		return superAdmin;
	}
	public void setSuperAdmin(int i) {
		this.superAdmin = i;
	}
	public int getOutput() {
		return output;
	}
	public void setOutput(int output) {
		this.output = output;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
}
