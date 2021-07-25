package habeeb.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import habeeb.news.dao.HistoryDao;
import habeeb.news.models.News;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

	@Autowired
	HistoryDao dao;
	
	@PostMapping(value="/add",produces="application/json")
	public void history(@RequestBody News news) {
		dao.addHistory(news);
	}
	
	//dummy below
	@PostMapping(value="/dummy",produces="application/json")
	public void history3(@RequestBody News news) {
		dao.blah();
	}
}
