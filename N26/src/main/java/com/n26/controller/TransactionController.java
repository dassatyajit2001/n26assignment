package com.n26.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.n26.processor.TransactionProcessor;



@RestController
public class TransactionController {

	@Autowired
	TransactionProcessor processor;

	@RequestMapping(value = "/transactions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity addTransaction(@RequestBody Map<String, String> bean) {
		processor.addTransaction(bean);
		return new ResponseEntity<>(processor.addTransaction(bean));
	}
	

	@RequestMapping(value = "/transactions", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity deleteTransaction() {
		return new ResponseEntity<>(processor.deleteTransaction());
	}

	@RequestMapping(value = "/statistics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity getStats() {
		return new ResponseEntity<>(processor.getStats(),HttpStatus.OK);
	}

}