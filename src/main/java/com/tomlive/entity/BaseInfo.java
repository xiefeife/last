package com.tomlive.entity;

import java.util.Date;

public class BaseInfo {
    private Integer id;

    private String companyName;

    private String phone;

    private String email;

    private String busRoute;
   private  String companyAptitude;
   private  String address;
   private Date creationTime;
   
   private  String companyProfile; 
   private  String companyVision; 
   private  String companyPhilosophy; 
   private  String companyDevelopment; 
   private  String  enterpriseCulture;
   
   
   
    public String getEnterpriseCulture() {
	return enterpriseCulture;
}

public void setEnterpriseCulture(String enterpriseCulture) {
	this.enterpriseCulture = enterpriseCulture;
}

	public String getCompanyProfile() {
	return companyProfile;
}

public void setCompanyProfile(String companyProfile) {
	this.companyProfile = companyProfile;
}

public String getCompanyVision() {
	return companyVision;
}

public void setCompanyVision(String companyVision) {
	this.companyVision = companyVision;
}

public String getCompanyPhilosophy() {
	return companyPhilosophy;
}

public void setCompanyPhilosophy(String companyPhilosophy) {
	this.companyPhilosophy = companyPhilosophy;
}

public String getCompanyDevelopment() {
	return companyDevelopment;
}

public void setCompanyDevelopment(String companyDevelopment) {
	this.companyDevelopment = companyDevelopment;
}

	public String getCompanyAptitude() {
	return companyAptitude;
}

public void setCompanyAptitude(String companyAptitude) {
	this.companyAptitude = companyAptitude;
}


    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute == null ? null : busRoute.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}