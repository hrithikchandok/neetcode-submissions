

class Pair {
    Integer key;
    Integer value;

    Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        int ans[] = new int[k];

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        // Min Heap based on frequency
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.key - b.key);

        for (Map.Entry<Integer, Integer> temp : mp.entrySet()) {

            pq.add(new Pair(temp.getValue(), temp.getKey()));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int index = 0;

        while (!pq.isEmpty()) {
            ans[index++] = pq.poll().value;
        }

        return ans;
    }
}