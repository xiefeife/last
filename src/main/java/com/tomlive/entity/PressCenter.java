package com.tomlive.entity;

import java.util.Date;

public class PressCenter {
	
    private Integer id;

    private String photo;

    private String title;

    /**
     *新闻添加人
     */
    private User user;

    private Date creationTime;

    /**
     * 新闻详情
     */
    private String particulars;

    /**
     * 新闻模块(板块)
     */
    private PressType pressType;
    
    private Integer status;
    

    public PressCenter() {
		super();
	}

	public PressType getPresssort() {
		return pressType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setPresssort(PressType presssort) {
		this.pressType = presssort;
	}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

                                                                                 

	public User getUser() {
		return user;
	}


	public PressCenter(String photo, String title, User user, Date creationTime, String particulars,
			PressType presssort, Integer status) {
		super();
		this.photo = photo;
		this.title = title;
		this.user = user;
		this.creationTime = creationTime;
		this.particulars = particulars;
		this.pressType = pressType;
		this.status = status;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars == null ? null : particulars.trim();
    }



}