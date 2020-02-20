package com.statemachine.service;

import com.statemachine.dto.LoginDto;
import com.statemachine.dto.LoginResponseDto;
import com.statemachine.exception.UserNotFoundException;

public interface UserService {

	LoginResponseDto usersLogin(LoginDto loginDto) throws UserNotFoundException ;
}
