package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Plan;



public interface PlanService {
	
 public Map<Integer, String> getCategory();	
 
 public boolean savePlan(Plan plan);
 
 public List<Plan> getallplans();
	
 public Plan getplanbyid(Integer id);
 
 public boolean updatePlan(Plan plan);
 
 public boolean deleteplan(Integer id);
 
 public boolean activeSwitch(Integer id, String sw);
 
}
