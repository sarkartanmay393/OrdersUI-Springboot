package com.orderlist.webapp.backend.models;

public class Order {

  private String Id;
  private String CustomerName;
  private String CustomerEmail;
  private String Product;
  private int quantity;

  public Order(String id, String customerName, String customerEmail, String product, int quantity) {
    this.Id = id;
    this.CustomerName = customerName;
    this.CustomerEmail = customerEmail;
    this.Product = product;
    this.quantity = quantity;
  }

  public Order getOrder() {
    return this;
  }

}
