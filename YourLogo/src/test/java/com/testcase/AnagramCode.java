package com.testcase;

public class AnagramCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = isAnagram("niho","hine");
		System.out.println((res)?"Anagram":"not anagram");
	}
	
static boolean isAnagram(String a, String b) {
	int a_length = a.length();
	int b_length = b.length();
	//first condition
	if(a_length != b_length) return false;
	//second condition
	int[] char_frequence = new int[26];
	for(int i=0;i<a.length();i++) {
		char current_char = a.charAt(i);
		int index= current_char-'a';
		char_frequence[index]++;
	}
	for(int i=0;i<b.length();i++)
	{
		char current_char = b.charAt(i);
		int index= current_char-'a';
		char_frequence[index]--;
	}
	
	for(int i=0;i<26;i++) {
		if(char_frequence[i]!=0) return false;
	}
	return true;
}

}
