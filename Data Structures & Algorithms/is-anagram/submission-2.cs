public class Solution {
    public bool IsAnagram(string s, string t) {
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        for (int i = 0; i < s.Length; i++)
        {
            hash1[s[i] - 'a']++;
        }

        for (int i = 0; i < t.Length; i++)
        {
            hash2[t[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++)
        {
            if (hash1[i] != hash2[i])
            {
                return false;
            }
        }

        return true;
    }
}
