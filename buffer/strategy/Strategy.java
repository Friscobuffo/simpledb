package simpledb.buffer.strategy;

import simpledb.buffer.Buffer;

public interface Strategy {
    public Buffer chooseUnpinned(Buffer[] bufferpool);
}
