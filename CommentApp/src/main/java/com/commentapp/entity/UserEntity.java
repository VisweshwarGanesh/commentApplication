package com.commentapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="user_comments")
public class UserEntity {
	@Override
	public String toString() {
		return "UserEntity [commentId=" + commentId + ", cred=" + cred + ", comment=" + comment + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	@ManyToOne
	private CredentialsEntity cred;
	private String comment;
	public CredentialsEntity getCred() {
		return cred;
	}
	public void setCred(CredentialsEntity cred) {
		this.cred = cred;
	}
	
	public UserEntity() {
		
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}


	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
