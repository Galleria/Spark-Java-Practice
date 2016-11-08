package utilies;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.velocity.app.VelocityEngine;

import com.google.gson.Gson;

import model.Message;
import spark.ModelAndView;
import spark.Request;
import spark.template.velocity.VelocityTemplateEngine;

public class LanguageUtil {

	public static String render(Request request, String templatePath) throws IOException {
		HashMap<String, Object> model = new HashMap<>();
		Message message = new Message( getMessagePropertiesFile().getProperty("Hello.Message") );
        model.put("response", message );
        return new Gson().toJson(model);
    }
	
	private static Properties getMessagePropertiesFile() throws IOException{
		Locale le = new Locale("en");
		InputStream utf8in = LanguageUtil.class.getClassLoader().getResourceAsStream("localization/messages_"+le+".properties");
		Reader reader = new InputStreamReader(utf8in, "UTF-8");
		Properties props = new Properties();
		props.load(reader);
		return props;
	}
    
}
