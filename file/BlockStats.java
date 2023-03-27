package simpledb.file;

import java.util.HashMap;
import java.util.Map;

public class BlockStats {

    private int totalReadBlocks;
    private int totalWrittenBlocks;
    private Map<String, Integer> readBlocksPerFile;
    private Map<String, Integer> writtenBlocksPerFile;


    public BlockStats() {
        this.totalReadBlocks = 0;
        this.totalWrittenBlocks = 0;

        this.readBlocksPerFile = new HashMap<>();
        this.writtenBlocksPerFile = new HashMap<>();
    }

    public String toString() {
        return "Block stats: total read blocks=" + totalReadBlocks + " - "
                + "total written blocks=" + totalWrittenBlocks + "\n"
                + "Block reads per file: " + readBlocksPerFile.toString() + "\n"
                + "Block writes per file: " + writtenBlocksPerFile.toString() + "\n";
    }

    public void logReadBlock(BlockId block) {
        this.totalReadBlocks += 1;
        Integer reads = this.readBlocksPerFile.get(block.number());
        if (reads == null) {
            this.readBlocksPerFile.put(block.fileName(), 1);
        }
        else {
            this.readBlocksPerFile.put(block.fileName(), reads+1);
        }
    }

    public void logWrittenBlock(BlockId block) {
        this.totalWrittenBlocks += 1;
        Integer writes = this.writtenBlocksPerFile.get(block.number());
        if (writes == null) {
            this.writtenBlocksPerFile.put(block.fileName(), 1);
        }
        else {
            this.writtenBlocksPerFile.put(block.fileName(), writes+1);
        }
    }

    public void reset() {
        this.totalReadBlocks = 0;
        this.totalWrittenBlocks = 0;
        this.readBlocksPerFile = new HashMap<>();
        this.writtenBlocksPerFile = new HashMap<>();
    }
}
