package com.commentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commentapp.entity.CredentialsEntity;
import com.commentapp.repository.CredentialJPARepository;

@Service
public class CredentialService {
	@Autowired
	private CredentialJPARepository credRepo;
	
	public CredentialsEntity getCredentials(CredentialsEntity creds) {
		CredentialsEntity ce = credRepo.findByEmailAndPassword(creds.getEmail(), creds.getPassword());
		return ce;
	}
	public String addUser(CredentialsEntity cred) {
		return credRepo.save(cred).getEmail();
	}
	public CredentialsEntity resetPassword(CredentialsEntity cred) {
		return credRepo.findByEmailAndSecret(cred.getEmail(), cred.getSecret());
	}
}
