class PrefixTree {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }

            curr = curr.children.get(c);
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (curr.children.get(c) == null) {
                return false;
            }

            curr = curr.children.get(c);
        }

        if (curr.isEndOfWord) {
            return true;
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {
            if (curr.children.get(c) == null) {
                return false;
            }

            curr = curr.children.get(c);
        }

        return true;
    }
}
