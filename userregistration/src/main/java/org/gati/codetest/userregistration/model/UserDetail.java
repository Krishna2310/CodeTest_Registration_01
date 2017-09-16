package org.gati.codetest.userregistration.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gati.codetest.userregistration.model.Link;

public class UserDetail {
	
	private long userid;
	private String name;
	private Date created;
	private String email;
	private long pincode;
	private List<Link> links = new ArrayList<>();
		
	public UserDetail() {
		
	}
	
	

	public UserDetail(long userid,String name,String email,long pincode) {
		
		this.userid=userid;
		this.name=name;
		this.created=new Date();
		this.email=email;
		this.pincode=pincode;
		
	}
	
	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(String url,String rel) {
		Link link =new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
	
}
