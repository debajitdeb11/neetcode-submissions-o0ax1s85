class WordDictionary {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean eol = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (curr.children.get(c) == null) {
                curr.children.put(c, new TrieNode());
            }

            curr = curr.children.get(c);
        }

        curr.eol = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        return dfs(root, 0, word);
    }

    private boolean dfs(TrieNode node, int idx, String word) {
        if (idx == word.length()) {
            return node.eol;
        }

        char c = word.charAt(idx);

        if (c == '.') {
            for (TrieNode child : node.children.values()) {
                if (dfs(child, idx + 1, word)) {
                    return true;
                }
            }

            return false;
        } else {
            if (node.children.get(c) == null) {
                return false;
            }

            node = node.children.get(c);

            return dfs(node, idx + 1, word);
        }
    }
}
