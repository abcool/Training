CREATE TABLE IF NOT EXISTS reviews (
                                       id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                       version INT NOT NULL,
                                       product_id INT NOT NULL,
                                       review_id INT NOT NULL,
                                       author VARCHAR(255),
    subject VARCHAR(255),
    content TEXT,
    UNIQUE INDEX reviews_unique_idx (product_id, review_id)
    ) ENGINE=InnoDB;