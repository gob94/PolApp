package com.thinksoft.businesslayer.utils.services;

import static com.thinksoft.businesslayer.utils.constants.Constants.WILDCARD_MATCH;

import java.util.ArrayList;
import java.util.Arrays;

public class QueryService {
	
	public String setWildCardMatch(String queryString){
		return WILDCARD_MATCH+queryString+WILDCARD_MATCH;
	}
	
	public String[] getWordsToSearch(CharSequence constraint){
		String searchText = constraint.toString();
		String [] arrayToIterate = searchText.split(".");
		ArrayList<String> words = new ArrayList<String>();
		if (arrayToIterate.length==0) {
			arrayToIterate = searchText.split(" ");
			return arrayToIterate;
		} else {
			for (String phrase : arrayToIterate) {
				words.addAll((Arrays.asList(phrase.split(" "))));
			}
			return words.toArray(new String[0]);
		}
	}
}
