package habeeb.news.models;

public class Access {

	private String email;
	private int countryPk;
	private int categoryPk;
	private String country;
	private String category;
	private boolean access;//1 or 0. 0 for revoke access, 1 to give access
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCountryPk() {
		return countryPk;
	}
	public void setCountryPk(int countryPk) {
		this.countryPk = countryPk;
	}
	public int getCategoryPk() {
		return categoryPk;
	}
	public void setCategoryPk(int categoryPk) {
		this.categoryPk = categoryPk;
	}
	public boolean getAccess() {
		return access;
	}
	public void setAccess(boolean access) {
		this.access = access;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
