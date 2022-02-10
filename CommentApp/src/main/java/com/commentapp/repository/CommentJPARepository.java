package com.commentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commentapp.entity.CredentialsEntity;
import com.commentapp.entity.UserEntity;

public interface CommentJPARepository extends JpaRepository<UserEntity, Integer> {
	List<UserEntity> findByCred(CredentialsEntity cred);
}
