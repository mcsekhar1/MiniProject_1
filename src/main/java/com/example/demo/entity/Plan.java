package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="PLAN")
public class Plan {
	
	@Id
	@GeneratedValue
	@Column(name="PLAN_ID")
	private Integer PlanId;
	
	@Column(name="PLAN_NAME")
	private String PlanName;
	
	@Column(name="PLAN_CATEGORY_ID")
	private Integer PlanCategoryId;
	
	@Column(name="PLAN_START_DATE")
	private LocalDate PlanStartDate;
	
	@Column(name="PLAN_END_DATE")
	private LocalDate PlanEndDate;
		
	@Column(name="ACTIVE_SWITCH")
	private String AcSwitch;
	
	@Column(name="CREATED_BY")
	private String CreatedBy;
	
	@Column(name="UPDATED_BY")
	private String UpdatedBy;
	
	@Column(name="CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate CreatedDate;
	
	@Column(name="UPDATE_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate UpdateDate;
}
