public class TrieTest{
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.add("imlgw");
        trie.add("iacsad");
        trie.add("abcd");
        trie.add("aaaa");
        trie.add("dsd");
        System.out.println(trie.contains("imlgw")); //true
        System.out.println(trie.contains("imlgwa")); //false
        System.out.println(trie.hasPerfix("i")); //true
        System.out.println(trie.hasPerfix("imlgwaaaaaaaaaaaaaaaaaaa")); //fasle
        System.out.println(trie.hasPerfix("aaaa")); //true

        System.out.println("+++++++++++++++++");
        Trie trie2=new Trie();
        trie2.addLoop("imlgw");
        trie2.addLoop("iacsad");
        trie2.addLoop("abcd");
        trie2.addLoop("aaaa");
        trie2.addLoop("dsd");
        System.out.println(trie2.containsLoop("imlgw")); //true
        System.out.println(trie2.containsLoop("imlgwabv")); //false
    }
}