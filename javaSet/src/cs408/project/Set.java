package cs408.project;

import java.util.ArrayList;

/**
 *
 * @author Josh
 */
public class Set extends ArrayList {

    public Set(){
        super();
    }
    
    @Override
    public boolean add(Object i){
        if(!this.contains(i)) {
            super.add(i);
            return true;
        }
        return false;
    }
    
    public static Set intersection(Set a, Set b ){
        Set l = new Set(); 
        for(int i =0; i<a.size(); i++){
            if(b.contains(a.get(i))) l.add(a.get(i));
        }
        return l;
    }
    
    public static Set union(Set a, Set b ){
        Set l = new Set(); 
        for(int i=0; i<a.size(); i++){
            l.add(a.get(i));
        }
        for(int i=0; i<b.size(); i++){
            if(!l.contains(b.get(i))) l.add(b.get(i));
        }
        return l;
    }
    
    public static Set difference(Set a, Set b ){
        Set l = (Set)a.clone();
        for(int i=0; i<b.size();i++){
            if(a.contains(b.get(i))) l.remove(b.get(i));
        }
        return l;
    }
    
    public void print(){
        System.out.print("\nSet: [");
        for(int i=0; i<this.size();i++){
            System.out.print(this.get(i)+", ");
        }
        System.out.print("]\n");
    
    }
}
