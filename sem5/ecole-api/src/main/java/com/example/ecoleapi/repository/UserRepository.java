package com.example.ecoleapi.repository;

import com.example.ecoleapi.dto.User;

import java.util.List;

public interface UserRepository {
	User findByLogin(String username);
}