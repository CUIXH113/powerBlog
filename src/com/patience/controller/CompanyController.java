package com.patience.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.patience.entity.CEO;
import com.patience.entity.Company;
import com.patience.entity.FinancialStatement;
import com.patience.entity.Stock;
import com.patience.service.CEOService;
import com.patience.service.CompanyService;
import com.patience.service.StockService;

@Controller
@Transactional
@RequestMapping("/company")
@SessionAttributes("company")
public class CompanyController {

	@Resource
	private CompanyService companyService;
	
	@Resource
	private CEOService ceoService;
	
	@Resource
	private StockService stockService;
	
	
	private static final String COMPANY = "company";
	private static final String COMPANY_ID = "companyId";
	private static final String COMPANY_NAME = "companyName";
	private static final String LIST_COMPANY = "listCompany";
	private static final String EDIT_COMPANY = "editCompany";
	private static final String ADD_COMPANY_UI = "addCompanyUI";
	private static final String COMPANY_LIST = "companyList"; 
	
	private static final String CEO = "ceo";
	private static final String CEO_ID = "ceoId";
	private static final String CEO_DETAIL = "ceoDetail";
	
	private static final String STOCK = "stock";
	private static final String STOCK_ID = "stockId";
	private static final String LIST_STOCK = "listStock";
	private static final String STOCK_LIST = "stockList";
	private static final String EDIT_STOCK = "editStock"; 
	
