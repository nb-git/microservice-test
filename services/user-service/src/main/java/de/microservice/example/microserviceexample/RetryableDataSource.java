package de.microservice.example.microserviceexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Configuration wie oft und in welchem Abstand der Verbindungsaufbau zur Datenbank versucht werden soll.
 */
public class RetryableDataSource extends AbstractDataSource {

    Logger LOGGER = LoggerFactory.getLogger(RetryableDataSource.class);

    private DataSource delegate;

    RetryableDataSource(DataSource delegate) {
        this.delegate = delegate;
    }

    /**
     * Maximal 10 Versuche eine SQL Verbindung aufzubauen, die Versuche werden in einem Abstand von x
     * und einem maximalem Abstand von 30000 Millisekunden ausgeführt.
     */
    @Override
    @Retryable(maxAttempts = 10, backoff = @Backoff(multiplier = 2.3, maxDelay = 30000))
    public Connection getConnection() throws SQLException {
        return delegate.getConnection();
    }

    /**
     * Maximal 10 Versuche eine SQL Verbindung aufzubauen, die Versuche werden in einem Abstand von x
     * und einem maximalem Abstand von 30000 Millisekunden ausgeführt.
     */
    @Override
    @Retryable(maxAttempts = 10, backoff = @Backoff(multiplier = 2.3, maxDelay = 30000))
    public Connection getConnection(String username, String password)
            throws SQLException {
        return delegate.getConnection(username, password);
    }
}
