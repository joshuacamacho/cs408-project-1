/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs408.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class JavaSetNoAdt {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set s = new Set();
        Set t = new Set();
        s.add(3);
        s.add(4);
        s.add(5);
        t.add(6);
        t.add(3);
        t.add(1);
        s.print();
        t.print();
        Set.difference(s, t).print();
        Set.union(s, t).print();
        Set.intersection(s, t).print();
//        ArrayList<Integer> one  = new ArrayList<>();
//        ArrayList<Integer> two = new ArrayList<Integer>();
//        String input = "";
//        while(!input.equals("x")){
//            print(one,two);
//            System.out.println("Enter values for first array, x to continue");
//            input = scan.next();
//            if(!input.equals("x")) one.add(Integer.parseInt(input));
//        }
//        input="";
//        while(!input.equals("x")){
//            print(one,two);
//            System.out.println("Enter values for second array, x to continue");
//            input = scan.next();
//            if(!input.equals("x")) two.add(Integer.parseInt(input));
//        
//        }
//        print(one,two);
//        input="";
//        do{
//        
//        System.out.println("Enter action. x to quit"
//                + "\n(1) Union A∪B"
//                + "\n(2) Intersection A∩B"
//                + "\n(3) Difference A-B");
//        input = scan.next();
//        switch (input){
//            case "1": 
//                    print(union(one,two));
//                    break;
//            case "2":
//                    print(intersection(one,two));
//                    break;
//            case "3":
//                    print(difference(one,two));
//                    break;
//        }
//        }while(!input.equals("x"));
    }
    
    public static void print(ArrayList<Integer> a){
        System.out.print("\nResult Array: [");
        for(int i=0; i<a.size();i++){
            System.out.print(a.get(i)+", ");
        }
        System.out.print("]\n");
    }
    
    public static void print(ArrayList<Integer> a, ArrayList<Integer> b ){
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
    
    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b ){
        ArrayList<Integer> l = new ArrayList<Integer>(); 
        for(int i =0; i<a.size(); i++){
            if(b.contains(a.get(i))) l.add(a.get(i));
        }
        return l;
    }
    
    public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b ){
        ArrayList<Integer> l = new ArrayList<Integer>(); 
        for(int i=0; i<a.size(); i++){
            l.add(a.get(i));
        }
        for(int i=0; i<b.size(); i++){
            if(!l.contains(b.get(i))) l.add(b.get(i));
        }
        return l;
    }
    
    public static ArrayList<Integer> difference(ArrayList<Integer> a, ArrayList<Integer> b ){
        ArrayList<Integer> l = (ArrayList)a.clone();
        for(int i=0; i<b.size();i++){
            if(a.contains(b.get(i))) l.remove(b.get(i));
        }
        return l;
    }
}
