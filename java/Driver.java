package cs408.project;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class Driver {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        

        
        String input = "";
        do{
            System.out.print("Choose path"
                    + "\n(1) Manual Set Entry"
                    + "\n(2) CFG Application with ADT"
                    + "\n(3) CFG Application without ADT"
                    + "\n(x) Exit\n");
            input=scan.next();
            switch(input){
                case "1":
                    manual(scan);
                    break;
                case "2":
                    GrammarGenerator g = new GrammarGenerator();
                    g.createGrammar(5000, 10);
                    UnreachableAlgorithm a = new UnreachableAlgorithm(g.getRulesList(),g.getTerminals(),g.getNonTerminals());
                    a.execute();
                    break;
                case "3":
                    GrammarGenerator v = new GrammarGenerator();
                    v.createGrammar(5000, 10);
                    execute(v.getRulesList(),(ArrayList)v.getTerminals(),(ArrayList)v.getNonTerminals());
                    break;
            }
        }while(!input.equals("x"));

    }
    
    public static void manual(Scanner scan){
        ArrayList one  = new ArrayList();
        ArrayList two = new ArrayList();
        String input = "";
        while(!input.equals("x")){
            print(one,two);
            System.out.println("Enter values for first array, x to continue");
            input = scan.next();
            if(!input.equals("x")) one.add(input);
        }
        input="";
        while(!input.equals("x")){
            print(one,two);
            System.out.println("Enter values for second array, x to continue");
            input = scan.next();
            if(!input.equals("x")) two.add(input);
        
        }
        print(one,two);
        input="";
        do{
        
        System.out.println("Enter action. x to quit"
                + "\n(1) Union A∪B"
                + "\n(2) Intersection A∩B"
                + "\n(3) Difference A-B");
        input = scan.next();
        switch (input){
            case "1": 
                    print(union(one,two));
                    break;
            case "2":
                    print(intersection(one,two));
                    break;
            case "3":
                    print(difference(one,two));
                    break;
        }
        }while(!input.equals("x"));
    }
    
    public static void print(ArrayList a){
        System.out.print("\nResult Array: [");
        for(int i=0; i<a.size();i++){
            System.out.print(a.get(i)+", ");
        }
        System.out.print("]\n");
    }
    
    public static void print(ArrayList a, ArrayList b ){
        System.out.print("\nArrays------------------------\nA: [");
        for(int i=0; i<a.size();i++){
            System.out.print(a.get(i)+", ");
        }
        System.out.print("]\nB: [");
        for(int i=0; i<b.size();i++){
            System.out.print(b.get(i)+", ");
        }
        System.out.print("]\n");
    }
    
    public static ArrayList intersection(ArrayList a, ArrayList b ){
        ArrayList l = new ArrayList(); 
        for(int i =0; i<a.size(); i++){
            if(b.contains(a.get(i))) l.add(a.get(i));
        }
        return l;
    }
    
    public static ArrayList union(ArrayList a, ArrayList b ){
        ArrayList l = new ArrayList(); 
        for(int i=0; i<a.size(); i++){
            l.add(a.get(i));
        }
        for(int i=0; i<b.size(); i++){
            if(!l.contains(b.get(i))) l.add(b.get(i));
        }
        return l;
    }
    
    public static ArrayList difference(ArrayList a, ArrayList b ){
        ArrayList l = (ArrayList)a.clone();
        for(int i=0; i<b.size();i++){
            if(a.contains(b.get(i))) l.remove(b.get(i));
        }
        return l;
    }
    
    public static void execute(ArrayList rules, ArrayList terminals, ArrayList nonTerminals){
        long startTime = System.nanoTime();
        System.out.println("rules size"+rules.size());
        ArrayList reachable = new ArrayList();
        for(int i=0; i<rules.size(); i++){
            reachable.add(i);
        }

        ArrayList unreachables;
        unreachables = difference(terminals, reachable);
        unreachables = difference(nonTerminals, reachable);
        long endTime = System.nanoTime();
        System.out.println("time without using ADT: "+(endTime-startTime)/1000+"ms");

        
    }
}
