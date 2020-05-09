package com.tomlive.util;

import java.util.Date;

import com.tomlive.entity.ProductType;
import com.tomlive.entity.User;

public class ProductInfoUtil {
private   Integer  id;
private   String    typeName  ;
private  Integer typeId;
	
	 public Integer getTypeId() {
	return typeId;
}
public void setTypeId(Integer typeId) {
	this.typeId = typeId;
}
	public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTypeName() {
	return typeName;
}
public void setTypeName(String typeName) {
	this.typeName = typeName;
}
	private String name;
	 private Integer productTypeId;
	 private Date beginTime;
	 private Date endTime;
	 private String userName;
		private String photo;
   private  String  realName;

		public String getRealName() {
	return realName;
}
public void setRealName(String realName) {
	this.realName = realName;
}
		private User user;

		private Date creationTime;

		private Integer sort;

		private String specification;

		private Integer status;

		private  String productTrait;
		//技术参数
		private  String productParameters;
		//外观尺寸
		private  String productExternal;
		//订货须知
		private  String productOrder;
		//注意事项
		private  String productAttention;
		private String context;
		
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
	public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
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
			this.specification = specification;
		}
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	 
}
