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

    private PressSort presssort;
    
    private Integer status;
    

    public PressCenter() {
		super();
	}

	public PressSort getPresssort() {
		return presssort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setPresssort(PressSort presssort) {
		this.presssort = presssort;
	}

	private String content;

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

    
                                                                                 //详情
    public PressCenter(String photo, String title, User user, Date creationTime, String particulars,
			PressSort presssort, Integer status, String content) {
		super();
		this.photo = photo;
		this.title = title;
		this.user = user;
		this.creationTime = creationTime;
		this.particulars = particulars;
		this.presssort = presssort;
		this.status = status;
		this.content = content;
	}

	public User getUser() {
		return user;
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


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}