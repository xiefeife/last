package com.tomlive.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 产品信息实体类
 *  @author Xie
 *  @date2020年4月20日
 */
/*
 * @Data
 * 
 * @NoArgsConstructor
 */
public class ProductInfo {
    private Integer id;

    private String photo;

    private String name;

    private User user;

    private Date creationTime;

    /**
     * 排序
     */
    private Integer sort;

    private String specification;

    private String context;

    private String productType;

    private Integer status;



	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", photo=" + photo + ", name=" + name + ", user=" + user + ", creationTime="
				+ creationTime + ", sort=" + sort + ", specification=" + specification + ", context=" + context
				+ ", productType=" + productType + ", status=" + status + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ProductInfo() {
		super();
	}


    
}