class MedianFinder {
    private final PriorityQueue<Integer> max;
    private final PriorityQueue<Integer> min;

    public MedianFinder() {
        min = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        max = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }
    
    public void addNum(int num) {
        min.add(num);

        if (min.size() - max.size() > 1  ||
            !max.isEmpty() && min.peek() > max.peek()
        ) {
            max.add(min.poll());
        }

        if (max.size() - min.size() > 1) {
            min.add(max.poll());
        }
    }
    
    public double findMedian() {
        if (min.size() == max.size()) {
            return (double) (min.peek() + max.peek()) / 2;
        } else if (min.size() > max.size()) {
            return min.peek();
        } else {
            return max.peek();
        }
    }
}
