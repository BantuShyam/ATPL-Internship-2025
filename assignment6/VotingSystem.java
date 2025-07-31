
import java.util.HashMap;

public class VotingSystem{
    public static void main(String[] args) {
        HashMap<String, Integer> votes = new HashMap<>();
        votes.put("Shyam",votes.getOrDefault("Shyam",0)+ 267);
        votes.put("Balaram",votes.getOrDefault("Balaram",0)+ 289);
        votes.put("Jaya",votes.getOrDefault("Jaya",0)+ 243);
        votes.put("Shyam",votes.getOrDefault("Shyam",0)+ 267);
        votes.put("Akbar",votes.getOrDefault("Akbar",0)+ 359);
        String winner = null;
        int maxVotes = 0;
        for (String candidate : votes.keySet()) {
            int voteCount = votes.get(candidate);
            if (voteCount > maxVotes) {
                maxVotes = voteCount;
                winner = candidate;
            }
        }
        System.out.println("Votes received by each candidate:");
        for (String candidate : votes.keySet()) {
            System.out.println(candidate + ": " + votes.get(candidate) + " votes");
        }
        System.out.println("Winner of the election is: " + winner + " with " + maxVotes + " votes.");
    }
}