package com.Henafam.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Feedback")
public class HenaFeedback {
	
	@Id
	private String feedbackId;
	private String email;
	private String userId;
	private String productId;
	private String feedback;
	private Date feedbackDate;
	private double ratting;
	private String poultryId;

	
	
	
	public HenaFeedback(String feedbackId,String email, String userId, String productId, String feedback, Date feedbackDate,double ratting,String poultryId) {
		super();
		this.feedbackId = feedbackId;
		this.userId = userId;
		this.email = email;
		this.productId = productId;
		this.feedback = feedback;
		this.feedbackDate = feedbackDate;
		this.ratting=ratting;
		this.poultryId=poultryId;

	}


	public String getFeedbackId() {
		return feedbackId;
	}


	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public Date getFeedbackDate() {
		return feedbackDate;
	}


	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getRatting() {
		return ratting;
	}


	public void setRatting(double ratting) {
		this.ratting = ratting;
	}


	public String getPoultryId() {
		return poultryId;
	}


	public void setPoultryId(String poultryId) {
		this.poultryId = poultryId;
	}


	@Override
	public String toString() {
		return "HenaFeedback [feedbackId=" + feedbackId + ", email=" + email + ", userId=" + userId + ", productId="
				+ productId + ", feedback=" + feedback + ", feedbackDate=" + feedbackDate + ", ratting=" + ratting
				+ ", poultryId=" + poultryId + "]";
	}




	
	
	
}
