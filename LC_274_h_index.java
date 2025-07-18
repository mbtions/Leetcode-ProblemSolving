class LC_274_h_index {
    public static int hIndex(int[] citations) {
        int h = 0;

        if (citations.length == 1 && citations[0] == 0)
            return 0;

        for (int i = 0; i < citations.length; i++) {
            int count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[i] <= citations[j]) {
                    count++;
                }
            }

            if (count >= citations[i]) {
                h = Math.max(h, citations[i]);
            } else {
                h = Math.max(h, count);
            }
        }
        return h;
    }

    public static void main(String[] args) {
        int[] citations = { 1, 2, 5, 6, 3, 8, 4, 0 };
        int h = hIndex(citations);
        System.out.println("H index = " + h);
    }
}