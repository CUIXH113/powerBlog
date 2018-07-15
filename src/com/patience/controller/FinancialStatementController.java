package com.patience.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.patience.entity.Assets;
import com.patience.entity.BalanceSheet;
import com.patience.entity.CashFlowStatement;
import com.patience.entity.Company;
import com.patience.entity.FinancialStatement;
import com.patience.entity.FinancingActivitiyCashFlow;
import com.patience.entity.InvestmentCashFlow;
import com.patience.entity.Liability;
import com.patience.entity.LiquidAssets;
import com.patience.entity.LiquidDebt;
import com.patience.entity.NonLiquidAssets;
import com.patience.entity.NonLiquidDebt;
import com.patience.entity.OperatingCashFlow;
import com.patience.entity.OwnerEquity;
import com.patience.entity.ProfitStatement;
import com.patience.service.AssetService;
import com.patience.service.BalanceSheetService;
import com.patience.service.CashFlowStatementService;
import com.patience.service.CompanyService;
import com.patience.service.FinancialStatementService;
import com.patience.service.FinancingActivitiyCashFlowService;
import com.patience.service.InvestmentCashFlowService;
import com.patience.service.LiabilityService;
import com.patience.service.LiquidAssetService;
import com.patience.service.LiquidDebtService;
import com.patience.service.NonLiquidAssetService;
import com.patience.service.NonLiquidDebtService;
import com.patience.service.OperatingCashFlowService;
import com.patience.service.OwnerEquityService;
import com.patience.service.ProfitStatementService;
import com.sun.java.swing.plaf.motif.resources.motif;
import com.sun.swing.internal.plaf.metal.resources.metal;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;


/**
 * 财务报表控制层
 * @author Administrator
 *
 */
@Controller
@Transactional
@RequestMapping("/financialStatement")
public class FinancialStatementController {
	
    
    /**资产负债表添加页面*/
    private static final int BALANCESHEET = 1;
    /**现金流量表添加页面*/
    private static final int CASHFLOWSHEET = 2;
    /**利润表添加页面*/
    private static final int PROFITSHEET = 3;
    
	@Resource
	private CompanyService companyService;
	/**
	 * 财务报表服务
	 */
	@Resource
	private FinancialStatementService financialStatementService;
	///////////////////资产负债表服务层类//////////////////////////////////
	/**
	 * 资产负债表
	 */
	@Resource
	private BalanceSheetService balanceSheetService;
	/**
	 * 资产服务
	 */
	@Resource
	private AssetService assetService;
	@Resource
	private LiquidAssetService liquidAssetService;
	@Resource
	private NonLiquidAssetService nonliquidAssetService;
	/**
	 * 负债服务
	 */
	@Resource
	private LiabilityService liabilityService;
	/////////////////属于负债里面的子服务///////////////
	@Resource
	private NonLiquidDebtService nonLiquidDebtService;
	@Resource
	private LiquidDebtService liquidDebtService;
	@Resource
	private OwnerEquityService ownerEquityService;
	
	///////////////////////现金流量表服务层/////////////////////////////////////
	/**
	 * 现金流量表
	 */
	@Resource
	private CashFlowStatementService cashFlowStatementService;
	/**
	 * 经营活动的现金流量服务层
	 */
	@Resource
	private OperatingCashFlowService operatingCashFlowService;
	/**
	 * 投资活动现金流量表
	 */
	@Resource
	private InvestmentCashFlowService investmentCashFlowService;
	/**
	 * 融资活动现金流服务
	 */
	@Resource
	private FinancingActivitiyCashFlowService financingActivitiyCashFlowService;
	
	////////////////////////利润表服务////////////////////////////////////////
	@Resource
	private ProfitStatementService profitStatementService;
	/**
	 * 重定向字符串
	 */
	private static final String REDIRECT = "redirect:";
	/**
	 * 父节点
	 */
	private static final String FINANCIAL_STATEMENT = "financialStatement";
	/**
	 * 财报列表页面
	 */
	private static final String LIST_FINANCIAL_STATEMENT = "listFinancialStatement";
	/**
	 * 添加三种表列表页面
	 */
	private static final String ADD_STATEMENT_UI = "addStatementUI";
	private static final String CONFIG_FINANCIAL_STATEMENT = "editFinancialStatement";
	
