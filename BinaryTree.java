 
package datastructure_programmingassignment;
 
public class BinaryTree<T> {
    
       MNode<T>  root , current ; 
       
         public BinaryTree() { 
        root = current = null ; } 
         
     public BinaryTree(T data) {
      root = new MNode<T>( 0 , data);
      current = root ; 
   }
     public MNode<T> getRoot() {
        return root;
    }
  
     
     public MNode<T> getCurrent() {
        return current;}
        
      public boolean empty () { 
    return root == null ; 
    }
    
    
    
    
    
       public boolean insert (Relative rel , int key ,  T val ) {
   
   switch (rel){
       case Root : 
           if (!empty()) return false ; 
            current = root = new MNode<T> (key , val) ; 
            return true ;
            
       case Parent : 
           return false ; // because it's an impossible case!
        
       case LeftChild :
           if (current.left != null ) return false ; 
           current.left = new MNode <T> (key ,val) ; 
           current = current.left ; 
           return true ; 
       case RightChild : 
                if (current.right != null ) return false ; 
           current.right = new MNode <T> (key ,val) ; 
           current = current.right ; 
           return true ;
           
       default : 
           return false ;
   
   
   }
   } // end of insert 
    
    
    public boolean find (Relative rel ) {
   switch (rel){
       case Root :
           current = root ; 
           return true ; 
           
       case Parent : 
           if (current == root ) return false ; 
           current = findparent (current , root ) ; 
           return true ; 
        
       case LeftChild: 
           if (current.left == null ) return false ;
           current = current.left ;
           return true ; 
           
       case RightChild : 
           if (current.right == null ) return false  ; 
           current = current.right ; 
           return true ; 
           
       default : 
           return false ; 
   
   }
   }
   
    private MNode <T> findparent (MNode<T> p , MNode<T> t ){
    if (t == null ) return null ; 
    
    if (t.right == null && t.left == null )
        return null ; 
    else if (t.right == p || t.left == p )
        return t; 
    
    else {
      MNode q  = findparent (p , t.left) ; 
      if (q != null) 
          return q ; 
      else 
          return findparent ( p , t.right ) ; 
    }
    
    }
    
    

   public  MNode<T> findKey (  int key  ) {
   return  find_Key (root , key ) ; 
   }
    
    
    
    private MNode<T> find_Key (MNode temp , int key  ) { 
         // temp = root 
         
          if(temp != null){
         if(temp.key == key ){
               current = temp ;
            return temp;
         }

      else{
          MNode<T> requiredNode = find_Key ( temp.left ,  key  ) ; 
          if(requiredNode == null) {
                requiredNode = find_Key ( temp.right ,  key  ) ;
            }
            return requiredNode;
      }
    } else   return null;
         
     }
    
    
    
    
    
    

