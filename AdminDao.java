package com.bhook.ordermanagement.dao;
import java.util.List;

import com.bhook.ordermanagement.model.Admin;




public interface AdminDao{

	void saveAdmin(Admin admin);
	
	public List<Admin> adminList();

	public String checkAdminCredentials(Admin admin);

/*	public String setAssignDriver(int orderId, String driver);
	public void setOrderIdToDriver(int id, String emailId);
*/
}
