package com.game.ssm.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.game.ssm.entiy.Admin;
import com.game.ssm.entiy.BigGameType;
import com.game.ssm.entiy.GameConfigure;
import com.game.ssm.entiy.SmallGameType;
import com.game.ssm.entiy.uploadArticleInfo;
import com.game.ssm.service.impl.AdminOpServiceImpl;
import com.game.ssm.utils.DateUtil;

import javafx.scene.control.Alert;

@Service
@RequestMapping("/")
public class AdminGameSourceUploadControl extends ControlBase{
    @Autowired
	private AdminOpServiceImpl adminOpServiceImpl; 
    
    @RequestMapping("GameSourceUpload")
    public ModelAndView gameSourceUploadHTML()
    {
    	ModelAndView modelAndView = new ModelAndView("ServerP/GameSourceUpload/gameSourceUpload");
    	//获取游戏大类名称
        List<BigGameType> queryBigGameInfoAll=adminOpServiceImpl.getBigGameInfo();
    	//获取游戏配置
    	List<GameConfigure> gameConfigures=adminOpServiceImpl.getGameConfigure();
    	//获取小类别游戏的名称
    	Map<String, Object> info=new HashMap<String, Object>();
    	List<String> smallGameTypeInfo=adminOpServiceImpl.querySmallGameInfo(info);
    	modelAndView.addObject("Configure", gameConfigures);
    	modelAndView.addObject("BigGameInfo",queryBigGameInfoAll);
     	//modelAndView.addObject("smallGameType", smallGameTypeInfo);
    	return modelAndView;
    }
    
    @RequestMapping(value="photoUpload",method=RequestMethod.POST)
    public String photoSourceUpload(HttpServletRequest request,@RequestParam("file") MultipartFile file,ModelMap model) throws IllegalStateException, IOException
    {   
    	//String message="error";
    	String savepath=request.getSession().getServletContext().getRealPath("/Game/ftl/GameP/uploadImages");
    	logger.info("文件保存的路径:"+savepath);
    	String fileName=file.getOriginalFilename();
    	logger.info("文件名:"+fileName);
    	File uploadFile=new File(savepath,fileName);
    	//判断路径是否存在
    	if(!uploadFile.getParentFile().exists())
    	{
    		uploadFile.getParentFile().mkdirs();
    	}
    	file.transferTo(new File(savepath+File.separator+fileName));
    	return "ServerP/GameSourceUpload/gameSourceUpload";
    }
    
