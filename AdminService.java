package com.bhook.ordermanagement.service;
import java.util.List;

import com.bhook.ordermanagement.model.Admin;






public interface AdminService {
	
public void saveAdmin(Admin admin);
	
	public List<Admin> adminList();
	
	public String checkAdminCredentials(Admin admin);
	

}


