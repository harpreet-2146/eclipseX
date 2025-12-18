package com.eclipseX.expense.service;

import com.eclipseX.expense.model.Expense;
import com.eclipseX.expense.repository.IExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService implements IExpenseService {

    private final IExpenseRepository expenseRepository;

    public ExpenseService(IExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}