/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs408.project;

import java.util.ArrayList;
import java.util.Map;



/**
 *
 * @author Josh
 */
public class UnreachableAlgorithm {
    private Map rules;
    private Set terminals;
    private Set nonTerminals;
    private Set reachable;
    private ArrayList rulesList;
    
    UnreachableAlgorithm(Map r, Set terminals, Set nonTerminals){
        rules=r;
        this.terminals=terminals;
        this.nonTerminals=nonTerminals;
        reachable = new Set();
    }
    
    UnreachableAlgorithm(ArrayList r, Set terminals, Set nonTerminals){
        rulesList=r;
        this.terminals=terminals;
        this.nonTerminals=nonTerminals;
        reachable = new Set();
    }
    
    public void execute(){
        long startTime = System.nanoTime();


        System.out.println("Size of rules set"+rulesList.size());

        for(int i=0;i<rulesList.size();i++){
            reachable.add(rulesList.get(i));
        }
        Set unreachables = new Set();
        unreachables = Set.difference(terminals, reachable);
        unreachables = Set.difference(nonTerminals, reachable);
        long endTime = System.nanoTime();
        System.out.println("time using ADT: "+(endTime-startTime)/1000+"ms");
        
    }
}
