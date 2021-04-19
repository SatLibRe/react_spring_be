package com.example.codeengine.expense.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@Table(name="category")
@Data
public class Category {
	
	@Id
	private Long id;
	
	@NonNull
	private String name;
	
	
	
}
