package main;

import static utilies.RequestUtil.getQueryLocale;
import static spark.Spark.before;

public class BeforeFilter {
	
	public BeforeFilter(){
		before((req, res) -> {
            System.out.println("before request");
            if (getQueryLocale(req) != null) {
            	req.session().attribute("locale", getQueryLocale(req));
            	res.redirect(req.pathInfo());
            }else{
            	req.session().attribute("locale", "en");
            	//res.redirect(req.pathInfo());
            }
        });
	}
	
}
