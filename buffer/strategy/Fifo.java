package simpledb.buffer.strategy;

import simpledb.buffer.Buffer;

public class Fifo implements Strategy{
    @Override
    public Buffer chooseUnpinned(Buffer[] bufferpool) {
        Buffer buffer = null;
        long minTimestamp = Long.MAX_VALUE;
        for (Buffer buff : bufferpool)
            if (!buff.isPinned()) {
                if (buff.getLoadTime() < minTimestamp) {
                    buffer = buff;
                    minTimestamp = buffer.getLoadTime();
                }
            }
        return buffer;
    }
}
