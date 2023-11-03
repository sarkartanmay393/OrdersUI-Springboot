package com.orderlist.webapp.backend.controllers;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderlist.webapp.backend.models.Admin;
import com.orderlist.webapp.backend.repo.AdminRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

  @Autowired
  private AdminRepository adminRepository;

  @PostMapping(path = "/signup")
  public @ResponseBody boolean signUp(@RequestBody Map<String, String> reqBody) {
    String email = reqBody.get("email");
    Admin admin = new Admin();
    adminRepository.findAll().forEach(ad -> {
      if (ad.getEmail() == email) {
        return;
      }
    });
    admin.setEmail(email);
    adminRepository.save(admin);
    return true;
  }

  @GetMapping(path = "/all")
  public @ResponseBody Iterable<Admin> getAllAdmins() {
    return adminRepository.findAll();
  }

  @PostMapping(path = "/login")
  public @ResponseBody boolean allowLogin(@RequestBody Map<String, String> requestBody) {
    String em = requestBody.get("email");
    boolean needToSignup = !adminRepository.existsById(em);
    return !needToSignup && true;
  }

}
