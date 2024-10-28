package telran.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ConnectionPool {
    private LinkedHashMap<String, Connection> connectionsMap;

    public ConnectionPool(int size) {
        connectionsMap = new LinkedHashMap<>(size * 2, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Connection> eldestEntry) {
                return size() > size;
            }
        };
    }

    public void addConnection(Connection connection) {
        String id = connection.connectionId();
        if (connectionsMap.containsKey(id)) {
            throw new IllegalStateException();
        }
        connectionsMap.put(id, connection);
    }

    public Connection getConnection(String connectionId) {
        if (!connectionsMap.containsKey(connectionId)) {
            throw new NoSuchElementException();
        }

        return connectionsMap.get(connectionId);
    }
}
