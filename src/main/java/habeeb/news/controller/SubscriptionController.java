package habeeb.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import habeeb.news.dao.SubscriptionDao;
import habeeb.news.models.Subscription;

@RestController
@RequestMapping("/api/category")
public class SubscriptionController {

	@Autowired 
	SubscriptionDao dao;
	
	@PostMapping(value="/subscribe", produces="application/json")
	public void subscribe(@RequestBody Subscription subscription) {
		if(!dao.isSubscribed(subscription)) {
			dao.subscribe(subscription);
		}
	}
	@PostMapping(value="/unSubscribe", produces="application/json")
	public void unSubscribe(@RequestBody Subscription subscription) {
		if(dao.isSubscribed(subscription)) {
			dao.unSubscribe(subscription);
		}
	}
}
