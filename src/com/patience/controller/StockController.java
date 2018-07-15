package com.patience.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
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
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.patience.entity.CheckSheet;
import com.patience.entity.Company;
import com.patience.entity.Stock;
import com.patience.entity.StockPrice;
import com.patience.service.CompanyService;
import com.patience.service.StockPriceService;
import com.patience.service.StockService;


@Controller
@Transactional
@RequestMapping("/stock")
@SessionAttributes("stock")
public class StockController {
    
    
    @Resource
    private StockService stockService;
    
    @Resource
    private StockPriceService stockPriceService;
    
    @Resource
    private CompanyService companyService;
    
    private static final String COMPANY = "company";
    private static final String COMPANY_ID = "companyId";
    private static final String COMPANY_NAME = "companyName";
    private static final String LIST_COMPANY = "listCompany";
    private static final String STOCK = "stock";
    private static final String STOCK_ID = "stockId";
    private static final String STOCK_CODE = "stockCode";
    private static final String LIST_STOCK = "listStock";
    private static final String ADD_STOCK = "addStock";
    private static final String ADD_STOCK_PRICE = "addStockPrice";
    private static final String LIST_STOCK_PRICE = "listStockPrice";
    private static final String STOCK_LIST = "stockList";
    private static final String LINE_FLAG = "/";
    private static final String EDIT_STOCK = "editStock"; 
    private static final String REDIRECT = "redirect:";
    
    /**
     * 删除股票
     * @param id
     * @return
     */
    @RequestMapping("/deleteStock/{companyId}")
    public String deleteStock(@PathVariable(COMPANY_ID) long id) {
    	Company company = companyService.getById(id);
    	if (company != null) {
    		Stock stock = company.getStock();
    		if (stock != null) {
    			long stockId = stock.getId();
    			company.setStock(null);
    			companyService.update(company);
    			stock = null;
    			stockService.delete(stockId);
    		}
    	}
    	StringBuilder vBuilder = new StringBuilder();
    	vBuilder.append(REDIRECT)
    		.append(LINE_FLAG).append(COMPANY)
    		.append(LINE_FLAG).append(LIST_COMPANY);
    	return vBuilder.toString(); 
    }
    
    @RequestMapping("/viewStock/{stockId}")
    public ModelAndView viewStock(@PathVariable(STOCK_ID) long id) {
    	Stock stock = stockService.getById(id);
    	ModelAndView modelAndView = new ModelAndView();
    	StringBuilder vBuilder = new StringBuilder();
    	
    	vBuilder.append(LINE_FLAG).append(STOCK)
    	    .append(LINE_FLAG).append(LIST_STOCK);
    	modelAndView.setViewName(vBuilder.toString());
    	
    	List<Stock> stockList = new ArrayList<>();
    	stockList.add(stock);
    	modelAndView.addObject(STOCK_LIST, stockList);
    	return modelAndView;
    }
    
    @RequestMapping(value="/listStockPrice/{stockId}", method=RequestMethod.GET)
    public ModelAndView listStockPrice(@PathVariable(STOCK_ID) long stockId) {
    	Stock stock = stockService.getById(stockId);
    	ModelAndView modelAndView = new ModelAndView();
    	
    	if (stock != null) {
    	    StringBuilder vBuilder = new StringBuilder();
    	    vBuilder.append(LINE_FLAG).append(STOCK)
    	        .append(LINE_FLAG).append(LIST_STOCK_PRICE);
    		modelAndView.setViewName(vBuilder.toString());
    		Collection<StockPrice> priceList = stock.getStockPriceList();
 
    		List<StockPrice> list = new ArrayList<>(priceList);
    		if (list != null && !list.isEmpty()) {
    		    modelAndView = showPriceList(list, modelAndView);  
    		} 
    	} else {
    		modelAndView.setViewName("/admin/dashboard");
    	}
    	return modelAndView;
    }
    /**
     * 增加估价
     * @param stockId
     * @param stockCode
     * @param markDate
     * @param price
     * @return
     */
    @RequestMapping(value="/addStockPrice", method = RequestMethod.POST)
    public String addStockPrice(@RequestParam(STOCK_ID) long stockId,
    	@ModelAttribute StockPrice price) {
    	if (price != null) {
    		Stock stock = stockService.getById(stockId);
    		if (stock != null) {
    			//保存股价
    			if (price.getMarkDate() == null) {
    				price.setMarkDate(new Date());
    			}
    			price.setStock(stock);
    			stockPriceService.save(price);
    		}
    	}
    	StringBuilder vBuilder = new StringBuilder();
    	vBuilder.append(REDIRECT).append(LINE_FLAG).append(STOCK)
    	    .append(LINE_FLAG).append(LIST_STOCK);
    	return vBuilder.toString();	
    }
    
