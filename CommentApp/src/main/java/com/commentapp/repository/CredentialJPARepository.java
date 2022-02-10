package com.commentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commentapp.entity.CredentialsEntity;

public interface CredentialJPARepository extends JpaRepository<CredentialsEntity, String> {
	public CredentialsEntity findByEmailAndPassword(String email,String password);
	public CredentialsEntity findByEmailAndSecret(String email,String secret);
}
