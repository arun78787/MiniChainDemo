package ArunYadav.blockchain;

public class BlockchainSimulation {
    public static void main(String[] args) {
        // Create chain
        Block genesis = new Block(0, "Genesis Block", "0");
        Block b1 = new Block(1, "Block 1 Data", genesis.getHash());
        Block b2 = new Block(2, "Block 2 Data", b1.getHash());

        System.out.println(genesis);
        System.out.println(b1);
        System.out.println(b2);

        // Tamper with Block 1
        b1.setData("Tampered Data!");
        System.out.println("\nAfter tampering Block 1:");
        System.out.println(genesis);
        System.out.println(b1);
        System.out.println(b2);
    }
}
