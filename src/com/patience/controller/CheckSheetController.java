package com.patience.controller;

import java.io.File;
import java.io.IOException;

import java.io.UnsupportedEncodingException;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.patience.entity.CheckSheet;
import com.patience.service.CheckSheetService;
import com.patience.util.FileUtil;


@Controller
@Transactional
@RequestMapping("/checkSheet")
public class CheckSheetController {
	
	private static final String DIRECTION = "checkSheet";
	/**
	 * 设置可用性为真
	 */
	private static final int ENABLE_FLAG_TRUE = 1;
	/**
	 * 设置可用性为假
	 */
	private static final int ENABLE_FLAG_FALSE = 0;
	/**
	 * 全部
	 */
	private static final int ENABLE_FLAG_ALL = 2;
	/**
	 * 获取spring默认的request
	 */
	@Resource
	private HttpServletRequest request;
	
	@Resource
	private CheckSheetService checkSheetService;

	private static final String CHECK_SHEET = "checkSheet";
	private static final String CHECK_SHEET_ID = "checkSheetId"; 
	private static final String SHEETS = "sheets";
	private static final String LIST_CHECK_SHEET = "listCheckSheet";
	private static final String LIST_CHECK_SHEET_FOR_GUEST = "listCheckSheetForGuest";
	private static final String LIST_CHECK_SHEET_BY_CONDITION = "listCheckSheetByCondition";
	private static final String ENABLE_FLAG = "enableFlag";
	
