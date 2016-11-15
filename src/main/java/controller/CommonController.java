package controller;

import static spark.Spark.stop;

import spark.Request;
import spark.Response;
import spark.Route;

public class CommonController {

	public static Route getFavicon = (Request req,Response res)->{
		return "";
	};
	
	public static Route stopService = (Request req,Response res)->{
		stop();
		return null;
	};
}
