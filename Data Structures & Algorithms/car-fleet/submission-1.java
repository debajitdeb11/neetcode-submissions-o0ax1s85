class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> cars = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            cars.add(new Pair(position[i], speed[i]));
        }

        Collections.sort(cars, (a, b) -> (b.position - a.position));

        Stack<Double> st = new Stack<>();

        cars.forEach((p) -> {
            double temp = (double)(target - p.position) / p.speed;

            st.push(temp);

            if (st.size() >= 2 && st.peek() <= st.get(st.size() - 2)) {
                st.pop();
            }
        });

        return st.size();
    }

    private static class Pair {
        int position;
        int speed;

        Pair(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
}
