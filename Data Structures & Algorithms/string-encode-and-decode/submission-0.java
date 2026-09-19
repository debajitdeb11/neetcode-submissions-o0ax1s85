class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            int len = s.length();

            sb.append(len);
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> data = new ArrayList<>();

        int i;

        for (i = 0; i < str.length(); ) {
            int st = i;
            int ed = i;
            while(str.charAt(ed) != '#') {
                ed++;
            }

            int len = Integer.valueOf(str.substring(st, ed));
            
            data.add(str.substring(ed + 1, ed + 1 + len));

            i = ed + 1 + len;
        }

        return data;
    }
}
