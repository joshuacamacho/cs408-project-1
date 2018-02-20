#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include "Set.h"
#include "GenerateGrammar.h"
#include "UnreachableAlgorithm.h"
using namespace std;
void print(vector<string>);
void print(vector<string>,vector<string>);
vector<string> intersection(vector<string>,vector<string>);
vector<string> theUnion(vector<string>,vector<string>);
vector<string> difference(vector<string>,vector<string>);
bool contains(vector<string>,string);
void execute(vector<string>,vector<string>,vector<string>);
void manual();


int main() {
	
	string input = "";
	do {
		cout << "Choose your path\n(1) Manual Set Entry\n(2)Run CFG Application WITH ADT\n(3)Run CFG Application without ADT\n(x) Exit\n";
		getline(cin, input);
		if (input == "1") {
			manual();
		}
		else if (input == "2") {
			cout << "Running aplication...\n";
			UnreachableAlgorithm a = UnreachableAlgorithm(GenerateGrammar(5000, 10));
			a.execute();
		}
		else if (input == "3") {
			cout << "Running aplication...\n";
			GenerateGrammar g = GenerateGrammar(5000, 10);
			execute(g.getTerminals().getList(), g.getNonTerminals().getList(), g.getRules().getList());
		}
	} while (input != "x");
}

void manual() {
	string input = "";
	vector<string> one;
	vector<string> two;
	while (!(input == "x")) {
		print(one, two);
		cout << "enter values for first array, x to continue\n";
		getline(cin, input);
		if (!(input == "x") && !contains(one, (input))) one.push_back((input));
	}
	input = "";
	while (!(input == "x")) {
		print(one, two);
		cout << "enter values for second array, x to continue\n";
		getline(cin, input);
		if (!(input == "x") && !contains(two, (input))) two.push_back((input));

	}
	print(one, two);
	input = "";
	do {
		cout << "enter action\n(1) union\n(2) intersection ab\n(3) difference a-b\n\n(x) Main Menu";
		getline(cin, input);
		if (input == "1") {
			print(theUnion(one, two));
		}
		else if (input == "2") {
			print(intersection(one, two));
		}
		else if (input == "3") {
			print(difference(one, two));
		}

	} while (!(input == "x"));
}


void print(vector<string> a) {
	cout<<"\nresult array: [";
	for (int i = 0; i<a.size(); i++) {
		cout<<a[i]<<", ";
	}
	cout<<"]\n";
}

void print(vector<string> a, vector<string> b) {
	cout<<"\nArrays------------------------\nA: [";
	for (int i = 0; i<a.size(); i++) {
		cout<<a[i]<<", ";
	}
	cout<<"]\nB: [";
	for (int i = 0; i<b.size(); i++) {
		cout<<b[i]<<", ";
	}
	cout<<"]\n";
}

vector<string> intersection(vector<string> a, vector<string> b) {
	vector<string> l = vector<string>();
	for (int i = 0; i<a.size(); i++) {
		if (contains(b,a[i])) l.push_back(a[i]);
	}
	return l;
}

vector<string> theUnion (vector<string> a, vector<string> b) {
	vector<string> l = vector<string>();
	for (int i = 0; i<a.size(); i++) {
		l.push_back(a[i]);
	}
	for (int i = 0; i<b.size(); i++) {
		if (!contains(l,b[i])) l.push_back(b[i]);
	}
	return l;
}

vector<string> difference(vector<string> a, vector<string> b) {
	vector<string> l = vector<string>(a);
	for (int i = 0; i<b.size(); i++) {
		if (contains(l, b[i])) l.erase(remove(l.begin(), l.end(), b[i]), l.end());
	}
	return l;
}

bool contains(vector<string> a, string b) {
	for (int i = 0; i < a.size(); i++) {
		if (a[i] == b) return true;
	}
	return false;
}

void execute(vector<string> terminals, vector<string> nonTerminals, vector<string> rules) {
	clock_t    start;
	start = clock();
	vector<string> reachable = vector<string>();
	for (int i = 0; i < rules.size(); i++) {
		reachable.push_back(rules[i]);
	}
	vector<string> unreachable = theUnion(terminals,nonTerminals);
	unreachable = difference(unreachable,reachable);
	cout << "Time: " << (clock() - start) / (double)(CLOCKS_PER_SEC / 1000) << " ms" << std::endl;
}
