package org.gati.codetest.userregistration.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.gati.codetest.userregistration.exception.DataNotFoundException;
import org.gati.codetest.userregistration.exception.LoginExpiredException;
import org.gati.codetest.userregistration.database.DatabaseClass;
import org.gati.codetest.userregistration.model.UserDetail;;

public class ResgistrationService {
	
	private Date createdate;
	private Date logindate;
	
	private Map<Long, UserDetail> userdetails = DatabaseClass.getUserDetails();
	
	public ResgistrationService (){
		userdetails.put(1L, new UserDetail(1L,"Hello World","Gati",123456));
		userdetails.put(2L, new UserDetail(2L,"Hello World2","Gati2",456789));
	}
	
	public List<UserDetail> getAllUserDetails() {
		return new ArrayList<UserDetail>(userdetails.values());
	}
	
	public UserDetail addUser(UserDetail userdetail){
		userdetail.setUserid(userdetails.size()+1);
		Date date= new Date();
		userdetail.setCreated(date);
		userdetails.put(userdetail.getUserid(), userdetail);		
		return userdetail;
	}
	
	public UserDetail getMessage(long userid){
		UserDetail userdetail = userdetails.get(userid);		
		if(userdetail==null){
			throw new DataNotFoundException("Invalid User ID : " +userid);
		}else {
			logindate=new Date();
			createdate=userdetail.getCreated();
			long difftime=(logindate.getTime()-createdate.getTime())/60000;
			System.out.println(difftime);
			if(difftime>15){
				throw new LoginExpiredException("Login Expired after 15 Minutes : " +difftime+ "Minutes");
			}
		}
		
		return userdetail;
	}
	

}
