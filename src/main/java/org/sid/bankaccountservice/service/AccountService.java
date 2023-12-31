package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.dto.BankAccountRequestDTO;

public interface AccountService {
     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
}
