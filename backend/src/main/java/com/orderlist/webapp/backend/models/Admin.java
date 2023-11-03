package com.orderlist.webapp.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  // private Long Id;
  
  @Id
  private String email;

  public Admin() {
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }
}
