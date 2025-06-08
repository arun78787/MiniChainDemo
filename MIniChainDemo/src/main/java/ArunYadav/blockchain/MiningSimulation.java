package ArunYadav.blockchain;

public class MiningSimulation {
    public static void main(String[] args) {
        Block block = new Block(1, "Some transaction data", "0");
        // Difficulty = number of leading zeros
        block.mineBlock(4);
    }
}
