/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs408.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Josh
 */
public class GrammarGenerator {
    
    private Set terminals;
    private Set nonTerminals;
    private Map rules;
    private ArrayList rulesList;
    
    GrammarGenerator(){
         terminals = new Set();
         nonTerminals = new Set();
         rulesList = new ArrayList();
    }
    
    public Set getTerminals(){
        return terminals;
    }
    
    public Set getNonTerminals(){
        return nonTerminals;
    }
    
    public Map getRules(){
        return rules;
    }
    
    public ArrayList getRulesList(){
        return rulesList;
    }

    
    public Map createGrammar(int terminalCount, int ruleCount){
        Map m = new LinkedHashMap<String, Set>() {};
        String term = "";
        char letter = 'A';
       
        Random rand = new Random();
        int position = 0;
        for(int i=0; i<terminalCount; i++){
           nonTerminals.add(getTerminal(i));
        }
        for(char alpha = 'a'; alpha<'z'; alpha++){
            terminals.add(alpha);
        }
        ArrayList a = new ArrayList();
        for(int i=0; i<nonTerminals.size(); i++){
            Set s = new Set();
            
            for(int j=0; j<ruleCount; j++){
                if(rand.nextInt(10)<8){
                   s.add( terminals.get(rand.nextInt(terminals.size())));
                   a.add( s.get(s.size()-1));
                }else{
                   s.add( nonTerminals.get(rand.nextInt(nonTerminals.size())));
                   a.add( s.get(s.size()-1));
                }
                
            }
            m.put( nonTerminals.get(i), s);

        }
        this.rulesList=a;
        this.rules =m;
        return m;
    }
    
    
    // Creates sequence A, B, C, .., Z, AA, AB, AC, AD, .. , AZ, BA, ..
    public static String getTerminal(int i) {
        return i < 0 ? "" : getTerminal((i / 26) - 1) + (char)(65 + i % 26);
    }
    
}
