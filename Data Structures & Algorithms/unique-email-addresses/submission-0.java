class Solution {
    public int numUniqueEmails(String[] emails) {
        // Req
        // 1. '.' -> abc.xyz =====> abcxyz
        // 2. '+' -> abc+xyz =====> abc

        Set<String> st = new HashSet<>();

        for (String s : emails) {
            String[] parts = s.split("@");

            String[] localnamePartsByPlus = parts[0].split("\\+");

            String[] localnamePartsByDot;

            String finalStr = "";

            if (localnamePartsByPlus.length == 0) {
                localnamePartsByDot = parts[0].split(".");

                if (localnamePartsByDot.length == 0) {
                    st.add(parts[0] + parts[1]);
                    continue;
                } else {
                    for (String sr : localnamePartsByDot) {
                        finalStr += sr;
                    }

                    st.add(finalStr);
                    continue;
                }
            } else {
                localnamePartsByDot = localnamePartsByPlus[0].split("\\.");

                if (localnamePartsByDot.length == 0) {
                    finalStr += localnamePartsByPlus[0] + parts[1];

                    st.add(finalStr);
                    continue;
                } else {
                    for (String sp : localnamePartsByDot) {
                        finalStr += sp;
                    }

                    finalStr += parts[1];
                    st.add(finalStr);
                }
            }
        }

        System.out.println(Arrays.toString(st.toArray()));

        return st.size();
    }
}