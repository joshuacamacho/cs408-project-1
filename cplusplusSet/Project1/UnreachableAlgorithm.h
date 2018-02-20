#pragma once
#pragma once
#ifndef UNREACHABLEALGORITHM_H
#define UNREACHABLEALGORITHM_H
#include <vector>
#include <iostream>
#include <string>
#include <algorithm>
#include <cstdlib>
#include <time.h>
#include "Set.h"
#include "GenerateGrammar.h"

using namespace std;
class UnreachableAlgorithm
{
private:
	Set terminals;
	Set nonTerminals;
	Set rules;

public:
	UnreachableAlgorithm(GenerateGrammar g) {
		terminals = g.getTerminals();
		nonTerminals = g.getNonTerminals();
		rules = g.getRules();
	}

	void execute() {
		clock_t    start;
		start = clock();
		Set reachable = Set();
		for (int i = 0; i < rules.size(); i++) {
			reachable.add(rules[i]);
		}
		Set unreachable = terminals + nonTerminals;
		unreachable =  unreachable - reachable;
		cout << "Time: " << (clock() - start) / (double)(CLOCKS_PER_SEC / 1000) << " ms" << std::endl;
	}
};

#endif