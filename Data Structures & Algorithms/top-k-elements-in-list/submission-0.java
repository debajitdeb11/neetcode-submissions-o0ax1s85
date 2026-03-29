class Solution {
    class Pair {
        int key;
        int freq;

        public Pair(int key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int[] result = new int[k];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        map.forEach((key, val) -> {
            pq.add(new Pair(key, val));
        });

        for (int i = 0; i < k; i++) {
            // System.out.println(pq.poll());
            result[i] = pq.poll().key;
        }

        return result;
    }
}