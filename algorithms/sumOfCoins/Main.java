
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        int coinCount = usedCoins.values().stream().mapToInt(a -> a).sum();

        System.out.println("Number of coins to take: " + coinCount);

        List<Map.Entry<Integer, Integer>> sortedCoinsUsage = usedCoins
                .entrySet()
                .stream()
                .sorted((l, r) -> r.getKey() - l.getKey())
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.printf("%d coin(s) with value %d%n", usedCoin.getValue(), usedCoin.getKey());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        //брой използвани монети
        Map<Integer, Integer> result = new HashMap<>();

        int[] sortedCoins = Arrays.stream(coins)
                .boxed()
                .sorted((l, r) -> r - l)
                .mapToInt(a -> a)
                .toArray();

        while (targetSum > 0) {
            //намираме най-голямата монета
            int largestCoin = 0;
            //1-вата монета която се събира в търсената сума я взимаме
            for (int sortedCoin : sortedCoins) {
                if (sortedCoin <= targetSum) {
                    largestCoin = sortedCoin;
                    break;
                }
            }

            if (largestCoin == 0) {
                throw new RuntimeException("Not Possible");
            }
            //добавяме към мапа за използвани монети
            Integer currentUsage = result.get(largestCoin);
            if (currentUsage == null) {
                currentUsage = 0;
            }
            result.put(largestCoin, currentUsage + 1);

            targetSum -= largestCoin;
        }

        return result;
    }
}

