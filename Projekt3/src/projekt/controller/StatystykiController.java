package projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StatystykiController {

	@RequestMapping(value = "/jednostkoweZuzycie", method = RequestMethod.GET)
	public String redirect() {
		return "jednostkoweZuzycie";
		
	}

	@RequestMapping(value = "/calkowiteZuzycie", method = RequestMethod.GET)
	public String redirect2() {
		return "calkowiteZuzycie";
		
	}
	
	@RequestMapping(value = "/calkowiteKoszty", method = RequestMethod.GET)
	public String redirect3() {
		return "calkowiteKoszty";
		
	}
	
	@RequestMapping(value = "/jednostkoweKoszty", method = RequestMethod.GET)
	public String redirect4() {
		return "jednostkoweKoszty";
		
	}
	
	@RequestMapping(value = "/calkowiteWydatki", method = RequestMethod.GET)
	public String redirect5() {
		return "calkowiteWydatki";
		
	}
}
