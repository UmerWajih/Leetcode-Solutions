package leetcode.questions.x1100.to.x1199;

import java.util.Arrays;

//https://leetcode.com/problems/filling-bookcase-shelves/
public class Problem_1105 {

	public static int minHeightShelves(int[][] books, int shelfWidth) {
		int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; 

        for (int i = 1; i <= n; i++) {
            int width = 0, height = 0;

            for (int j = i; j > 0; j--) {
                width += books[j - 1][0]; 
                if (width > shelfWidth) break; 

                height = Math.max(height, books[j - 1][1]); 
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[n];
        //return computeHeight(books, shelfWidth, 0, 0, 0, 0);
    }

    private static int computeHeight(int[][] books, int shelfWidth, int index, int currentWidth, int currentRowHeight, int totalHeight) {
        if (index == books.length) return totalHeight + currentRowHeight; 

        int bookWidth = books[index][0];
        int bookHeight = books[index][1];

        int heightWithSameShelf = Integer.MAX_VALUE;
        if (currentWidth + bookWidth <= shelfWidth) {
            heightWithSameShelf = computeHeight(books, shelfWidth, index + 1, currentWidth + bookWidth,
                    Math.max(currentRowHeight, bookHeight), totalHeight);
        }

        int heightWithNewShelf = computeHeight(books, shelfWidth, index + 1, bookWidth, bookHeight,
                totalHeight + currentRowHeight);

        return Math.min(heightWithSameShelf, heightWithNewShelf);
    }
}