	private static final String ADD_BALANCE_SHEET = "addBalanceSheet";
	private static final String ADD_CASHFLOW_SHEET = "addCashFlowSheet";
	private static final String ADD_PROFIT_SHEET = "addProfitSheet";
	
    private static final String EDIT_BALANCE_SHEET = "editBalanceSheet";
    private static final String EDIT_CASHFLOW_SHEET = "editCashFlowSheet";
    private static final String EDIT_PROFIT_SHEET = "editProfitSheet";
	
	private static final String LINE_FLAG = "/";
	/**
	 * 财报list的key
	 */
	private static final String STATEMENTS = "statements";
	private static final String COMPANY_ID = "companyId";
	private static final String STATEMENT_ID = "statementId";
	private static final String COMPANY_NAME = "companyName";
	private static final String SHEET_FLAG = "sheetFlag";
	
	private static final String BALANCE_SHEET_ID = "balanceSheetId";
	private static final String CASHFLOW_SHEET_ID = "cashFlowSheetId";
	private static final String PROFIT_SHEET_ID = "profitSheetId";
	
	private static final String BALANCE_SHEET = "balanceSheet";
	private static final String CASHFLOW_SHEET = "cashFlowSheet";
	private static final String PROFIT_SHEET = "profitSheet";
	
	
	private static final String COMPANY = "company";
	private static final String LIST_COMPANY = "listCompany";
	
	@RequestMapping("/deleteSheet/{statementId}/{sheetFlag}")
	public String deleteChildSheet(@PathVariable(STATEMENT_ID) long id,
	        @PathVariable(SHEET_FLAG) int sheetFlag) {
	    FinancialStatement statement = financialStatementService.getById(id);
	    if (sheetFlag == BALANCESHEET) {
	        BalanceSheet balanceSheet = statement.getBalanceSheet();
	        statement.setBalanceSheet(null);
	        balanceSheetService.delete(balanceSheet.getId());
	    } else if (sheetFlag == CASHFLOWSHEET) {
	        CashFlowStatement cashFlowStatement = statement.getCashFlowStatement();
	        statement.setCashFlowStatement(null);
	        cashFlowStatementService.delete(cashFlowStatement.getId());
	    } else if (sheetFlag == PROFITSHEET) {
	        ProfitStatement profitStatement = statement.getProfitStatement();
	        statement.setProfitStatement(null);
	        profitStatementService.delete(profitStatement.getId());
	    }
	    
	    financialStatementService.update(statement);
	    StringBuilder vBuilder = new StringBuilder();
        vBuilder.append(REDIRECT).append(LINE_FLAG).append(COMPANY)
            .append(LINE_FLAG).append(LIST_COMPANY);
        return vBuilder.toString();
	    
	}
	
	@RequestMapping("/delete/{statementId}")
	public String deleteFinancialStatement(@PathVariable(STATEMENT_ID) long id) {
	    financialStatementService.delete(id);
    
	    StringBuilder vBuilder = new StringBuilder();
        vBuilder.append(REDIRECT).append(LINE_FLAG).append(COMPANY)
            .append(LINE_FLAG).append(LIST_COMPANY);
        return vBuilder.toString();
	}
	
	/**
	 * 根据公司id，显示财报列表
	 * @param id
	 * @return
	 */
	@RequestMapping("/listFinancialStatement/{companyId}")
	public ModelAndView listFinancialStatement(@PathVariable(COMPANY_ID) long id) {
		Company company = companyService.getById(id);
		Collection<FinancialStatement> statements = company.getFinancialStatements();
		StringBuilder vBuilder = new StringBuilder();
		vBuilder.append(LINE_FLAG).append(FINANCIAL_STATEMENT).append(LINE_FLAG)
		    .append(LIST_FINANCIAL_STATEMENT);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(vBuilder.toString());
		modelAndView.addObject(STATEMENTS, statements);
		return modelAndView;
	}
	/**
	 * 添加 三张表的页面接口
	 * @param id : 财报id
	 * @param flag : 子表类型
	 * @return
	 */
	@RequestMapping("/addChildSheetUI/{companyId}/{statementId}/{sheetFlag}")
	public ModelAndView addChildSheetUI(@PathVariable(STATEMENT_ID) long statementId,
	        @PathVariable(COMPANY_ID) long companyId,
			@PathVariable(SHEET_FLAG) int flag) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(STATEMENT_ID, statementId);
		modelAndView.addObject(COMPANY_ID, companyId);
		//查出公司名字
		
