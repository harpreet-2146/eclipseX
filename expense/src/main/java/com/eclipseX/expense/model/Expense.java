package com.eclipseX.expense.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense extends BaseEntity {
    private String title;
    private BigDecimal amount;
    private String category;
    private LocalDate date;
    private String description;

    public Expense() {}

    public Expense(Long id, String title, BigDecimal amount, String category, LocalDate date, String description) {
        setId(id);  // inherited from BaseEntity
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // Getters and Setters (only for Expense-specific fields)
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}