     private  boolean follow(MNode<T> t, String path) { 
         if (t == null ) return false  ; 
         if ( ! t.data.equals(path.charAt(0))) return false ; // check the first node 
         
         
         char[] index = path.toCharArray() ; //  it's will convert the String path to array of Character 
         MNode<T> temp = t ; // temporary node 
         
          for (int i = 1 ; i <  path.length()  ; i++) { // start from one because we already check the 0 index
             char letter = index[i] ; 
           
             if (letter == 'S' || letter == 'T' || letter == 'X' ) {
             if (temp.left != null && (char)temp.left.data == letter ) // chasting because the type of data is Character
                temp = temp.left ; 
             else if (temp.right != null &&  (char ) temp.right.data == letter )
                temp = temp.right ; 
              else return false ; 
               } 
       
             } // end for 
          return true ; 
            } // end follow method 
    
    
        public boolean follow_public ( MNode<T> t ,  String path ){
            return follow(t , path ) ; 
        }
        
    
    private boolean escape (MNode<T> t){
       if ( t== null ) return false ; 
       if ( t.data.equals('X'))  {
       System.out.println("you have finally escaped!");
       return true ;
      }
       return escape (t.left) || escape (t.right) ; 
      }
    
    
    boolean escape_public (MNode<T> t) {
    return escape (  t);
            }
  
    
    
    
    public String Short_public ()
{
    return Short(root);
}
 
    
    private String Short (MNode<T> t)
    {
        String path1,path2,path;
        path1=path2=path="";
        if( !escape(t))
        {
            return null;
        }
        
        path=""+t.getData();
      
        if(escape(t.getRight()))
        {
            path1=Short(t.getRight());
        }
        
        if(escape(t.getLeft()))
        {
            path2=Short(t.getLeft());
        }
        if(path1.equals(""))
        {
            return path+path2;
        }
        else if(path2.equals(""))
        {
           return path+path1;
        }
       if(path1.length()<path2.length())
        {
            return path+path1;
        }else if (path2.length()<=path1.length())
        {
            return path+path2;
        }
         return null;
    }



}
  /* String Short() 
   {
   
       
       
     
      
        // Count the number of nodes in the tree
        int count = countNodes(getRoot());

        // Create arrays to store nodes and paths
        MNode<T>[] nodes = new MNode[count];
        String[] paths = new String[count];

        int nodeIndex = 0;
        int pathIndex = 0;

        nodes[nodeIndex++] = getRoot();
        paths[pathIndex++] = "";

        while (nodeIndex > 0) {
            MNode<T> currentNode = nodes[--nodeIndex];
            String currentPath = paths[--pathIndex];

            if (currentNode.getData().equals('X')) {
                return currentPath + "X";
            }

           

            if (currentNode.getRight() != null) {
                nodes[nodeIndex++] = currentNode.getRight();
                paths[pathIndex++] = currentPath + currentNode.data  ;
            }
             if (currentNode.getLeft() != null) {
                nodes[nodeIndex++] = currentNode.getLeft();
                paths[pathIndex++] = currentPath + currentNode.data;
            }
        }

        return "No exit found";
    
   
   } 


 private int countNodes(MNode<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }
}  
    */
   /* private String Short()
    {
      int count = countNodes(root) ; 
      
        String [] Store = new String [count] ; 
        for (int i = 0 ; i <Store.length ; i++ )
            Store[i] = "" ; 
       // Stack<String> L = new linkedStack<String > ();
         AllPaths(root, Store  , "");
         String min ="";
          
        String minim = Store[0] ; 
        for (int i =1; i < Store.length ; i++)
         {
             String item = Store [i] ; 
             if (item.charAt(item.length()-1) == 'X' )
                 if (Store[i] != "" )
                if (Store[i].length() <  minim.length())
                  minim = Store[i] ;   
         }
        return minim;
    }
     
     
    private void AllPaths(MNode< T> p , String [] Store  ,  String  path )
    {
       int i = 0 ; 
       if ( p==null)
            return;
        else if ( p != null && p.left ==null && p.right == null )
        {
            path = path + p.data.toString();
            Store[i++] = path ; 
             
            return;
        }
        else
        {  
            if (p.left != null)
                AllPaths(p.left , Store,   path + p.data.toString() + "-" );
            if (p.right != null)
                AllPaths(p.right , Store,   path + p.data.toString() + "-");
        }
    }
    
    
    
    
    
    
    
    
    
   
} 
    /* private String Short()
    {
         Stack<String> L = new linkedStack<String > ();
         AllPaths(root, L , "");
         String min ="";
         if ( ! L.empty())
            min = L.pop();
         while (! L.empty())
         {
             String item = L.pop();
             if (item.charAt(item.length()-1) == 'X')
                if (min.length() > item.length())
                     min = item;
         }
        return min;
    }
    private void AllPaths(MNode< T> p , Stack<String> L, String  path )
    {
        if ( p==null)
            return;
        else if ( p != null && p.left ==null && p.right == null )
        {
            path = path + p.data.toString();
            L.push(path);
            return;
        }
        else
        {  
            if (p.left != null)
                AllPaths(p.left , L,   path + p.data.toString() + "-" );
            if (p.right != null)
                AllPaths(p.right , L,   path + p.data.toString() + "-");
        }
    }
}
    
     
    /* */
  
    
    

    
    
    
   

    
    
    
    
    
    



