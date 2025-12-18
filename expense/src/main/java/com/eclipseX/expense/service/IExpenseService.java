package com.eclipseX.expense.service;

import com.eclipseX.expense.model.Expense;
import java.util.List;
import java.util.Optional;

public interface IExpenseService {
    List<Expense> getAllExpenses();
    Optional<Expense> getExpenseById(Long id);
    Expense saveExpense(Expense expense);
    void deleteExpense(Long id);
}