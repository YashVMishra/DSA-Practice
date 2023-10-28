import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

public class Search_Suggestions_System {
    public static void main(String[] args) {
        String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";
        System.out.println(suggestedProducts(products, searchWord));
    }

    public static List<List<String>> suggestedProducts(String[] products, String search) {
        TrieNode trie = new TrieNode();
        for (String prod : products) {
            insertWord(trie, prod);
        }
        List<List<String>> result = new ArrayList<>();
        String prefix = "";
        for (char c : search.toCharArray()) {
            prefix += c;
            result.add(searchWord(trie, prefix));
        }
        return result;
    }

    public static void insertWord(TrieNode trie, String word) {
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (trie.children[index] == null) {
                trie.children[index] = new TrieNode();
            }
            trie = trie.children[index];
        }
        trie.endOfWord = true;
    }

    public static List<String> searchWord(TrieNode trie, String prefix) {
        List<String> result = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (trie.children[index] == null) {
                return result;
            }
            trie = trie.children[index];
        }
        dfs(trie, prefix, result);
        return result;
    }

    public static void dfs(TrieNode trie, String pre, List<String> result) {
        if (result.size() == 3) {
            return;
        }
        if (trie.endOfWord) {
            result.add(pre);
        }

        for (int i = 0; i < 26; i++) {
            if (trie.children[i] != null) {
                dfs(trie.children[i], pre + (char) (i + 'a'), result);
            }
        }
    }
}