    @RequestMapping(value="/addStockPriceUI/{stockId}",method=RequestMethod.GET)
    public ModelAndView addStockPriceUI(@PathVariable(STOCK_ID) long stockId) {
    	Stock stock = stockService.getById(stockId);
    	ModelAndView modelAndView = new ModelAndView();
    	StringBuilder vBuilder = new StringBuilder();
    	vBuilder.append(LINE_FLAG).append(STOCK)
    	    .append(LINE_FLAG).append(ADD_STOCK_PRICE);
    	
    	modelAndView.setViewName(vBuilder.toString());
    	modelAndView.addObject(STOCK_ID, stockId);
    	modelAndView.addObject(STOCK_CODE, stock.getStockCode());
    	return modelAndView;
    }
    /**
     * 股票列表
     * @return
     */
    @RequestMapping(value="/listStock", method=RequestMethod.GET)
    public ModelAndView listStock() {
    	ModelAndView modelAndView = new ModelAndView();
    	StringBuilder vBuilder = new StringBuilder();
    	vBuilder.append(LINE_FLAG).append(STOCK)
    	    .append(LINE_FLAG).append(LIST_STOCK);	
    	modelAndView.setViewName(vBuilder.toString());
    	
    	List<Stock> stockList = stockService.findAll();
    	List<String[]> priceList = showInfoList(stockList);
 
    	
    	modelAndView.addObject(STOCK_LIST, priceList);
    	return modelAndView;
    }
    /**
    * 得到股票通过id
    * @param id
    * @return
    */
   @RequestMapping("/showStock/{stockId}")
   public ModelAndView getStockByCompanyId(@PathVariable(STOCK_ID) long id) {
       StringBuilder vBuilder = new StringBuilder();
       ModelAndView modelAndView = new ModelAndView();
       
       Stock stock = stockService.getById(id);
       
       vBuilder.append(LINE_FLAG).append(STOCK).append(LINE_FLAG).append(EDIT_STOCK);
       modelAndView.setViewName(vBuilder.toString());
       
       if (stock != null) {
           List<Stock> stockList = new ArrayList<Stock>();
           stockList.add(stock);
           modelAndView.addObject(STOCK, stock);
           return modelAndView;
       }

       modelAndView.addObject(STOCK, null);
       return modelAndView;
   }
    /**
     * 增加股票 界面
     * @return
     */
    @RequestMapping(value="/addStockUI/{companyId}", method = RequestMethod.GET)
    public ModelAndView addStockUI(@PathVariable(COMPANY_ID) long id) {
    	Company company = companyService.getById(id);
    	ModelAndView view = new ModelAndView();
    	view.addObject(COMPANY_NAME, company.getCompanyName());
    	StringBuilder vBuilder = new StringBuilder();
    	vBuilder.append(LINE_FLAG).append(STOCK)
    	    .append(LINE_FLAG).append(ADD_STOCK);

    	view.setViewName(vBuilder.toString());
        return view;   
    }
   /**
    * 保存新增的股票
    * @param companyName
    * @param stock
    * @return
    */
    @RequestMapping(value = "/addStock", method = RequestMethod.POST)
    public String addStock(@RequestParam(COMPANY_NAME) String companyName,
            @ModelAttribute Stock stock) {      
    	ModelAndView modelAndView = new ModelAndView();

    	if (stock != null) {
    		stockService.save(stock);
    		Company company = companyService.getByCompanyName(companyName);
    		company.setStock(stock);
    		companyService.update(company);
    		
    	}        	
    	StringBuilder vBuilder = new StringBuilder();
    	vBuilder.append(REDIRECT).append(LINE_FLAG).append(STOCK)
    	    .append(LINE_FLAG).append(LIST_STOCK);
        return vBuilder.toString();
    }
    /**
     * 生成要显示的股票信息
     * @param list
     * @return
     */
    public List<String[]> showInfoList(List<Stock> list) {
        List<String[]> infoList = new ArrayList<String[]>();
        for (Stock stock : list) {
            String[] info = new String[6];
            info[0] = String.format("%s", stock.getId());
            info[1] = stock.getStockCode();
            if (stock.getMarketListingTime() != null) {
                info[2] = stock.getMarketListingTime().toString();                
            }
            info[3] = String.format("%s", stock.getStockFlag());
            info[4] = String.format("%s", stock.getTotalStockNum());
            Collection<StockPrice> prices = stock.getStockPriceList();
            List<StockPrice> priceList = new ArrayList<>(prices);
            if (prices != null && !prices.isEmpty()) {
                StockPrice price = priceList.get(priceList.size() - 1);
                info[5] = String.format("%s", price.getPrice());
            }
            infoList.add(info);
        }
        return infoList;
    }
    /**
     * 生成股价趋势图信息
     * @param prices
     * @param modelAndView
     */
    public ModelAndView showPriceList(List<StockPrice> prices, ModelAndView modelAndView) {
        if (prices.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                StockPrice price = prices.get(i);
                //股价
                String priceKey = String.format("price%s", i+"");
                modelAndView.addObject(priceKey, price.getPrice());
                
                //时间
                String timeKey = String.format("aa%s", i+"");
                String[] timeArrs = price.getMarkDate().toString().split(" ")[0].split("-");
                
              
                modelAndView.addObject(timeKey, String.format("%s%s%s", timeArrs[0], timeArrs[1], timeArrs[2]));
            }
        } else {
            for (int i = 0; i < prices.size(); i++) {
                StockPrice price = prices.get(i);
                //股价
                String priceKey = String.format("price%s", i+"");
                modelAndView.addObject(priceKey, price.getPrice());
                
                //时间
                String timeKey = String.format("aa%s", i+"");
                modelAndView.addObject(timeKey, price.getMarkDate().toString().split(" ")[0]);
            }
            StockPrice tempPrice = prices.get(prices.size() - 1);
            for (int i = prices.size(); i < 10; i++) {
                //股价
                String priceKey = String.format("price%s", i+"");
                modelAndView.addObject(priceKey, tempPrice.getPrice());
                
                //时间
                String timeKey = String.format("aa%s", i+"");
                
                modelAndView.addObject(timeKey, tempPrice.getMarkDate().toString().split(" ")[0]);
            }
        }
        return modelAndView;
       
    }
    
    /**
     * 放在域中
     * @return
     */
    @ModelAttribute(STOCK)
    public Stock getStock() {
        Stock stock = new Stock();
        stock.setStockFlag(1);
        return stock;
    }

}
