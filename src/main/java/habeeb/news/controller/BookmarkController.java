package habeeb.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import habeeb.news.dao.BookmarkDao;
import habeeb.news.models.News;

@RestController
@RequestMapping("/api/bookmark")
public class BookmarkController {

	@Autowired
	BookmarkDao dao;
	
	@PostMapping(value="/add",produces="application/json")
	public void add(@RequestBody News news) {
		dao.add(news);
	}
	@PostMapping(value="/remove",produces="application/json")
	public void remove(@RequestBody News news) {
		dao.remove(news);
	}
	@PostMapping(value="/getAll",produces="application/json")
	public List<News> getAllBookmarked(@RequestBody News user) {
		return dao.getAll(user.getEmail());
	}
}
