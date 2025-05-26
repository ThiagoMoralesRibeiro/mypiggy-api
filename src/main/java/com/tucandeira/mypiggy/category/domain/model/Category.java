package com.tucandeira.mypiggy.category.domain.model;

import java.time.LocalDate;



public class Category {
  private Long id;
	private String name;
	private String description;

  public Category(){}
	
	public Category(String name, String description) {
	  this.setName(name);
    this.setDescription(description);
  }

  public void setName(String name){
    this.name = name;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public String getName(){
    return name;
  }

  public String getDescription(){
    return description;
  }

  public Long getId(){
    return id;
  }

  public void setId(Long id){
    this.id = id;
  }

}
