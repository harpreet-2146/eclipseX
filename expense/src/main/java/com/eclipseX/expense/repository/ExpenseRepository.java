package com.eclipseX.expense.repository;

import com.eclipseX.expense.model.Expense;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class ExpenseRepository {

    private final JdbcTemplate jdbcTemplate;

    public ExpenseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Expense> rowMapper = (rs, rowNum) -> {
        Expense expense = new Expense();
        expense.setId(rs.getLong("id"));
        expense.setTitle(rs.getString("title"));
        expense.setAmount(rs.getBigDecimal("amount"));
        expense.setCategory(rs.getString("category"));
        Date date = rs.getDate("date");
        expense.setDate(date != null ? date.toLocalDate() : null);
        expense.setDescription(rs.getString("description"));
        return expense;
    };

    public List<Expense> findAll() {
        return jdbcTemplate.query("SELECT * FROM expenses ORDER BY date DESC", rowMapper);
    }

    public Optional<Expense> findById(Long id) {
        List<Expense> results = jdbcTemplate.query("SELECT * FROM expenses WHERE id = ?", rowMapper, id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    public Expense save(Expense expense) {
        if (expense.getId() == null) {
            return insert(expense);
        } else {
            return update(expense);
        }
    }

    private Expense insert(Expense expense) {
        String sql = "INSERT INTO expenses (title, amount, category, date, description) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, expense.getTitle());
            ps.setBigDecimal(2, expense.getAmount());
            ps.setString(3, expense.getCategory());
            ps.setDate(4, expense.getDate() != null ? Date.valueOf(expense.getDate()) : null);
            ps.setString(5, expense.getDescription());
            return ps;
        }, keyHolder);

        expense.setId(keyHolder.getKey().longValue());
        return expense;
    }

    private Expense update(Expense expense) {
        String sql = "UPDATE expenses SET title = ?, amount = ?, category = ?, date = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                expense.getTitle(),
                expense.getAmount(),
                expense.getCategory(),
                expense.getDate() != null ? Date.valueOf(expense.getDate()) : null,
                expense.getDescription(),
                expense.getId());
        return expense;
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM expenses WHERE id = ?", id);
    }
}