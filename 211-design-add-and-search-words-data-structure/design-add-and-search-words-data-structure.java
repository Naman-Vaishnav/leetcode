class WordDictionary {
    class Node{
        boolean isEnd;
        Node[] childs;
        Node(){
            isEnd=false;
            childs=new Node[26];
        }
    }
    Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node cur=root;
        for(char ch:word.toCharArray()){
            if(cur.childs[ch-'a']==null)cur.childs[ch-'a']=new Node();
            cur=cur.childs[ch-'a'];
        }
        cur.isEnd=true;
    }
    
    public boolean search(String word) {
        return searchWithRoot(root,word);
    }

    boolean searchWithRoot(Node cur,String word){
        if(word.length()==0)return cur.isEnd;

        char ch=word.charAt(0);
        if(ch=='.'){
            for(int i=0;i<26;i++){
                if(cur.childs[i]!=null&&searchWithRoot(cur.childs[i],word.substring(1)))
                    return true;
            }
        }
        else if(cur.childs[ch-'a']!=null&&searchWithRoot(cur.childs[ch-'a'],word.substring(1)))
                    return true;

        return false;       

    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */