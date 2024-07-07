package com.accountservice.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAccountRepository implements AccountRepository {

    @Autowired
    private SpringDataAccountRepository springDataAccountRepository;

    @Override
    public List<Account> findAll() {
        return springDataAccountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return springDataAccountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return springDataAccountRepository.save(account);
    }

    @Override
    public void deleteById(Long id) {
        springDataAccountRepository.deleteById(id);
    }

    @Override
    public List<Account> findByCustomerId(Long customerId) {
        return springDataAccountRepository.findAll().stream().filter(account -> account.getCustomerId().equals(customerId)).toList();
    }
}