	private static final String REDIRECT = "redirect:";
	private static final String LINE_FLAG = "/";
	
	
	@RequestMapping("/updateStock")
	public String updateStock(@ModelAttribute Stock stock) {
	    Stock localStock = stockService.getById(stock.getId());
	    updateStock(localStock, stock);
        return redirectlistCompanyStr();
	}

	
	@RequestMapping("/delete/{companyId}")
	public String deleteCompany(@PathVariable(COMPANY_ID) long id) {
		companyService.delete(id);
		return redirectlistCompanyStr();
	} 

//	/**
//	 * 得到公司CEO 暂时没用
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping("/showCeo/{companyId}")
//	public ModelAndView showCeoByCompanyId(@PathVariable(COMPANY_ID) long id) {
//		ModelAndView mav = new ModelAndView();
//		StringBuilder vBuilder = new StringBuilder();
//		
//		vBuilder.append(LINE_FLAG).append(COMPANY).append(CEO_DETAIL);
//		mav.setViewName(vBuilder.toString());
//		if (id > 0L) {
//			CEO ceo = companyService.getById(id).getCeo();
//			if (ceo != null) {
//				mav.addObject(CEO, ceo);
//				return mav;
//			}
//		}
//		mav.addObject(CEO, null);
//		return mav;
//	}
	/**
	 * 打开新增公司信息页面
	 * @return
	 */
	@RequestMapping(value="/addCompanyUI", method=RequestMethod.GET)
	public String addCompanyUI() {
	    StringBuilder vBuilder = new StringBuilder();
	    vBuilder.append(LINE_FLAG).append(COMPANY)
	        .append(LINE_FLAG).append(ADD_COMPANY_UI);
		return vBuilder.toString();
	}
	/**
	 * 新增公司信息
	 * @param companyName
	 * @param ceo
	 * @return
	 */
	@RequestMapping(value="/addCompany", method=RequestMethod.POST)
	public String addCompany(@RequestParam(value=COMPANY_NAME, required=true) String companyName,
			@ModelAttribute CEO ceo) {
		if (ceo != null && !StringUtils.isEmpty(companyName)) {
			ceoService.save(ceo);
			if (companyService.getByCompanyName(companyName) == null) {
				Company company = new Company();
				company.setCompanyName(companyName);
				company.setCeo(ceo);
				companyService.save(company);
			}
		}
			
		return redirectlistCompanyStr();
	}
	/**
	 * 公司信息列表
	 * @return
	 */
	@RequestMapping(value="/listCompany", method = RequestMethod.GET)
	public ModelAndView listCompany() {
		List<Company> list = companyService.findAll();
		List<String[]> infoList = new ArrayList<String[]>();
		for (Company company : list) {
		    String[] item = new String[6];
		    item[0] = company.getCompanyName();
		      //隐函数据
            item[4] = String.format("%s", company.getId());
            
		    CEO ceo = company.getCeo();
		    if (ceo != null) {
		        item[1] = ceo.getName();		        
		    } else {
		        item[1] = null;
		    }
		    
		    Stock stock = company.getStock();
		    if (stock != null) {
		        item[2] = stock.getStockCode();	
		        //隐藏数据
		        item[5] = String.format("%s", stock.getId());
		    } else {
		        item[2] = null;
		        item[5] = null;
		    }
		    
		    Collection<FinancialStatement> statements = company.getFinancialStatements();
		    if (statements != null && !statements.isEmpty()) {
		        item[3] = String.format("%s", statements.size());
		    } else {
		        item[3] = null;
		    }

		    infoList.add(item);
		}
		ModelAndView modelAndView = new ModelAndView();
		if (list != null && !list.isEmpty()) {
			modelAndView.addObject(COMPANY_LIST, infoList);
		} else {
			modelAndView.addObject(COMPANY_LIST, new ArrayList<String[]>());
		}
		
		StringBuilder vBuilder = new StringBuilder();
		vBuilder.append(LINE_FLAG).append(COMPANY)
		    .append(LINE_FLAG).append(LIST_COMPANY);
		modelAndView.setViewName(vBuilder.toString());			
		return modelAndView;
	}
	/**
	 * 编辑公司信息页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/editCompanyUI/{companyId}", method=RequestMethod.GET)
	public ModelAndView editCompanyUI(@PathVariable(COMPANY_ID) long id) {
		ModelAndView modelAndView = new ModelAndView();
		Company company = companyService.getById(id);
		
		StringBuilder vBuilder = new StringBuilder();
		if (company != null) {
		    vBuilder.append(LINE_FLAG);
		    vBuilder.append(COMPANY).append(LINE_FLAG).append(EDIT_COMPANY);
			modelAndView.addObject(COMPANY, company);
		} else {
		    vBuilder.append(redirectlistCompanyStr());
		}
		modelAndView.setViewName(vBuilder.toString());
		return modelAndView;	
	}
	/**
	 * 更新公司及ceo信息
	 * @param id
	 * @param companyName
	 * @param ceo
	 * @return
	 */
	@RequestMapping(value="/updateCompany", method=RequestMethod.POST)
	public String updateCompany(@RequestParam(COMPANY_ID) long id,
			@RequestParam(COMPANY_NAME) String companyName,
			@ModelAttribute CEO ceo) {
		
	    Company company = companyService.getById(id);
		if (ceo != null) {
	        CEO ceo2 = company.getCeo();
	        updateCEO(ceo, ceo2);
		}
		
		company.setCompanyName(companyName);
		companyService.update(company);
		
		return redirectlistCompanyStr();
	}
	/**
	 * 更新CEO数据
	 * @param ceo
	 * @param ceo2
	 */
	public void updateCEO(CEO ceo, CEO ceo2) {
        ceo2.setAge(ceo.getAge());
        ceo2.setDescription(ceo.getDescription());
        ceo2.setDoctorSchool(ceo.getDoctorSchool());
        ceo2.setEducation(ceo.getEducation());
        ceo2.setHomeTown(ceo.getHomeTown());
        ceo2.setName(ceo.getName());
        ceo2.setPostGraduate(ceo.getPostGraduate());
        ceo2.setSex(ceo.getSex());
        ceo2.setUniversity(ceo.getUniversity());
        ceoService.update(ceo2);
	}
	/**
	 * 更新股票
	 * @param localStock
	 * @param stock
	 */
	public void updateStock(Stock localStock, Stock stock) {
	    localStock.setMarketListingTime(stock.getMarketListingTime());
	    localStock.setStockCode(stock.getStockCode());
	    localStock.setStockFlag(stock.getStockFlag());
	    localStock.setTotalStockNum(stock.getTotalStockNum());
	    localStock.setUnit(stock.getUnit());
	    stockService.update(localStock);
	}
	
	@ModelAttribute("company")
	public Company getCompany() {
		Company company = new Company();
		return company;
	}
	/**
	 * 返回   重定向显示公司列表字符串
	 * @return
	 */
	public static String redirectlistCompanyStr() {
       StringBuilder vBuilder = new StringBuilder();
        vBuilder.append(REDIRECT).append(LINE_FLAG)
            .append(COMPANY).append(LINE_FLAG)
            .append(LIST_COMPANY);
        return vBuilder.toString();
	}
}
