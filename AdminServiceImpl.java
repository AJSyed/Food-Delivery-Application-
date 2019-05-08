package com.bhook.ordermanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhook.ordermanagement.dao.AdminDao;
import com.bhook.ordermanagement.model.Admin;



@Service
public class AdminServiceImpl implements AdminService{

	  @Autowired
	  AdminDao adminDao;
	@Transactional
	public void saveAdmin(Admin admin) {
	  adminDao.saveAdmin(admin);	
		
	}

	@Transactional
	public List<Admin> adminList() {
		
		return adminDao.adminList();
	}
	public String checkAdminCredentials(Admin admin) {
		return adminDao.checkAdminCredentials(admin);
	}

	


}
