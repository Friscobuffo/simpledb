package simpledb.buffer.strategy;

import simpledb.buffer.Buffer;

public class Lru implements Strategy{
    @Override
    public Buffer chooseUnpinned(Buffer[] bufferpool) {
        Buffer buffer = null;
        long minTimestamp = Long.MAX_VALUE;
        for (Buffer buff : bufferpool)
            if (!buff.isPinned()) {
                if (buff.getUnpinTime() < minTimestamp) {
                    buffer = buff;
                    minTimestamp = buffer.getUnpinTime();
                }
            }
        return buffer;
    }
}
