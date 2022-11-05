public class Solution {
    public class TrieNode{
        public String word ;
        public TrieNode[] child = new TrieNode[26];
        public TrieNode(){
            
        }
    }
    
    TrieNode root = new TrieNode();
    boolean[][] flag;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        
        addToTrie(words);
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.child[board[i][j] - 'a'] != null){
                    search(board, i, j, root, result);
                }
            }
        }
        
        return result;
    }
    
    private void addToTrie(String[] words){
        for(String word: words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(node.child[ch - 'a'] == null){
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.word = word;
        }
    }
    
    private void search(char[][] board, int i, int j, TrieNode node, List<String> result){
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0){
            return;
        }
        
        if(board[i][j] == '*' || node.child[board[i][j] - 'a'] == null){
            return;
        }
        
        char ch = board[i][j];
        
        node = node.child[board[i][j] - 'a'];
        if(node.word != null){
            result.add(node.word);
            node.word = null ;
        }
        
        
        board[i][j] = '*';
        search(board, i-1, j, node, result);
        search(board, i+1, j, node, result);
        search(board, i, j-1, node, result);
        search(board, i, j+1, node, result);
        
        board[i][j] = ch;
    }
}