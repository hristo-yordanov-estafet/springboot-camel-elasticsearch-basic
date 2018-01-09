package example.model;

import java.util.List;

public class Batch {

    private final long batchId;
    private final List<String> subscribers;

    public Batch(long batchId, List<String> subscribers) {
        this.batchId = batchId;
        this.subscribers = subscribers;
    }

	public long getBatchId() {
		return batchId;
	}

	public List<String> getSubscribers() {
		return subscribers;
	}
}
