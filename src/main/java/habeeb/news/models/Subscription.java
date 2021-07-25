package habeeb.news.models;

public class Subscription {

	private String email;
	private int categoryPk;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCategoryPk() {
		return categoryPk;
	}
	public void setCategoryPk(int categoryPk) {
		this.categoryPk = categoryPk;
	}
}
