package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer>{

}
