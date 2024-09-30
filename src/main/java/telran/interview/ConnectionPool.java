package telran.interview;

import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

public class ConnectionPool {
    // TODO work out data structure
    // Connection pool comprises of some number of connections
    // It canot contains more than the predefined number of connection
    // You should define some Connection Pool policy so that if number of
    // connections
    // is going to exceed the limit a connection should be removed from the
    // connection
    // Policy should take in consideration the order of adding connections in pool
    // and using connection

    LinkedHashMap<String, Connection> pool;

    public ConnectionPool(int size) {
        initPool(size);
    }

    private void initPool(int size) {
        pool = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<String, Connection> eldest) {
                return size() > size;
            }
        };
    }

    public void addConnection(Connection connection) {
        if (pool.containsKey(connection.connectionId())) {
            throw new IllegalStateException();
        }
        pool.put(connection.connectionId(), connection);
    }

    public Connection getConnection(String connectionId) {
        // TODO
        // If connection with a given ID doesn't exist the NoSuchElementException should
        // be thrown
        if (!pool.containsKey(connectionId)) {
            throw new NoSuchElementException();
        }

        return pool.get(connectionId);
    }
}
