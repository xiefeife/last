package com.tomlive.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 产品信息实体�?
 *  @author Xie
 *  @date2020�?4�?20�?
 */
public class ProductInfo {
    private Integer id;

	private String photo;

	private String name;

	private User user;

	private Date creationTime;

	private Integer sort;

	private String specification;

	private Integer status;

	private ProductType productTypeId;

	private String context;

     //产品特点
	private  String productTrait;
	//技术参数
	private  String productParameters;
	//外观尺寸
	private  String productExternal;
	//订货须知
	private  String productOrder;
	//注意事项
	private  String productAttention;
	

	
	
	public String getProductTrait() {
		return productTrait;
	}

	public void setProductTrait(String productTrait) {
		this.productTrait = productTrait;
	}

	public String getProductParameters() {
		return productParameters;
	}

	public void setProductParameters(String productParameters) {
		this.productParameters = productParameters;
	}

	public String getProductExternal() {
		return productExternal;
	}

	public void setProductExternal(String productExternal) {
		this.productExternal = productExternal;
	}

	public String getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(String productOrder) {
		this.productOrder = productOrder;
	}

	public String getProductAttention() {
		return productAttention;
	}

	public void setProductAttention(String productAttention) {
		this.productAttention = productAttention;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
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
		this.specification = specification == null ? null : specification.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}



	

	

	public ProductType getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(ProductType productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context == null ? null : context.trim();
	}





   

	
    
}