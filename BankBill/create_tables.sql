CREATE TABLE IF NOT EXISTS clients (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    account_number VARCHAR(20) UNIQUE NOT NULL,
    balance DECIMAL(15,2) DEFAULT 0,
    client_type VARCHAR(10) NOT NULL,
    welcome_bonus_used BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS transactions (
    id SERIAL PRIMARY KEY,
    from_account VARCHAR(20) REFERENCES clients(account_number),
    to_account VARCHAR(20) REFERENCES clients(account_number),
    amount DECIMAL(15,2) NOT NULL,
    transaction_type VARCHAR(20) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
); 