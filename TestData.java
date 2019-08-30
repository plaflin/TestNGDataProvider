package testing;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "calc-data")
	Object[][] testData() {
		return new Object[][] {
			{"2 + 3", "5"}, // data set
			{"sqrt 16", "4"}, // data set
			{"3 - 2", "1"} // data set
		};		
	}
}
