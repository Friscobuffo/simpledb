package simpledb.buffer.strategy;

import simpledb.buffer.Buffer;

public class Naive implements Strategy{
    @Override
    public Buffer chooseUnpinned(Buffer[] bufferpool) {
        for (Buffer buff : bufferpool)
            if (!buff.isPinned())
                return buff;
        return null;
    }
}
