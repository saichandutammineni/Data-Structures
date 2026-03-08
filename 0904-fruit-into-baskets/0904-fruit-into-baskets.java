class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length < 3) return fruits.length;

        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        int max = 0, i = 0;

        for (int j = 0; j < fruits.length; j++) {
            // update the last seen index of the current fruit
            lastIndex.put(fruits[j], j);

            // if we have more than 2 fruit types, shrink the window
            if (lastIndex.size() > 2) {
                // find the fruit with the smallest last seen index
                int minIndex = Integer.MAX_VALUE;
                int fruitToRemove = -1;
                for (Map.Entry<Integer, Integer> entry : lastIndex.entrySet()) {
                    if (entry.getValue() < minIndex) {
                        minIndex = entry.getValue();
                        fruitToRemove = entry.getKey();
                    }
                }
                // remove that fruit and move i to one past its last index
                lastIndex.remove(fruitToRemove);
                i = minIndex + 1;
            }

            // update max window size
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}