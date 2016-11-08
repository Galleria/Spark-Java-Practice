package main;
import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.stop;
import static spark.debug.DebugScreen.*;

import java.util.Locale;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import model.Message;
import service.BookServiceApi;
import utilies.LanguageUtil;

public class Main {

	public static void main(String[] args) {
		port(8083);
		ResourceBundle.getBundle("localization/messages", new Locale("en"));
		enableDebugScreen();
		
		new BeforeFilter();
		new AfterFilter();
		
		get("/favicon.ico", (req, res) -> "");
		
		after("/hello", (req, res) -> res.header("spark", "added by after-filter"));
		
		get("/hello", (req, res) -> LanguageUtil.render(req, "/hello") );
		
		post("/stop/service", (req, res) ->{ stop(); return ""; });
		
		get("/hello/json" , "application/json" , (req, res) -> {
			return new Message("Hello Json Format");
		}, new Gson()::toJson);
		
		new BookServiceApi().BookController();
		
		
		get("*",(req, res) -> {
			return "Bad Request Service";
		});
		
	}
	


}
