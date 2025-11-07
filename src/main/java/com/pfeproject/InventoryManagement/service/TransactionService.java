package com.pfeproject.InventoryManagement.service;

import com.pfeproject.InventoryManagement.dto.Response;
import com.pfeproject.InventoryManagement.dto.TransactionRequest;
import com.pfeproject.InventoryManagement.enums.TransactionStatus;

public interface TransactionService {
    Response restockInventory(TransactionRequest transactionRequest);
    Response sell(TransactionRequest transactionRequest);
    Response returnToSupplier(TransactionRequest transactionRequest);
    Response getAllTransactions(int page, int size, String searchText);
    Response getTransactionById(Long id);
    Response getAllTransactionByMonthAndYear(int month, int year);
    Response updateTransactionStatus(Long transactionId, TransactionStatus transactionStatus);

    Response getTransactionsByUser(Long userId, int page, int size, String searchText);



    Long getUserIdByEmail(String email);
}
