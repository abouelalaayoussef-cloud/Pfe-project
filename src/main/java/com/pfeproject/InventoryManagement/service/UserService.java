package com.pfeproject.InventoryManagement.service;

import com.pfeproject.InventoryManagement.dto.LoginRequest;
import com.pfeproject.InventoryManagement.dto.RegisterRequest;
import com.pfeproject.InventoryManagement.dto.Response;
import com.pfeproject.InventoryManagement.dto.UserDTO;
import com.pfeproject.InventoryManagement.entity.User;

public interface UserService {
    Response registerUser(RegisterRequest registerRequest);
    Response loginUser(LoginRequest loginRequest);
    Response getAllUsers();
    User getCurrentLoggedInUser();
    Response updateUser(Long id, UserDTO userDTO);
    Response deleteUser(Long id);
    Response getUserTransactions(Long id);
}