    @RequestMapping(value="ajaxphotoUpload",method=RequestMethod.POST)
    public String ajaxphotoSourceUpload(HttpServletRequest request,@RequestParam("configureSelect") String configure,@RequestParam("gameName") String gameName,@RequestParam("bigGameInfo") String bigGameInfo,@RequestParam("file") MultipartFile file,ModelMap model) throws IllegalStateException, IOException
    {   
    	//String message="error";
    	HttpSession session=request.getSession();
    	String savepath=request.getSession().getServletContext().getRealPath("/Game/ftl/GameP/uploadImages");
    	logger.info("文件保存的路径:"+savepath);
    	String fileName=file.getOriginalFilename();
    	logger.info("文件名:"+fileName);
    	File uploadFile=new File(savepath,fileName);
    	//判断路径是否存在
    	if(!uploadFile.getParentFile().exists())
    	{
    		uploadFile.getParentFile().mkdirs();
    	}
    	file.transferTo(new File(savepath+File.separator+fileName));
    	
    	//然后修改图片路径到GameP的Images到数据库内,完成添加新类型操作
    	String typeImageUrl="Game/ftl/GameP/uploadImages/"+fileName;
    	//获取新增游戏名称
    	
    	logger.info("gameName:"+gameName);
    	//获取新增游戏简介
 
    	logger.info("gameInfo:"+bigGameInfo);
    	//获取上传管理员id
    	Admin admin=(Admin)session.getAttribute("LoginAdmin");
    	
    	//获取选择的游戏配置id,字符串转成int类型
    	int games_configure=Integer.valueOf(configure);
    	
    	int adminId=admin.getAdmin_id();
    	BigGameType newGameType=new BigGameType(gameName, bigGameInfo,typeImageUrl , adminId,games_configure);
    	if(adminOpServiceImpl.addBigGameType(newGameType))
    	{
    		return "ServerP/GameSourceUpload/gameSourceUpload";
    	}
    	return "ServerP/GameSourceUpload/gameSourceUpload";
    }
    
    
    @RequestMapping(value="ajaxSmallTypePhotoUpload",method=RequestMethod.POST)
    public String ajaxSmallTypePhotoSourceUpload(HttpServletRequest request,@RequestParam("BigTypeName") String bigType,@RequestParam("smallName") String gameName,@RequestParam("smallGameInfo") String smallGameInfo,@RequestParam("Smallfile") MultipartFile file,ModelMap model) 
    		throws IllegalStateException, IOException
    {   
    	//String message="error";
    	HttpSession session=request.getSession();
    	String savepath=request.getSession().getServletContext().getRealPath("/Game/ftl/GameP/uploadImages");
    	logger.info("文件保存的路径:"+savepath);
    	String fileName=file.getOriginalFilename();
    	logger.info("文件名:"+fileName);
    	File uploadFile=new File(savepath,fileName);
    	//判断路径是否存在
    	if(!uploadFile.getParentFile().exists())
    	{
    		uploadFile.getParentFile().mkdirs();
    	}
    	file.transferTo(new File(savepath+File.separator+fileName));
    	
    	//然后修改图片路径到GameP的Images到数据库内,完成添加新类型操作
    	String typeImageUrl="Game/ftl/GameP/images/"+fileName;
    	
    	//获取大类对应的id
    	int category_id=adminOpServiceImpl.bigGameId(bigType);
    	
    	SmallGameType smallGameType=new SmallGameType(category_id,gameName,typeImageUrl,smallGameInfo);
    	
    	if(adminOpServiceImpl.addSmallGameType(smallGameType))
    	{
    		return "ServerP/GameSourceUpload/gameSourceUpload";
    	}
    	return "ServerP/GameSourceUpload/gameSourceUpload";
    }
    @RequestMapping(value="articleUpload",method=RequestMethod.POST)
    public String uploadArticle(HttpServletRequest request,@RequestParam("ArticleBigType") String bigTypeName,@RequestParam("SmallType") String smallType,@RequestParam("gameTitle") String gameTile,@RequestParam("gameAuthor") String gameAuthor,@RequestParam("Uptime") String uptime,@RequestParam("upArticleInfo") String upArticleInfo)
    {   
    	//搜索游戏小类id
    	int id=adminOpServiceImpl.querySmallGameIdByName(smallType);
    	//搜索上传的管理员id
    	HttpSession session=request.getSession();
    	Admin admin=(Admin)session.getAttribute("LoginAdmin");
    	int adminId=admin.getAdmin_id();
    	//上传文章信息
    	logger.info("时间:"+uptime);
    	Timestamp date=DateUtil.StringtoTimestamp(uptime,"yyyy-MM-dd HH-mm-ss");
    	uploadArticleInfo articleInfo=new uploadArticleInfo(id,gameTile,upArticleInfo,gameAuthor,adminId,date);
    	if(adminOpServiceImpl.uploadArticleInfo(articleInfo))
    	{
    		return "ServerP/GameSourceUpload/gameSourceUpload";
    	}
    	return "ServerP/GameSourceUpload/gameSourceUpload";
    }
    @RequestMapping(value="querySmallTypeNameByBigId",method=RequestMethod.POST)
    @ResponseBody
    public Object ajaxQuerySmallTypeNameByBigId(HttpServletRequest request,@RequestParam("name")String bigType) throws IOException
    {    
    	ModelAndView modelAndView=new ModelAndView("ServerP/GameSourceUpload/gameSourceUpload");
    	Map<String, Object> info=new HashMap<String, Object>();
    	logger.info("大类的名称:"+bigType);
    	//搜索游戏大类id
    	int bigId=adminOpServiceImpl.bigGameId(bigType);
    	info.put("games_category_id", bigId);
    	//搜索对应的小类游戏信息
    	List<String> smallGameTypeInfo=adminOpServiceImpl.querySmallGameInfo(info);
    	modelAndView.addObject("smallGameType", smallGameTypeInfo);
    	return smallGameTypeInfo;
    }
}
