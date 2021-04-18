package com.testcase;

import java.io.IOException;
import org.testng.annotations.Test;

import com.pages.GooglePage;


public class GoogleSearch extends GooglePage {

	@Test
	public void GSearch() throws IOException {
		invokeApp("Chrome", "https://www.google.com");
		String[][] SearchData = getData();
		
		for(int row =0 ; row < SearchData.length; ++row)
			 for(int column =0; column<SearchData[row].length;++column)
			    System.out.print(SearchData[row][column]);		
	}
}
