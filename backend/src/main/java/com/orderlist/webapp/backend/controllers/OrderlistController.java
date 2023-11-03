package com.orderlist.webapp.backend.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderlist.webapp.backend.models.Order;

@RestController
@RequestMapping("/orders")
public class OrderlistController {

  public List<Order> OrderList;

  public OrderlistController() {
  }

  @Value("classpath:DummyData.json")
  Resource resource;

  private List createJsonToObject() throws IOException {
    File file = resource.getFile();
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(file, List.class);
  }

  @GetMapping(produces = "application/json")
  public List<Order> getOrders() {
    if (OrderList == null) {
      try {
        OrderList = createJsonToObject();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return OrderList;
  }

}
