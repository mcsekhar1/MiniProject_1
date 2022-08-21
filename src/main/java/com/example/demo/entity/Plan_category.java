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
@Table(name="PLAN_CATEGORY")
public class Plan_category {

	@Id
	@GeneratedValue
	@Column(name="CAEGORY_ID")
	private Integer CategoryID;
	
	@Column(name="CATEGORY_NAME")
	private String CategoryName;
	
	@Column(name="AUTO_SWITCH")
	private String Autoswitch;
	
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
