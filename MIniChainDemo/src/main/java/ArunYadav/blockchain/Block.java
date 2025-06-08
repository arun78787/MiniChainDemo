package ArunYadav.blockchain;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Block {
    private final int index;
    private final String timestamp;
    private String data;
    private final String previousHash;
    private String hash;
    private int nonce;

    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
        this.nonce = 0;
    }

    public String calculateHash() {
        try {
            String input = index + timestamp + data + previousHash + nonce;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(input.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        long start = System.currentTimeMillis();
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println("Block " + index + " mined in " + timeTaken + " ms");
        System.out.println("  nonce: " + nonce + ", hash: " + hash);
    }

    public String getHash()      { return hash; }
    public String getPrevHash()  { return previousHash; }
    public void setData(String d){ data = d; hash = calculateHash(); }

    @Override
    public String toString() {
        return "Block " + index +
                " [prevHash=" + previousHash +
                ", hash=" + hash +
                ", data=" + data + "]";
    }
}
