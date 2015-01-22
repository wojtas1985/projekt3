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

import projekt.bean.UzytkownikBean;
import projekt.bean.UzytkownikRoleBean;
import projekt.model.Uzytkownik;
import projekt.model.UzytkownikRole;
import projekt.service.UzytkownikRoleService;
import projekt.service.UzytkownikService;

@Controller
public class UzytkownikController {

	@Autowired
	UzytkownikService uzytkownikService;
	
	@Autowired
	UzytkownikRoleService uzytkownikRoleService;
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("uzytkownik") UzytkownikBean uzytkownikBean, UzytkownikRoleBean uzytkownikRoleBean, 
			BindingResult result){
		Uzytkownik uzytkownik = prepareModel(uzytkownikBean);
		UzytkownikRole uzytkownikRole = prepareModel(uzytkownikRoleBean);
		uzytkownikRole.setUzytkownik(uzytkownik);
		uzytkownikService.addUzytkownik(uzytkownik);
		uzytkownikRoleService.addUzytkownikRole(uzytkownikRole);
		return new ModelAndView("redirect:/addUser.html");
	}
	
	@RequestMapping(value="/addUser", method = RequestMethod.GET)
	public ModelAndView uzytkownikList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("uzytkownicy",  prepareListofBean(uzytkownikService.uzytkownikList()));
		model.put("uzytkownicyRole", prepareListofBean2(uzytkownikRoleService.uzytkownikRoleList()));
		return new ModelAndView("addUser", model);
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(@ModelAttribute("command")  UzytkownikBean uzytkownikBean, UzytkownikRoleBean uzytkownikRoleBean,
			BindingResult result) {
		uzytkownikService.deleteUzytkownik(prepareModel(uzytkownikBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("uzytkownik", null);
		model.put("uzytkownikRole", null);
		model.put("uzytkownicy",  prepareListofBean(uzytkownikService.uzytkownikList()));
		model.put("uzytkownicyRole",  prepareListofBean2(uzytkownikRoleService.uzytkownikRoleList()));
		return new ModelAndView("addUser", model);
	}

	@RequestMapping("/checkUser")
	public String redirect()
	{
		return "checkUser";
	}
	
	private Uzytkownik prepareModel(UzytkownikBean uzytkownikBean){
		Uzytkownik uzytkownik = new Uzytkownik();
		uzytkownik.setUzytkownikLogin(uzytkownikBean.getLogin());
		uzytkownik.setUzytkownikHaslo(uzytkownikBean.getHaslo());
		uzytkownik.setUzytkownikEnabled(uzytkownikBean.getEnabled());
		uzytkownik.setUzytkownikId(uzytkownikBean.getId());
		uzytkownikBean.setId(null);
		return uzytkownik;
	}
	
	private UzytkownikRole prepareModel(UzytkownikRoleBean uzytkownikRoleBean){
		UzytkownikRole uzytkownikRole = new UzytkownikRole();
		uzytkownikRole.setUzytkownikRola(uzytkownikRoleBean.getRola());
		uzytkownikRole.setUzytkownikRolaId(uzytkownikRoleBean.getId());
		return uzytkownikRole;
	}
	
	private List<UzytkownikBean> prepareListofBean(List<Uzytkownik> uzytkownicy){
		List<UzytkownikBean> beans = null;
		if(uzytkownicy != null && !uzytkownicy.isEmpty()){
			beans = new ArrayList<UzytkownikBean>();
			UzytkownikBean bean = null;
			for(Uzytkownik uzytkownik : uzytkownicy){
				bean = new UzytkownikBean();
				bean.setLogin(uzytkownik.getUzytkownikLogin());
				bean.setHaslo(uzytkownik.getUzytkownikHaslo());
				bean.setEnabled(uzytkownik.getUzytkownikEnabled());
				bean.setId(uzytkownik.getUzytkownikId());
				bean.setRoles(uzytkownik.getRoles());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<UzytkownikRoleBean> prepareListofBean2(List<UzytkownikRole> uzytkownicyRole){
		List<UzytkownikRoleBean> beans = null;
		if(uzytkownicyRole != null && !uzytkownicyRole.isEmpty()){
			beans = new ArrayList<UzytkownikRoleBean>();
			UzytkownikRoleBean bean = null;
			for(UzytkownikRole uzytkownikRole : uzytkownicyRole){
				bean = new UzytkownikRoleBean();
				bean.setRola(uzytkownikRole.getUzytkownikRola());
				bean.setId(uzytkownikRole.getUzytkownikRolaId());
				beans.add(bean);
			}
		}
		return beans;
	}
	
}
