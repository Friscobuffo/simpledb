package simpledb.buffer.strategy;

import simpledb.buffer.Buffer;

public class Clock implements Strategy{
    private int lastChosenPosition=-1;
    @Override
    public Buffer chooseUnpinned(Buffer[] bufferpool) {
        for (int i = lastChosenPosition+1; i<bufferpool.length+lastChosenPosition+1; i++) {
            Buffer buffer = bufferpool[i%bufferpool.length];
            if (!buffer.isPinned()) {
                this.lastChosenPosition = i % bufferpool.length;
                return buffer;
            }
        }
        return null;
    }
}
