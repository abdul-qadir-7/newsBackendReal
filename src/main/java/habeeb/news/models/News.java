package habeeb.news.models;

import java.util.List;

public class News {
	private int newsPk;
	private int countryPk;
	private int subCategoryPk;
	private int categoryPk;
	private String heading;
	private String categoryName;
	private boolean isSubscribed;
	private boolean isBookmarked;
	//image
	private String image;
	private String description;
	private String email;
	private List<SubNews> subNews;
	public int getCountryPk() {
		return countryPk;
	}
	public void setCountryPk(int countryPk) {
		this.countryPk = countryPk;
	}
	public int getSubCategoryPk() {
		return subCategoryPk;
	}
	public void setSubCategoryPk(int subCategoryPk) {
		this.subCategoryPk = subCategoryPk;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<SubNews> getSubNews() {
		return subNews;
	}
	public void setSubNews(List<SubNews> subNews) {
		this.subNews = subNews;
	}
	public int getNewsPk() {
		return newsPk;
	}
	public void setNewsPk(int newsPk) {
		this.newsPk = newsPk;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public boolean isSubscribed() {
		return isSubscribed;
	}
	public void setSubscribed(boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
	}
	public boolean isBookmarked() {
		return isBookmarked;
	}
	public void setBookmarked(boolean isBookmarked) {
		this.isBookmarked = isBookmarked;
	}
	public int getCategoryPk() {
		return categoryPk;
	}
	public void setCategoryPk(int categoryPk) {
		this.categoryPk = categoryPk;
	}
}
