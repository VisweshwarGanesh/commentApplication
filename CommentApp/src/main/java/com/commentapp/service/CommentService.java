package com.commentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commentapp.entity.CredentialsEntity;
import com.commentapp.entity.UserEntity;
import com.commentapp.repository.CommentJPARepository;

@Service
public class CommentService {
	@Autowired
	private CommentJPARepository repo;
	public Integer saveComment(UserEntity comment) {
		return repo.save(comment).getCommentId();
	}
	public List<UserEntity> showAllComments() {
		return repo.findAll();
	}
	public List<UserEntity> findCommentsByCred(CredentialsEntity cred){
		return repo.findByCred(cred);
	}
	
}
