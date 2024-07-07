package com.accountservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountservice.client.CustomerServiceClient;
import com.accountservice.dto.AccountReportDTO;
import com.accountservice.dto.AccountStatementReportDTO;
import com.accountservice.dto.CustomerDTO;
import com.accountservice.dto.TransactionReportDTO;
import com.accountservice.exception.InsufficientBalanceException;
import com.accountservice.model.Account;
import com.accountservice.model.AccountRepository;
import com.accountservice.model.Transaction;
import com.accountservice.model.TransactionRepository;
import com.accountservice.model.TransactionType;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CustomerServiceClient customerServiceClient;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public Transaction addTransaction(Long accountId, Transaction transaction) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if(TransactionType.DEPOSITO == transaction.getTransactionType())
        {
            transaction.setBalance(account.getInitialBalance() + transaction.getAmount());
        } else {
            transaction.setBalance(account.getInitialBalance() - transaction.getAmount());
        }

        if (transaction.getBalance()  < 0) {
            throw new InsufficientBalanceException("Saldo no disponible");
        }

        transaction.setDate(LocalDateTime.now());

        account.addTransaction(transaction);

        accountRepository.save(account);
        return transactionRepository.save(transaction);
    }

    public AccountStatementReportDTO generateAccountStatement(Long customerId, LocalDateTime startDate, LocalDateTime endDate) {
        CustomerDTO customer = customerServiceClient.getCustomerById(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        List<AccountReportDTO> accountReportDTOS = accounts.stream().map(account -> {
            List<TransactionReportDTO> transactionReportDTOS = account.getTransactions().stream()
                    .filter(transaction -> transaction.getDate().isAfter(startDate) && transaction.getDate().isBefore(endDate))
                    .map(transaction -> new TransactionReportDTO(
                            transaction.getDate(),
                            transaction.getTransactionType().name(),
                            transaction.getAmount(),
                            transaction.getBalance()))
                    .collect(Collectors.toList());

            return new AccountReportDTO(
                    account.getId(),
                    account.getAccountNumber(),
                    account.getInitialBalance(),
                    transactionReportDTOS);
        }).collect(Collectors.toList());

        return new AccountStatementReportDTO(customerId, accountReportDTOS);
    }
}