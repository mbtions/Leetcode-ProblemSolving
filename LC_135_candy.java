import java.util.*;

class LC_135_candy {
    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        int count = 0;

        // while going forwards, comparing from everyone after i
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }

        // while going backwards, comparing everyone before i
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i])
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
            count += candies[i - 1];
        }

        return count + candies[ratings.length - 1];
    }

    public static void main(String[] args) {
        int[] ratings = { 2, 3, 1, 4, 5, 4 };
        int candies = candy(ratings);
        System.out.println("Total Candies: " + candies);
    }
}