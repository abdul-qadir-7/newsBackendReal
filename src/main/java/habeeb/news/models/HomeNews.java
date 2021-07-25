package habeeb.news.models;

import java.util.List;

public class HomeNews {
	private List<News> topNews;
	private List<News> latestGadgets;
	private List<News> latestB2btech;
	private List<News> latestResourceLib;
	public List<News> getLatestGadgets() {
		return latestGadgets;
	}
	public void setLatestGadgets(List<News> latestGadgets) {
		this.latestGadgets = latestGadgets;
	}
	public List<News> getLatestB2btech() {
		return latestB2btech;
	}
	public void setLatestB2btech(List<News> latestB2btech) {
		this.latestB2btech = latestB2btech;
	}
	public List<News> getLatestResourceLib() {
		return latestResourceLib;
	}
	public void setLatestResourceLib(List<News> latestResourceLib) {
		this.latestResourceLib = latestResourceLib;
	}
	public List<News> getTopNews() {
		return topNews;
	}
	public void setTopNews(List<News> topNews) {
		this.topNews = topNews;
	}
	 
}
