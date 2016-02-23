import java.util.Scanner;

/**
 * Created by Bryan Tamada on 1/3/16.
 */
public class NoPrefixSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Trie trie = new Trie();
        boolean isBadSet = false;
        String resultStr = "";
        while(N-->0) {
            resultStr = sc.next();
            if(!trie.find(resultStr,trie.root)) trie.insert(resultStr, trie.root);
            else {
                isBadSet = true;
                break;
            }
        }
        String result = isBadSet ? "BAD SET" : "GOOD SET";
        if(result.equals("BAD SET")) {
            System.out.println(result);
            System.out.println(resultStr);
        } else {
            System.out.println(result);
        }
    }
}

class Trie {

    TrieNode root;
    int index = 0;

    public int atoi(char ch) {
        // only consider the lowercase alphabet
        if(ch >= 97 && ch <= 122) return ch - 97;
        return -1;
    }

    public void insert(String str, TrieNode root) {
        if(root == null) root = new TrieNode(' ');
        for(int i = 0; i < str.length(); ++i) {
            index = atoi(str.charAt(i));
            if(root.nodes[index] == null) root.nodes[index] = new TrieNode(str.charAt(i));
            root = root.nodes[index];
        }
    }

    public void remove(String str, TrieNode root) {
        if(root == null) return;
        for(int i = str.length() - 1; i >= 0; --i) {
            index = atoi(str.charAt(i));
            root = root.nodes[index];
            if(root.nodes[index] != null) root.nodes[index] = null;
        }
    }

    public boolean find(String str, TrieNode root) {
        if(root == null) return false;
        for(int i = 0; i < str.length(); ++i) {
            index = atoi(str.charAt(i));
            if(root.nodes[index] == null) return false;
            if(root.nodes[index].isWord == true) return true;
            root = root.nodes[index];
        }
        return true;
    }
}

class TrieNode {
    char data;
    boolean isWord;
    TrieNode[] nodes;

    public TrieNode(char data) {
        this.data = data;
        this.isWord = false;
        this.nodes = new TrieNode[26];
    }
}