	private static final String REDIRECT = "redirect:";
	private static final String LINE_FLAG= "/";
	private static final String WEB_INF = "WEB-INF";
	private static final String CHECK_SHEET_FILE = "checkSheetFile";
	
	
	@RequestMapping("/download/{checkSheetId}")
	public ResponseEntity<byte[]> downloadSheet(@PathVariable(CHECK_SHEET_ID) long checkSheetId) {
		CheckSheet sheet = checkSheetService.getById(checkSheetId);
		if (sheet != null) {
			StringBuilder sheetBuilder = new StringBuilder(request.getSession()
                    .getServletContext().getRealPath(LINE_FLAG));
			sheetBuilder.append(WEB_INF)
			    .append(LINE_FLAG).append(CHECK_SHEET_FILE)
			    .append(LINE_FLAG).append(sheet.getClassification())
				.append(LINE_FLAG).append(sheet.getName());
			File file = new File(sheetBuilder.toString());
//			if (!file.exists()) {
//				return null;
//			}
			try {
                String fileName = new String(sheet.getName().getBytes("UTF-8"), "iso-8859-1");
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment", fileName);
                System.err.println("xiazai==========================fileName;"+fileName);
                return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		return null;
	}
	
	@RequestMapping("/listCheckSheetByCondition/{enableFlag}")
	public ModelAndView listCheckSheetByCondition(@PathVariable("enableFlag") int enableFlag) {
		List<CheckSheet> list = null;
		if (enableFlag == ENABLE_FLAG_TRUE) {
			list = checkSheetService.findEnableCheckSheet(true);
		} else if (enableFlag == ENABLE_FLAG_FALSE){
			list = checkSheetService.findEnableCheckSheet(false);
		} else if (enableFlag == ENABLE_FLAG_ALL){
			list = checkSheetService.findAll();
		}
		ModelAndView modelAndView = new ModelAndView();
		
		StringBuilder vBuilder = new StringBuilder();
		vBuilder.append(LINE_FLAG).append(CHECK_SHEET)
				.append(LINE_FLAG).append(LIST_CHECK_SHEET);
		modelAndView.setViewName(vBuilder.toString());
		modelAndView.addObject("sheets", new HashSet<>(list));
		return modelAndView;
	}
	
	@RequestMapping("/enableFlag/{checkSheetId}/{enableFlag}")
	public String setEnableFlagById(@PathVariable(CHECK_SHEET_ID) long id,
	        @PathVariable(ENABLE_FLAG) int enableFlag) {
	    CheckSheet checkSheet = checkSheetService.getById(id);
	    if (enableFlag == ENABLE_FLAG_TRUE) {
	        checkSheet.setEnableFlag(true);
	    } else {
	        checkSheet.setEnableFlag(false);
	    }
	    checkSheetService.update(checkSheet);
	   
	    return redirectListCheckSheet();
	}
	/**
	 * 删除某个备忘录通过id
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteSheet/{checkSheetId}")
	public String deleteCheckSheet(@PathVariable(CHECK_SHEET_ID) long id) {
	    //先删除磁盘上的文件
	    CheckSheet file = checkSheetService.getById(id);
	    int classfication = file.getClassification();
	    String name = file.getName();
	    
        StringBuilder pathBuilder = new StringBuilder(request.getSession()
                .getServletContext().getRealPath(LINE_FLAG));
        pathBuilder.append(WEB_INF)
        	.append(LINE_FLAG).append(CHECK_SHEET_FILE)
        	.append(LINE_FLAG).append(classfication)
        	.append(LINE_FLAG).append(name);
        
	    FileUtil.deleteFile(pathBuilder.toString());
	    //再删数据库
	    checkSheetService.delete(id);
	    
	    return redirectListCheckSheet();
	}
	/**
	 * 游客备忘录接口
	 * @return
	 */
	@RequestMapping("/listSheetForGuest")
	public ModelAndView listCheckSheetForGuest() {
	    ModelAndView modelAndView = new ModelAndView();
	    List<CheckSheet> list = checkSheetService.findEnableCheckSheet(true);
	    if (list != null && !list.isEmpty()) {
	        modelAndView.addObject(SHEETS, new HashSet<>(list));
	    } else {
	        modelAndView.addObject(SHEETS, new HashSet<CheckSheet>());
	    }
	    
	    StringBuilder vBuilder = new StringBuilder();
	    vBuilder.append(LINE_FLAG).append(CHECK_SHEET)
	    		.append(LINE_FLAG).append(LIST_CHECK_SHEET_FOR_GUEST);
	    modelAndView.setViewName(vBuilder.toString());
	    return modelAndView;
	}
	
	
	@RequestMapping(value = "/updateFile", method = RequestMethod.POST)
	public String updateFile(@RequestParam("fileName") String fileName,
			@RequestParam("fileStyle") int fileStyle,
			@RequestParam("newFile") MultipartFile newFile, HttpSession session) {
		
		
		
		return "";
	}
	/**
	 * 打开上传文件页面
	 * @return
	 */
	@RequestMapping("/uploadFileUI")
	public String uploadFileUI() {
		String view = "/checkSheet/fileUpLoad";
		return view;
	}
	
	/**
	 * 接受上传过来的文件，并保存
	 * @param fileStyle
	 * @param mFile
	 * @return
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("fileStyle") int fileStyle,
			@RequestParam("uploadFile") MultipartFile mFile) {
		String view = null;
		if (!mFile.isEmpty()) {
			try {
				CheckSheet checkSheet = new CheckSheet();
				checkSheet.setFileSize(mFile.getBytes().length / 1024);//1kb == 1024字节
				checkSheet.setName(mFile.getOriginalFilename());
				checkSheet.setClassification(fileStyle);
				checkSheet.setDownloadNum(0L);
				checkSheet.setEnableFlag(true);
				checkSheet.setUploadTime(new Date());
				checkSheetService.save(checkSheet);
				System.err.println("===========文件类型："+mFile.getContentType());

				
				//文件要存的路径
                StringBuilder pathBuilder = new StringBuilder(request.getSession()
                        .getServletContext().getRealPath(LINE_FLAG));
                pathBuilder.append(WEB_INF).append(LINE_FLAG).append("checkSheetFile")
                	.append(LINE_FLAG).append(fileStyle);
				//转储文件
				File file = new File(pathBuilder.toString());
				if (!file.exists() && !file.isDirectory()) {
					file.mkdir();
				}
				pathBuilder.append(LINE_FLAG).append(mFile.getOriginalFilename());
				mFile.transferTo(new File(pathBuilder.toString()));
				//存储文件路径和文件名字

				return redirectListCheckSheet();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		view = "redirect:/checkSheet/uploadFileUI";
		return view;
	}
	/**
	 * 显示所有列表文件
	 * @return
	 */
	@RequestMapping("/listCheckSheet")
	public String  listCheckSheet() {
		String view = "redirect:/checkSheet/listCheckSheetByCondition/";
		StringBuilder vBuilder = new StringBuilder(view);
		vBuilder.append(ENABLE_FLAG_ALL);
		return vBuilder.toString();
	}
	/**
	 * redirect:/checkSheet/listCheckSheet
	 * @return
	 */
	public static String redirectListCheckSheet() {
	    
	    StringBuilder vBuilder = new StringBuilder();
	    vBuilder.append(REDIRECT)
	    		.append(LINE_FLAG).append(CHECK_SHEET)
	    		.append(LINE_FLAG).append(LIST_CHECK_SHEET);
	    return vBuilder.toString();
	}
}
