#pragma once
#ifndef GENERATEGRAMMAR_H
#define GENERATEGRAMMAR_H
#include <vector>
#include <iostream>
#include <string>
#include <algorithm>
#include <cstdlib>
#include "Set.h"

using namespace std;
class GenerateGrammar
{
private:
	Set terminals;
	Set nonTerminals;
	Set rules;
	
	void createGrammar(int terminalCount, int ruleCount) {
		for (int i = 0; i<terminalCount; i++) {
			nonTerminals.add(getTerminal(i));
		}
		for (char alpha = 'a'; alpha<'z'; alpha++) {
			string str = "";
			str += alpha;
			terminals.add(str);
		}
		

		for (int i = 0; i<nonTerminals.size(); i++) {
			for (int j = 0; j<ruleCount; j++) {
				if (rand()%10<8) {
					rules.add(terminals[rand()%terminals.size()]);
				}
				else {
					rules.add(nonTerminals[rand()%nonTerminals.size()]);
				}
			}
		}
	}

	// Creates sequence A, B, C, .., Z, AA, AB, AC, AD, .. , AZ, BA, ..
	string getTerminal(int i) {
		return i < 0 ? "" : getTerminal((i / 26) - 1) + (char)(65 + i % 26);
	}

public:
	GenerateGrammar(int terminalCount, int ruleCount) {
		terminals = Set();
		nonTerminals = Set();
		rules = Set();
		createGrammar(terminalCount, ruleCount);
	}

	Set getRules() {
		return rules;
	}
	Set getTerminals() {
		return terminals;
	}
	Set getNonTerminals() {
		return nonTerminals;
	}
};

#endif