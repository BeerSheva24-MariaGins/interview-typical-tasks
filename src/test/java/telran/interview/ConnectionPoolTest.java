package telran.interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionPoolTest {
    private ConnectionPool connectionPool;
    private Connection connection;

    @BeforeEach
    void setUp() {
        connectionPool = new ConnectionPool(3);
        connection = new Connection("1");
        connectionPool.addConnection(connection);
        assertThrows(IllegalStateException.class, () -> connectionPool.addConnection(connection));
    }

    @Test
    void addConnectionTest() {
        ConnectionPool connectionPool = new ConnectionPool(3);
        Connection connection1 = new Connection("conn1");
        Connection connection2 = new Connection("conn2");

        connectionPool.addConnection(connection1);
        connectionPool.addConnection(connection2);

        assertEquals(connection1, connectionPool.getConnection("conn1"));
        assertEquals(connection2, connectionPool.getConnection("conn2"));
    }

    @Test
    void getNonExistentConnectionTest() {
        assertThrows(NoSuchElementException.class, () -> connectionPool.getConnection("nonexistent"));
    }

    @Test
    void maxSizeTest() {
        ConnectionPool connectionPool = new ConnectionPool(2);
        Connection connection1 = new Connection("conn1");
        Connection connection2 = new Connection("conn2");
        Connection connection3 = new Connection("conn3");

        connectionPool.addConnection(connection1);
        connectionPool.addConnection(connection2);
        connectionPool.addConnection(connection3);

        assertThrows(NoSuchElementException.class, () -> connectionPool.getConnection("1"));
        assertEquals(connection2, connectionPool.getConnection("conn2"));
        assertEquals(connection3, connectionPool.getConnection("conn3"));
    }
}
