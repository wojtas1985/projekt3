package projekt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;






import projekt.bean.InternetBean;
import projekt.model.Internet;
import projekt.model.Obiekt;
import projekt.service.InternetService;

@Controller
public class InternetController {
	
	@Autowired
	private InternetService internetService;
	
	@RequestMapping(value = "/saveInternet", method = RequestMethod.POST)
	public ModelAndView saveInternet(@ModelAttribute("command") Internet internet, Obiekt obiekt, BindingResult result) {
		internet.setInternetDataWystawienia(internet.getInternetDataWystawienia());
		internet.setInternetOkresPoczatek(internet.getInternetOkresPoczatek());
		internet.setInternetOkresKoniec(internet.getInternetOkresKoniec());
		internet.setInternetPLN(internet.getInternetPLN());
		internet.setObiektId(internet.getObiektId());
		internetService.addInternet(internet);
		return new ModelAndView("redirect:/internet.html");
	}
	
	@RequestMapping(value="/internety", method = RequestMethod.GET)
	public ModelAndView internetList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("internety",  prepareListofBeanInternet(internetService.internetList()));
		return new ModelAndView("internetList", model);
	}
	
	@RequestMapping(value = "/deleteInternet", method = RequestMethod.GET)
	public ModelAndView deleteInternet(@ModelAttribute("command")  InternetBean internetBean, BindingResult result) {
		internetService.deleteInternet(prepareModel(internetBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("internet", null);
		model.put("internety",  prepareListofBeanInternet(internetService.internetList()));
		return new ModelAndView("addInternet", model);
	}
	
	@RequestMapping("/internet.html")
	public String redirect()
	{
		return "addInternet";
	}
	
	@RequestMapping(value = "/calkowiteWydatkiInternet", method = RequestMethod.GET)
	public String redirect2() {
		return "calkowiteWydatkiInternet";
		
	}
	
	private List<InternetBean> prepareListofBeanInternet(List<Internet> internety){
		List<InternetBean> beans = null;
		if(internety != null && !internety.isEmpty()){
			beans = new ArrayList<InternetBean>();
			InternetBean bean = null;
			for(Internet internet : internety){
				bean = new InternetBean();
				bean.setId(internet.getInternetId());
				bean.setDataWystawienia(internet.getInternetDataWystawienia());
				bean.setOkresPoczatek(internet.getInternetOkresPoczatek());
				bean.setOkresKoniec(internet.getInternetOkresKoniec());
				bean.setpLN(internet.getInternetPLN());
				bean.setObiektId(internet.getObiektId());
				beans.add(bean);
			}
			}
		return beans;
	}
	
	private Internet prepareModel(InternetBean internetBean){
		Internet internet = new Internet();
		internet.setInternetPLN(internetBean.getpLN());
		internet.setInternetOkresKoniec(internetBean.getOkresKoniec());
		internet.setInternetOkresPoczatek(internetBean.getOkresPoczatek());
		internet.setInternetDataWystawienia(internetBean.getDataWystawienia());
		internet.setInternetId(internetBean.getId());
		internet.setObiektId(internetBean.getObiektId());
		internetBean.setId(null);
		return internet;
	}
	
	

}