		StringBuilder vBuilder = new StringBuilder();
		if ( flag == BALANCESHEET ) {
		    vBuilder.append(LINE_FLAG).append(FINANCIAL_STATEMENT).append(LINE_FLAG)
		        .append(ADD_BALANCE_SHEET);
		} else if ( flag == CASHFLOWSHEET ) {
		    vBuilder.append(LINE_FLAG).append(FINANCIAL_STATEMENT).append(LINE_FLAG)
		        .append(ADD_CASHFLOW_SHEET);
		} else if ( flag == PROFITSHEET ) {
		    vBuilder.append(LINE_FLAG).append(FINANCIAL_STATEMENT).append(LINE_FLAG)
		        .append(ADD_PROFIT_SHEET);
		}
		modelAndView.setViewName(vBuilder.toString());
		return modelAndView;
	}
	/**
	 * 通过公司id跳转到添加子财报页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/addStatementUI/{companyId}")
	public ModelAndView addStatementUI(@PathVariable(COMPANY_ID) long id) {
		Company company = companyService.getById(id);
		ModelAndView modelAndView = new ModelAndView();

		Collection<FinancialStatement> list = company.getFinancialStatements();	
		
		List<String[]> idStrings = new ArrayList<>();
		for (FinancialStatement statement : list) {
		    String[] map = new String[7];
		    map[0] = String.format("%s", statement.getId());
		    if (statement.getBalanceSheet() != null) {//balanceSheetId
		        map[1] = String.format("%s", statement.getBalanceSheet().getId());		        
		    } else {		        
		        map[1] = null;	        
		    }
		    
		    if (statement.getCashFlowStatement() != null) {//cashFlowSheetId
		        map[2] = String.format("%s", statement.getCashFlowStatement().getId());		        
		    } else {
		        map[2] = null;		        
		    }
		    
		    if (statement.getProfitStatement() != null) {
		        map[3] = String.format("%s", statement.getProfitStatement().getId());        		        
		    } else {		        
		        map[3] = null;        	        
		    }
		    map[4] = String.format("%s", statement.getSheetFlag());
		    map[5] = statement.getCreateTime().toString();
		    map[6] = statement.getStatementDate().toString();
		    idStrings.add(map);
		}

		
	    StringBuilder vBuilder = new StringBuilder();
	    vBuilder.append(LINE_FLAG).append(FINANCIAL_STATEMENT).append(LINE_FLAG)
	        .append(ADD_STATEMENT_UI);
		modelAndView.setViewName(vBuilder.toString());
		modelAndView.addObject("ids", idStrings);
		modelAndView.addObject(COMPANY_NAME, company.getCompanyName());
		modelAndView.addObject(COMPANY_ID, company.getId());

		return modelAndView;
	}
	/**
	 * 增加财报，跳转到 财报配置页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/addFinancialStatement/{companyId}")
	public ModelAndView addFinancialStatement(@PathVariable(COMPANY_ID) long id) {
	    
	    Company company = companyService.getById(id);
	    StringBuilder vBuilder = new StringBuilder();
	    ModelAndView modelAndView = new ModelAndView();
	    
	    if ( company != null ) {
	       modelAndView.addObject(COMPANY_ID, company.getId());
	       vBuilder.append(LINE_FLAG).append(FINANCIAL_STATEMENT)
	           .append(LINE_FLAG).append(CONFIG_FINANCIAL_STATEMENT); 
	    } else {
	        vBuilder.append(REDIRECT).append(LINE_FLAG)
	            .append(COMPANY).append(LINE_FLAG).append(LIST_COMPANY);
	    }
	    modelAndView.setViewName(vBuilder.toString());;
	    return modelAndView;
	}
	/**
	 * 配置新建的财报信息
	 * @param companyId
	 * @param statement
	 * @return
	 */
	@RequestMapping("/configFinancialStatement")
	public String configFinancialStatement(@RequestParam(COMPANY_ID) long companyId,
	        @ModelAttribute FinancialStatement statement) {
	    Company company = companyService.getById(companyId);
	    if (company != null) {
	        statement.setCompany(company);
	        financialStatementService.save(statement);
	    } 
	    
      StringBuilder vBuilder = new StringBuilder();
      vBuilder.append(REDIRECT).append(LINE_FLAG).append(FINANCIAL_STATEMENT)
          .append(LINE_FLAG).append(ADD_STATEMENT_UI).append(LINE_FLAG).append(companyId);
      return vBuilder.toString();
	}
	
	@RequestMapping("/editProfitStatement")
	public String editProfitStatement(@ModelAttribute ProfitStatement profitStatement) {
	    ProfitStatement profit = profitStatementService.getById(profitStatement.getId());
	    
	    updateProfitStatement(profit, profitStatement);
	    
        StringBuilder vBuilder = new StringBuilder();
        vBuilder.append(REDIRECT).append(LINE_FLAG).append(COMPANY)
           .append(LINE_FLAG).append(LIST_COMPANY);
        return vBuilder.toString(); 
	}
	
	/**
	 * 增加利润表
	 * @param profitStatement
	 * @param companyId
	 * @param statementId
	 * @return
	 */
	@RequestMapping("/addProfitStatement")
	public String addProfitStatement(
			@ModelAttribute ProfitStatement profitStatement,
			@RequestParam(COMPANY_ID) long companyId,
			@RequestParam(STATEMENT_ID) long statementId){
	
		FinancialStatement statement = financialStatementService.getById(statementId);
		statement.setProfitStatement(profitStatement);
		profitStatementService.save(profitStatement);
		financialStatementService.update(statement);

        StringBuilder vBuilder = new StringBuilder();
        vBuilder.append(REDIRECT).append(LINE_FLAG).append(FINANCIAL_STATEMENT)
            .append(LINE_FLAG).append(ADD_STATEMENT_UI).append(LINE_FLAG).append(companyId);
        return vBuilder.toString();
	}
	/**
	 * 修改现金流量表
	 * @param operatingCashFlow
	 * @param investmentCashFlow
	 * @param financingActivitiyCashFlow
	 * @param statementId
	 * @return
	 */
	@RequestMapping("/editCashFlowSheet")
	public String editCashFlowSheet(@ModelAttribute OperatingCashFlow operatingCashFlow,
            @ModelAttribute InvestmentCashFlow investmentCashFlow,
            @ModelAttribute FinancingActivitiyCashFlow financingActivitiyCashFlow,
            @RequestParam(CASHFLOW_SHEET_ID) long statementId) {
	    
	     CashFlowStatement flowStatement = cashFlowStatementService.getById(statementId);
	     updateCashFlowSheet(flowStatement, operatingCashFlow, investmentCashFlow, financingActivitiyCashFlow);
	     
	     StringBuilder vBuilder = new StringBuilder();
	     vBuilder.append(REDIRECT).append(LINE_FLAG).append(COMPANY)
            .append(LINE_FLAG).append(LIST_COMPANY);
	     return vBuilder.toString(); 
	}
	/**
	 * 新增现金流量表
	 * @param operatingCashFlow
	 * @param investmentCashFlow
	 * @param financingActivitiyCashFlow
	 * @param statementId
	 * @param companyId
	 * @return
	 */
	@RequestMapping("/addCashFlowSheet")
	public String addCashFlowStatement(@ModelAttribute OperatingCashFlow operatingCashFlow,
			@ModelAttribute InvestmentCashFlow investmentCashFlow,
			@ModelAttribute FinancingActivitiyCashFlow financingActivitiyCashFlow,
			@RequestParam(STATEMENT_ID) long statementId,
			@RequestParam(COMPANY_ID) long companyId) {
		
		FinancialStatement statement = financialStatementService.getById(statementId);
		
		/*先保存小的*/
		financingActivitiyCashFlow.initialTotalNum();
		operatingCashFlowService.save(operatingCashFlow);
		investmentCashFlowService.save(investmentCashFlow);
		financingActivitiyCashFlowService.save(financingActivitiyCashFlow);
		/*再保存大的*/
		CashFlowStatement cashFlowStatement = new CashFlowStatement();
		cashFlowStatement.setInvestmentCashFlow(investmentCashFlow);
		cashFlowStatement.setOperatingCashFlow(operatingCashFlow);
		cashFlowStatement.setFinancingActivitiyCashFlow(financingActivitiyCashFlow);
		cashFlowStatementService.save(cashFlowStatement);
		
		statement.setCashFlowStatement(cashFlowStatement);
		financialStatementService.update(statement);
		
        StringBuilder vBuilder = new StringBuilder();
        vBuilder.append(REDIRECT).append(LINE_FLAG).append(FINANCIAL_STATEMENT)
            .append(LINE_FLAG).append(ADD_STATEMENT_UI).append(LINE_FLAG).append(companyId);
        return vBuilder.toString();
	}
	/**
	 * 修改资产负债表
	 * @param liquidAssets
	 * @param nonLiquidAssets
	 * @param liquidDebt
	 * @param nonLiquidDebt
	 * @param ownerEquity
	 * @param balanceSheetId
	 * @return
	 */
	@RequestMapping("/editBalanceSheet")
	public String editBalanceSheet(@ModelAttribute LiquidAssets liquidAssets,//流动资产, 
            @ModelAttribute NonLiquidAssets nonLiquidAssets,//非流动资产
            @ModelAttribute LiquidDebt liquidDebt,//流动负债
            @ModelAttribute NonLiquidDebt nonLiquidDebt,//非流动负债
            @ModelAttribute OwnerEquity ownerEquity,//所有者权益
            @RequestParam(BALANCE_SHEET_ID) long balanceSheetId) {
	    
	    BalanceSheet sheet = balanceSheetService.getById(balanceSheetId);
	    Assets assets = sheet.getAssets();
	    Liability liability  = sheet.getLiability();
	    
	    updateAssets(assets, liquidAssets, nonLiquidAssets);
	    updateLiability(liability, liquidDebt, nonLiquidDebt, ownerEquity);
	    
        StringBuilder vBuilder = new StringBuilder();
        vBuilder.append(REDIRECT).append(LINE_FLAG).append(COMPANY)
            .append(LINE_FLAG).append(LIST_COMPANY);
        return vBuilder.toString();

	}
	/**
	 * 新增资产负债表接口
	 * @param liquidAssets
	 * @param nonLiquidAssets
	 * @param liquidDebt
	 * @param nonLiquidDebt
	 * @param ownerEquity
	 * @param companyId
	 * @return
	 */
	@RequestMapping("/addBalanceSheet")
	public String addBalanceSheet(@ModelAttribute LiquidAssets liquidAssets,//流动资产, 
	        @ModelAttribute NonLiquidAssets nonLiquidAssets,//非流动资产
	        @ModelAttribute LiquidDebt liquidDebt,//流动负债
	        @ModelAttribute NonLiquidDebt nonLiquidDebt,//非流动负债
	        @ModelAttribute OwnerEquity ownerEquity,//所有者权益
	        @RequestParam(STATEMENT_ID) long statementId,
	        @RequestParam(COMPANY_ID) long companyId
	        ) {
	    //保存子对象
	    liquidAssets.initialTotalNum();
	    liquidAssetService.save(liquidAssets);
	    nonLiquidAssets.initialTotalNum();
	    nonliquidAssetService.save(nonLiquidAssets);

	    //保存资产
	    Assets assets = new Assets();
	    assets.setLiquidAssets(liquidAssets);
	    assets.setNoLiquidAssets(nonLiquidAssets);
	    assets.initialTotalNum();
	    assetService.save(assets);
	    //保存负债
	    liquidDebt.initialTotalNum();
	    liquidDebtService.save(liquidDebt);
	    nonLiquidDebt.initialTotalNum();
	    nonLiquidDebtService.save(nonLiquidDebt);
	    ownerEquity.initialTotalNum();
	    ownerEquityService.save(ownerEquity);
	    
	    Liability liability = new Liability();
	    liability.setLiquidDebt(liquidDebt);
	    liability.setNonLiquidDebt(nonLiquidDebt);
	    liability.setOwnerEquity(ownerEquity);
	    liability.setTotalLiability(liquidDebt.getTotalLiquidDebt() 
	    		+ nonLiquidDebt.getTotalNonLiquidDebt() + ownerEquity.getTotalOwnerEquity());
	    liabilityService.save(liability);
	    //保存资产负债表
	    BalanceSheet balanceSheet = new BalanceSheet();
	    balanceSheet.setAssets(assets);
	    balanceSheet.setLiability(liability);
	    balanceSheetService.save(balanceSheet);
	    
	    balanceSheetService.save(balanceSheet);
	    FinancialStatement statement = financialStatementService.getById(statementId);
	    statement.setBalanceSheet(balanceSheet);
	    financialStatementService.update(statement);

        StringBuilder vBuilder = new StringBuilder();
        vBuilder.append(REDIRECT).append(LINE_FLAG).append(FINANCIAL_STATEMENT)
            .append(LINE_FLAG).append(ADD_STATEMENT_UI).append(LINE_FLAG).append(companyId);
        return vBuilder.toString();
	}	
	/**
	 * 显示财报字表
	 * @param sheetflag ：字表类型
	 * @param sheetId ：字表id
	 * @return
	 */
	@RequestMapping(value = "/showSheet/{sheetflag}/{sheetId}", method = RequestMethod.GET)
	public ModelAndView addCashFlowSheet(@PathVariable("sheetflag") int sheetflag,//表类型
	        @PathVariable("sheetId") long sheetId) {//表id
	    
	    ModelAndView modelAndView = new ModelAndView();
	    StringBuilder vBuilder = new StringBuilder();
	    vBuilder.append(LINE_FLAG).append(FINANCIAL_STATEMENT).append(LINE_FLAG);
	    /*选择要添加的视图*/
	    if (sheetflag == BALANCESHEET) {
	        BalanceSheet sheet = balanceSheetService.getById(sheetId);
	        modelAndView.addObject(BALANCE_SHEET_ID, sheetId);
	        modelAndView.addObject(BALANCE_SHEET, sheet);
	        vBuilder.append(EDIT_BALANCE_SHEET);
	        	     
	    } else if (sheetflag == CASHFLOWSHEET) {
	        CashFlowStatement flowStatement = cashFlowStatementService.getById(sheetId);
	        modelAndView.addObject(CASHFLOW_SHEET_ID, sheetId);
	        modelAndView.addObject(CASHFLOW_SHEET, flowStatement);
	        vBuilder.append(EDIT_CASHFLOW_SHEET);
	       
	    } else if (sheetflag == PROFITSHEET) {
	        ProfitStatement profitStatement = profitStatementService.getById(sheetId);
	        modelAndView.addObject(PROFIT_SHEET_ID, sheetId);
	        modelAndView.addObject(PROFIT_SHEET, profitStatement);
	        vBuilder.append(EDIT_PROFIT_SHEET);
	       
	    }
	    /*添加属性值*/
	    modelAndView.setViewName(vBuilder.toString());
        return modelAndView;
	}
	
	public void updateProfitStatement(ProfitStatement profit, ProfitStatement profitStatement) {
	    profit.setAssetsImpairmentLoss(profitStatement.getAssetsImpairmentLoss());
        profit.setBenefitsOfFairValueChange(profitStatement.getBenefitsOfFairValueChange());
        profit.setFinanceCharges(profitStatement.getFinanceCharges());
        profit.setIncomeFromInvestment(profitStatement.getIncomeFromInvestment());
        profit.setIncomeTaxExpense(profitStatement.getIncomeTaxExpense());
        profit.setJointVentureIncome(profitStatement.getJointVentureIncome());
        profit.setManagementFees(profitStatement.getManagementFees());
        profit.setNetProfit(profitStatement.getNetProfit());
        profit.setNonOperatingExpenditure(profitStatement.getNonOperatingExpenditure());
        profit.setNonOperatingIncome(profitStatement.getNonOperatingIncome());
        profit.setOperatingCost(profitStatement.getOperatingCost());
        profit.setOperatingExpenses(profitStatement.getOperatingExpenses());
        profit.setOperatingIncome(profitStatement.getOperatingIncome());
        profit.setOperatingProfit(profitStatement.getOperatingProfit());
        profit.setOperatingTaxAndAdditional(profitStatement.getOperatingTaxAndAdditional());
        profit.setTotalProfit(profitStatement.getTotalProfit());
        profitStatementService.update(profit);
	}
	
	/**
	 * 更新现金流量表
	 * @param flowStatement
	 * @param operatingCashFlow
	 * @param investmentCashFlow
	 * @param activitiyCashFlow
	 */
	public void updateCashFlowSheet(CashFlowStatement flowStatement, 
	        OperatingCashFlow operatingCashFlow, 
	        InvestmentCashFlow investmentCashFlow,
	        FinancingActivitiyCashFlow activitiyCashFlow) {
	    
	    OperatingCashFlow operatingCashFlow2 = flowStatement.getOperatingCashFlow();
	    InvestmentCashFlow investmentCashFlow2 = flowStatement.getInvestmentCashFlow();
	    FinancingActivitiyCashFlow activitiyCashFlow2 = flowStatement.getFinancingActivitiyCashFlow();
	    
	    operatingCashFlow2.setPaiedCashAboutOtherOperating(operatingCashFlow.getPaiedCashAboutOtherOperating());
	    operatingCashFlow2.setPaiedCashByBuyGoodsAndService(operatingCashFlow.getPaiedCashByBuyGoodsAndService());
	    operatingCashFlow2.setPaiedKindsTaxes(operatingCashFlow.getPaiedKindsTaxes());
	    operatingCashFlow2.setPaiedCashForEmployee(operatingCashFlow.getPaiedCashForEmployee());
	    operatingCashFlow2.setPureCashNumByOperating(operatingCashFlow.getPureCashNumByOperating());
	    operatingCashFlow2.setReceivedOtherCashAboutOperating(operatingCashFlow.getReceivedOtherCashAboutOperating());
	    operatingCashFlow2.setReceivedTaxReturn(operatingCashFlow.getReceivedTaxReturn());
	    operatingCashFlow2.setSellGoodsAndServiceAcceptedCash(operatingCashFlow.getSellGoodsAndServiceAcceptedCash());
	    operatingCashFlow2.setTotalCashComeIn(operatingCashFlow.getTotalCashComeIn());
	    operatingCashFlow2.setTotalCashGoOut(operatingCashFlow.getTotalCashGoOut());
	    operatingCashFlowService.update(operatingCashFlow2);
	    
	    investmentCashFlow2.setCashPureNumByInvest(investmentCashFlow.getCashPureNumByInvest());
	    investmentCashFlow2.setGainInvestIncomeAcceptedCash(investmentCashFlow.getGainInvestIncomeAcceptedCash());
	    investmentCashFlow2.setIntangibleAssetsIncome(investmentCashFlow.getIntangibleAssetsIncome());
	    investmentCashFlow2.setInvestPaidCash(investmentCashFlow.getInvestPaidCash());
	    investmentCashFlow2.setOtherAssetsPaiedCash(investmentCashFlow.getOtherAssetsPaiedCash());
	    investmentCashFlow2.setOtherCashAboutInvest(investmentCashFlow.getOtherCashAboutInvest());
	    investmentCashFlow2.setOtherPaiedCashAboutInvest(investmentCashFlow.getOtherPaiedCashAboutInvest());
	    investmentCashFlow2.setRetractInvestIncomeAccptedCash(investmentCashFlow.getRetractInvestIncomeAccptedCash());
	    investmentCashFlow2.setTotalCashComeIn(investmentCashFlow.getTotalCashComeIn());
	    investmentCashFlow2.setTotalCashGoOut(investmentCashFlow.getTotalCashGoOut());
	    investmentCashFlowService.update(investmentCashFlow2);
	    
	    activitiyCashFlow2.setAbsorbInvestmentCash(activitiyCashFlow.getAbsorbInvestmentCash());
	    activitiyCashFlow2.setBorrowingCash(activitiyCashFlow.getBorrowingCash());
	    activitiyCashFlow2.setOtherCashAboutFinancing(activitiyCashFlow.getOtherCashAboutFinancing());
	    activitiyCashFlow2.initialTotalNum();
	    financingActivitiyCashFlowService.update(activitiyCashFlow2);
	    
	    
	    
	}
	
	
	
	/**
	 * 更新负债
	 * @param liability
	 * @param liquidDebt
	 * @param nonLiquidDebt
	 * @param ownerEquity
	 */
	public void updateLiability(Liability liability, 
	        LiquidDebt liquidDebt, NonLiquidDebt nonLiquidDebt,
	        OwnerEquity ownerEquity) {
	    
	    LiquidDebt liquidDebt2 = liability.getLiquidDebt();
	    NonLiquidDebt nonLiquidDebt2 = liability.getNonLiquidDebt();
	    OwnerEquity ownerEquity2 = liability.getOwnerEquity();
	    
	    liquidDebt2.setAccountsPayable(liquidDebt.getAccountsPayable());
	    liquidDebt2.setDeferredRevenue(liquidDebt.getDeferredRevenue());
	    liquidDebt2.setOtherDeferredRevenue(liquidDebt.getOtherDeferredRevenue());
	    liquidDebt2.setOtherPayable(liquidDebt.getOtherPayable());
	    liquidDebt2.setShortTermBorrowing(liquidDebt.getShortTermBorrowing());
	    liquidDebt2.initialTotalNum();
	    liquidDebtService.update(liquidDebt2);
	    
	    nonLiquidDebt2.setLongTermBorrow(nonLiquidDebt.getLongTermBorrow());
	    nonLiquidDebt2.setLongTermShouldPay(nonLiquidDebt.getLongTermShouldPay());
	    nonLiquidDebt2.setOtherNonLiquidDebt(nonLiquidDebt.getOtherNonLiquidDebt());
	    nonLiquidDebt2.setShouldPayBond(nonLiquidDebt.getShouldPayBond());
	    nonLiquidDebtService.update(nonLiquidDebt2);
	    
	    ownerEquity2.setCapitalReserves(ownerEquity.getCapitalReserves());
	    ownerEquity2.setPaidInCapita(ownerEquity.getPaidInCapita());
	    ownerEquity2.setRetainedEarnings(ownerEquity.getRetainedEarnings());
	    ownerEquity2.setSurplusReserves(ownerEquity.getSurplusReserves());
	    ownerEquity2.initialTotalNum();
	    ownerEquityService.update(ownerEquity2);
	    
	}
	/**
	 * 更新资产
	 * @param assets
	 * @param liquidAssets
	 * @param nonLiquidAssets
	 */
	public void updateAssets(Assets assets, LiquidAssets liquidAssets, NonLiquidAssets nonLiquidAssets) {
	    LiquidAssets liquidAssets2 = assets.getLiquidAssets();
	    NonLiquidAssets nonLiquidAssets2 = assets.getNoLiquidAssets();
	    
	    liquidAssets2.setAccountsReceivable(liquidAssets.getAccountsReceivable());
	    liquidAssets2.setAdvancePayment(liquidAssets.getAdvancePayment());
	    liquidAssets2.setInventory(liquidAssets.getInventory());
	    liquidAssets2.setMonetaryFund(liquidAssets.getMonetaryFund());
	    liquidAssets2.setOtherLiquidAssets(liquidAssets.getOtherLiquidAssets());
	    liquidAssets2.setPrepaidExpenses(liquidAssets.getPrepaidExpenses());
	    liquidAssets2.setReceivableOther(liquidAssets.getReceivableOther());
	    liquidAssets2.initialTotalNum();
	    liquidAssetService.update(liquidAssets2);
	    
	    nonLiquidAssets2.setLongTermInvestment(nonLiquidAssets.getLongTermInvestment());
	    nonLiquidAssets2.setOtherAssets(nonLiquidAssets.getOtherAssets());
	    nonLiquidAssets2.setSolidAssets(nonLiquidAssets.getSolidAssets());
	    nonLiquidAssets2.initialTotalNum();
	    nonliquidAssetService.update(nonLiquidAssets2);
	}
	
/*	*//**
	 * 显示公司列表
	 * @return
	 *//*
	@RequestMapping(value = "/listCompany", method = RequestMethod.GET)
	public ModelAndView listCompany() {
		Collection<Company> companys = companyService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/company/listCompany");
		if (companys != null) {
			modelAndView.addObject("companys", companys);
		} else {
			modelAndView.addObject("companys", new HashSet<Company>());
		}
		return modelAndView;
	}*/
	
	
	
}
