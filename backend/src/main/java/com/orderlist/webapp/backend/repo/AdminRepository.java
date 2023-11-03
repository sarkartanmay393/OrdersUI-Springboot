package com.orderlist.webapp.backend.repo;

import org.springframework.data.repository.CrudRepository;

import com.orderlist.webapp.backend.models.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {

}
