package telran.interview;

public record Connection(String connectionId) {
    @Override
    public final boolean equals(Object obj) {
        return ((Connection) obj).connectionId == connectionId;
    }
}