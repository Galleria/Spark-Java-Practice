package main;

import static spark.Spark.after;

public class AfterFilter {
	
	public AfterFilter(){
		after((req, res) -> {
            System.out.println("after response");
        });
	}
	
}
