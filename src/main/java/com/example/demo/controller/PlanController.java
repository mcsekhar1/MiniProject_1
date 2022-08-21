package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Plan;
import com.example.demo.serviceimpl.PlanServiceImpl;



@RestController
public class PlanController {

	@Autowired
	private PlanServiceImpl planservice;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> getcategories(){
		
		Map<Integer, String> categories = planservice.getCategory();
		
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	
	@PostMapping("/saveplan")
	public ResponseEntity<String> saveplan(@RequestBody Plan plan){
		
		boolean save = planservice.savePlan(plan);
		String msg ="";
		if(save) {	
			msg="Plan is created";
		}
		else {
			msg="Plan is not created";
		}
		return new ResponseEntity<>(msg, HttpStatus.CREATED);		
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		List<Plan> plans = planservice.getallplans();
		
		return new ResponseEntity<>(plans, HttpStatus.OK);
		
	}
	
}
