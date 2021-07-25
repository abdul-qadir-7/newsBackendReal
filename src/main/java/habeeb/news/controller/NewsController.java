package habeeb.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import habeeb.news.dao.NewsDao;
import habeeb.news.models.HomeNews;
import habeeb.news.models.News;

@RestController
@RequestMapping("/api/news")
public class NewsController {

	@Autowired
	NewsDao dao;
	@PostMapping(value="/add",produces="application/json")
	public void add(@RequestBody News news) {
		dao.add(news);
	}
	@PostMapping(value="/delete",produces="application/json")
	public void delete(@RequestBody News news) {
		dao.delete(news);
	}
	@PostMapping(value="/get",produces="application/json")
	public News getNews(@RequestBody News news) {
//		dao.delete();
		return dao.getNews(news.getEmail(),news.getNewsPk());
//		return new News();
	}
	@PostMapping(value="/getAllCategoryNews",produces="application/json")
	public List<News> getAllCategoryNews(@RequestBody News user) {
		return dao.getAllCategoryNews(user.getCategoryPk(),user.getCountryPk());
	}
	@PostMapping(value="/getAllSubCategoryNews",produces="application/json")
	public List<News> getAllSubCategoryNews(@RequestBody News user) {
		return dao.getAllSubCategoryNews(user.getSubCategoryPk(),user.getCountryPk());
	}
	@PostMapping(value="/getHomePage",produces="application/json")
	public HomeNews getHomePageNews(@RequestBody News user) {
		return dao.getHomePageNews(user.getCountryPk());
	}
	
	
}
