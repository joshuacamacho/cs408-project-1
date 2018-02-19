#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include "Set.h"
using namespace std;
void print(vector<int>);
void print(vector<int>,vector<int>);
vector<int> intersection(vector<int>,vector<int>);
vector<int> theUnion(vector<int>,vector<int>);
vector<int> difference(vector<int>,vector<int>);
bool contains(vector<int>,int);


int main() {
	vector<int> one;
	vector<int> two;


	Set s = Set();
	Set t = Set();
	s.add(1);
	s.add(2);
	s.add(3);
	t.add(3);
	t.add(1);
	t.add(6);
	t.add(7);
	s.print();
	t.print();
	Set p = s && t;
	p.print();
	p = s + t;
	p.print();
	p = s - t;
	p.print();
	cin.get();
	string input = "";
	while (!(input=="x")) {
		print(one, two);
		cout<<"enter values for first array, x to continue\n";
		getline(cin, input);
		if (!(input=="x") && !contains(one, stoi(input))) one.push_back(stoi(input));
	}
	input = "";
	while (!(input=="x")) {
		print(one, two);
		cout<<"enter values for second array, x to continue\n";
		getline(cin, input);
		if (!(input=="x") && !contains(two,stoi(input))) two.push_back(stoi(input));

	}
	print(one, two);
	input = "";
	do {
		cout<<"enter action. x to quit \n(1) union\n(2) intersection ab\n(3) difference a-b\n";
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

	} while (!(input=="x"));
}


void print(vector<int> a) {
	cout<<"\nresult array: [";
	for (int i = 0; i<a.size(); i++) {
		cout<<a[i]<<", ";
	}
	cout<<"]\n";
}

void print(vector<int> a, vector<int> b) {
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

vector<int> intersection(vector<int> a, vector<int> b) {
	vector<int> l = vector<int>();
	for (int i = 0; i<a.size(); i++) {
		if (contains(b,a[i])) l.push_back(a[i]);
	}
	return l;
}

vector<int> theUnion (vector<int> a, vector<int> b) {
	vector<int> l = vector<int>();
	for (int i = 0; i<a.size(); i++) {
		l.push_back(a[i]);
	}
	for (int i = 0; i<b.size(); i++) {
		if (!contains(l,b[i])) l.push_back(b[i]);
	}
	return l;
}

vector<int> difference(vector<int> a, vector<int> b) {
	vector<int> l = vector<int>(a);
	for (int i = 0; i<b.size(); i++) {
		if (contains(l, b[i])) l.erase(remove(l.begin(), l.end(), b[i]), l.end());
	}
	return l;
}

bool contains(vector<int> a, int b) {
	for (int i = 0; i < a.size(); i++) {
		if (a[i] == b) return true;
	}
	return false;
}
