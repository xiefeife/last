package com.tomlive.entity;

import java.util.Date;

public class PressCenter {
    private Integer id;

    private String photo;

    private String title;

    private Integer userId;

    private Date creationTime;

    private String particulars;

    private PressSort presssort;

    public PressSort getPresssort() {
		return presssort;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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