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

import projekt.bean.TelefonBean;
import projekt.model.Obiekt;
import projekt.model.Telefon;
import projekt.service.TelefonService;

@Controller
public class TelefonController {
	
	@Autowired
	private TelefonService telefonService;
	
	@RequestMapping(value = "/saveTelefon", method = RequestMethod.POST)
	public ModelAndView saveTelefon(@ModelAttribute("command") Telefon telefon, Obiekt obiekt, BindingResult result) {
		telefon.setTelefonDataWystawienia(telefon.getTelefonDataWystawienia());
		telefon.setTelefonOkresPoczatek(telefon.getTelefonOkresPoczatek());
		telefon.setTelefonOkresKoniec(telefon.getTelefonOkresKoniec());
		telefon.setTelefonPLN(telefon.getTelefonPLN());
		telefon.setObiektId(telefon.getObiektId());
		telefonService.addTelefon(telefon);
		return new ModelAndView("redirect:/telefon.html");
	}
	
	@RequestMapping(value = "/deleteTelefon", method = RequestMethod.GET)
	public ModelAndView deleteTelefon(@ModelAttribute("command")  TelefonBean telefonBean, BindingResult result) {
		telefonService.deleteTelefon(prepareModel(telefonBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("telefon", null);
		model.put("telefony",  prepareListofBeanTelefon(telefonService.telefonList()));
		return new ModelAndView("addTelefon", model);
	}
	
	@RequestMapping("/telefon.html")
	public String redirect()
	{
		return "addTelefon";
	}
	
	@RequestMapping(value = "/calkowiteWydatkiTelefon", method = RequestMethod.GET)
	public String redirect5() {
		return "calkowiteWydatkiTelefon";
		
	}
	
	private List<TelefonBean> prepareListofBeanTelefon(List<Telefon> telefony){
		List<TelefonBean> beans = null;
		if(telefony != null && !telefony.isEmpty()){
			beans = new ArrayList<TelefonBean>();
			TelefonBean bean = null;
			for(Telefon telefon : telefony){
				bean = new TelefonBean();
				bean.setId(telefon.getTelefonId());
				bean.setDataWystawienia(telefon.getTelefonDataWystawienia());
				bean.setOkresPoczatek(telefon.getTelefonOkresPoczatek());
				bean.setOkresKoniec(telefon.getTelefonOkresKoniec());
				bean.setpLN(telefon.getTelefonPLN());
				bean.setObiektId(telefon.getObiektId());
				beans.add(bean);
			}
			}
		return beans;
	}
	
	private Telefon prepareModel(TelefonBean telefonBean){
		Telefon telefon = new Telefon();
		telefon.setTelefonPLN(telefonBean.getpLN());
		telefon.setTelefonOkresKoniec(telefonBean.getOkresKoniec());
		telefon.setTelefonOkresPoczatek(telefonBean.getOkresPoczatek());
		telefon.setTelefonDataWystawienia(telefonBean.getDataWystawienia());
		telefon.setTelefonId(telefonBean.getId());
		telefon.setObiektId(telefonBean.getObiektId());
		telefonBean.setId(null);
		return telefon;
	}

}
