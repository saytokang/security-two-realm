package x.y.z;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping("/admin_login")
	public String adminLogin(Model model){
		return "admin_login";
	}
	@RequestMapping("/user_login")
	public String userLogin(Model model){
		return "mobile_login";
	}
	
	@RequestMapping("/admin/welcom")
	public String loginAdmin(Model model, Principal account){
		model.addAttribute("user", account.getName());
		return "admin/welcom";
	}
	
	@RequestMapping("/user/welcom")
	public String loginUser(Model model, Principal account){
		model.addAttribute("user", account.getName());
		return "user/welcom";
	}	
}
