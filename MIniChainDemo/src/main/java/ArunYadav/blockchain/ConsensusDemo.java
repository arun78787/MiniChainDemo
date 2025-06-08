package ArunYadav.blockchain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ConsensusDemo {
    public static void main(String[] args) {
        Random r = new Random();

        // PoW: highest mining power
        Map<String, Integer> pow = new HashMap<>();
        pow.put("MinerA", r.nextInt(100));
        pow.put("MinerB", r.nextInt(100));
        String powWinner = pow.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
        System.out.println("PoW winner: " + powWinner + " (power=" + pow.get(powWinner) + ")");

        // PoS: highest stake
        Map<String, Integer> pos = new HashMap<>();
        pos.put("StakerA", r.nextInt(100));
        pos.put("StakerB", r.nextInt(100));
        String posWinner = pos.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
        System.out.println("PoS winner: " + posWinner + " (stake=" + pos.get(posWinner) + ")");

        // DPoS: most votes
        Map<String, Integer> votes = new HashMap<>();
        votes.put("DelegateA", r.nextInt(50) + 1);
        votes.put("DelegateB", r.nextInt(50) + 1);
        String dposWinner = votes.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
        System.out.println("DPoS winner: " + dposWinner + " (votes=" + votes.get(dposWinner) + ")");
    }
}
