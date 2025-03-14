 
package datastructure_programmingassignment;
import java.util.Scanner;

public class DataStructure_ProgrammingAssignment {
 static Scanner read = new Scanner (System.in) ; 

 
    
    
    
    public static void main(String[] args) {
       
         
        
  BinaryTree<Character> treeMaze = new BinaryTree<Character>  ('B') ; 
        
    treeMaze.insert(Relative.LeftChild, 1, 'S');
    treeMaze.insert(Relative.LeftChild, 2, 'S');
    treeMaze.insert(Relative.LeftChild, 3, 'S');
            treeMaze.find(Relative.Root) ; 
    treeMaze.insert(Relative.RightChild, 4, 'T');
    treeMaze.insert(Relative.LeftChild, 5, 'T');
    treeMaze.insert(Relative.LeftChild, 6, 'S');
    treeMaze.insert(Relative.LeftChild, 7, 'S');
            treeMaze.find(Relative.Parent) ; 
    treeMaze.insert(Relative.RightChild, 8, 'T');
    treeMaze.insert(Relative.LeftChild, 9, 'T');
    treeMaze.insert(Relative.RightChild, 10, 'T');
    treeMaze.insert(Relative.RightChild, 11, 'X');
            treeMaze.find(Relative.Root) ; 
            treeMaze.find(Relative.RightChild) ; 
            treeMaze.find(Relative.LeftChild) ;
    treeMaze.insert(Relative.RightChild, 12, 'T');
    treeMaze.insert(Relative.RightChild, 13, 'S');
    treeMaze.insert(Relative.LeftChild, 14, 'T');
            treeMaze.find(Relative.Root ) ; 
            treeMaze.find(Relative.RightChild) ;
    treeMaze.insert(Relative.RightChild, 15, 'S');
    treeMaze.insert(Relative.RightChild, 16, 'S');
    treeMaze.insert(Relative.RightChild, 17, 'X');
 
    
        System.out.println("Hi there , this our maze !");
                
                
        System.out.println("                         (0,B)          ");
        System.out.println("                      /        \\                ");
        System.out.println("                (1,S)          (4,T)     ");
        System.out.println("                /             /     \\   ");

        System.out.println("          (2,S)          (5,T)      (15,S)  ");
        System.out.println("          /             /     \\          \\                                      ");
        System.out.println("     (3,S)         (6,S)      (12,T)      (16,S)       ");
        System.out.println("                    /  \\        \\          \\");
        System.out.println("                 (7,S)  (8,T)    (13,S)      (17.X)");
        System.out.println("                        /         /");
        System.out.println("                       (9,T)     (14,T)");
        System.out.println("                          \\");
        System.out.println("                          (10,T)");
        System.out.println("                            \\");
        System.out.println("                            (11,X)");        
                
       
      
      int SWITCH  ; 
    
    do { 
        System.out.println(" selsect your choice :- ");   
        System.out.println("press -1- to check if the path you will enter is valid!    ");
        System.out.println("press -2- if you want to search for an exit starting at the node you will enter ");
        System.out.println("press -3- if you want to know what it's the short path ");
        System.out.println("press -0- if you want to Exit! ");
        
        SWITCH = read.nextInt() ; 
        
        switch (SWITCH) {
         
            case 1 :
                System.out.println("what the node you want start from it ? (enter key) ");
                 int userKey = read.nextInt() ; 
                 treeMaze.find(Relative.Root) ;
                  
                System.out.println("enter the path to test it ");
                String userPath = read.next() ; 
                

                
               System.out.println(treeMaze.follow_public( treeMaze.findKey( userKey)  ,    userPath));
                break ; 
                
            case 2 : 
                System.out.println("search the exit from any node ? (enter the key of node) ");
               int userKeyy = read.nextInt() ; 
                
                
                System.out.println(treeMaze.escape_public(treeMaze.findKey(  userKeyy)));
                
                break ; 
            case 3 : 
              
                 System.out.println(treeMaze.Short_public ());
              break ; 
            default : 
                 System.out.println("ooh! it's not a correct input ");
                break ; 
        }
         
        
    } while (SWITCH != 0 ) ;  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    }
    
}
