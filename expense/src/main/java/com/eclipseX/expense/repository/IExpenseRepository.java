package com.eclipseX.expense.repository;

import com.eclipseX.expense.model.Expense;
import java.util.List;
import java.util.Optional;

public interface IExpenseRepository {
    List<Expense> findAll();
    Optional<Expense> findById(Long id);
    Expense save(Expense expense);
    void deleteById(Long id);
}