CREATE TABLE IF NOT EXISTS expenses (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        title VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    category VARCHAR(100),
    date DATE,
    description VARCHAR(500)
    );