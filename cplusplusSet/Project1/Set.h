#pragma once
#ifndef SET_H
#define SET_H
#include <vector>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
class Set 
{
private:
	vector<string> v;

public:
	Set() {	
		v = vector<string>();
	}

	Set(vector<string> p) {
		v = vector<string>(p);
	}

	int size() {
		return v.size();
	}
	void print() {
		cout << "\nresult array: [";
		for (int i = 0; i<v.size(); i++) {
			cout << v[i] << ", ";
		}
		cout << "]\n";
	}

	void add(string a) {
		if (!contains(a)) v.push_back(a);
	}

	string operator[](const int& a) {
		return v[a];
	}

	// Intersection
	Set operator&&(Set b) {
		Set l = Set();
		for (int i = 0; i<v.size(); i++) {
			if (b.contains(v[i])) l.add(v[i]);
		}
		return l;
	}

	// Union
	Set operator+(Set b) {
		Set l = Set();
		for (int i = 0; i<v.size(); i++) {
			l.add(v[i]);
		}
		for (int i = 0; i<b.size(); i++) {
			if (!l.contains(b[i])) l.add(b[i]);
		}
		return l;
	}
	
	// Difference
	Set operator-(Set b) {
		Set l = Set(v);
		for (int i = 0; i<b.size(); i++) {
			if (l.contains(b[i])) l.extract(b[i]);
		}
		return l;
	}

	void extract(string a) {
		v.erase(remove(v.begin(), v.end(), a), v.end());
	}
	
	bool contains(string b) {
		for (int i = 0; i < v.size(); i++) {
			if (v[i] == b) return true;
		}
		return false;
	}

	vector<string> getList() {
		return v;
	}
};

#endif