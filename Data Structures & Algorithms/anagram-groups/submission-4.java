class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        // insertion of string into correct bucket
        for (String s : strs) {
            String hash = generateHashed(s);
            System.out.println(s + " - " + hash);

            if (map.containsKey(hash)) {
                List<String> list = map.get(hash);
                list.add(s);
                map.put(hash, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(hash, list);
            }
        }

        // Group all the same hashes together
        for (Map.Entry<String, List<String>> mp : map.entrySet()) {
            var list = mp.getValue();
            result.add(list);
        }

        return result;
    }

    private String generateHashed(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        int[] hash = new int[26];

        for (int i = 0; i < str.length(); i++) {
            hash[(int)str.charAt(i) - (int)'a']++;
        }

        System.out.println(Arrays.toString(hash));

        // create hash string
        StringBuilder hashString = new StringBuilder();
        
        for (int i = 0; i < 26; i++) {
            hashString.append(hash[i] + "-");
        }

        return hashString.toString();
    }
}
