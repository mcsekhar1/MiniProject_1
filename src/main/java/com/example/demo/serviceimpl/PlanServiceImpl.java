package com.example.demo.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Plan;
import com.example.demo.entity.Plan_category;
import com.example.demo.repo.PlanCategoryRepo;
import com.example.demo.repo.PlanRepo;
import com.example.demo.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService{

	@Autowired
	private PlanRepo prepo;
	
	@Autowired
	private PlanCategoryRepo crepo;


	
	@Override
	public Map<Integer, String> getCategory() {
			List<Plan_category> categories = crepo.findAll();
			Map<Integer, String> categorymap = new HashMap<>();
			categories.forEach(category->{
			categorymap.put(category.getCategoryID(), category.getCategoryName());
		});
		return categorymap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan save = prepo.save(plan);
		return save.getPlanId()!=null;
	}

	@Override
	public List<Plan> getallplans() {
		return prepo.findAll();
	}

	@Override
	public Plan getplanbyid(Integer id) {
		
		Optional<Plan> opt = prepo.findById(id);
		
		if(opt.isPresent()) {
		return opt.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		prepo.save(plan);
		return plan.getPlanId()!=null;
	}

	@Override
	public boolean deleteplan(Integer id) {
		
		
		boolean status = false;
		
		try {
			
			prepo.deleteById(id);
			status=true;
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
			return status;
		}

	@Override
	public boolean activeSwitch(Integer id, String sw) {
		Optional<Plan> findById = prepo.findById(id);
		
		if(findById.isPresent()) {
			
			Plan plan = findById.get();
			plan.setAcSwitch(sw);
			prepo.save(plan);
			return true;
		}	
		return false;
	}

}
