package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.util.RunShell2;
 

@RestController
@ComponentScan(value= {"com.example.config"})
@SpringBootApplication
public class Demo01Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo01Application.class, args);
	}
	
	
	/** 
     * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址, 
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值 
     *  
     * @return ip
     */
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for"); 
        System.out.println("x-forwarded-for ip: " + ip);
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {  
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if( ip.indexOf(",")!=-1 ){
                ip = ip.split(",")[0];
            }
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
            System.out.println("Proxy-Client-IP ip: " + ip);
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
            System.out.println("WL-Proxy-Client-IP ip: " + ip);
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
            System.out.println("HTTP_CLIENT_IP ip: " + ip);
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
            System.out.println("HTTP_X_FORWARDED_FOR ip: " + ip);
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("X-Real-IP");  
            System.out.println("X-Real-IP ip: " + ip);
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
            System.out.println("getRemoteAddr ip: " + ip);
        } 
        System.out.println("获取客户端ip: " + ip);
        return ip;  
    }
    

	@RequestMapping("/b")
	@ResponseBody
	public  String bbbb(HttpServletRequest request) {
		return getIpAddr(request);
	}

	@RequestMapping("/getNetIP")
	@ResponseBody
	public  String getNetIP(HttpServletRequest request) {
		return getIpAddr(request);
	}
	
	@RequestMapping("/openit")
	@ResponseBody
	public String openit(HttpServletRequest request) {

		boolean flag = false;

		String ipAddr = getIpAddr(request);

		try {
			RunShell2.opentcpPort_IPTABLESL(ipAddr, "22221");
			RunShell2.openudpPort_IPTABLESL(ipAddr, "22221");

			RunShell2.save();

			RunShell2.restart();

			
		} catch (Exception e) {
			 
		}finally {
			System.out.println(ipAddr);
		}

		return flag + "";
	}
	
	
	@RequestMapping("/a")
	@ResponseBody
	public  String aaa() {
		return "{\n" + 
				"    \"total\": 2,\n" + 
				"    \"size\": 10,\n" + 
				"    \"current\": 1,\n" + 
				"    \"records\": [\n" + 
				"        {\n" + 
				"            \"id\": 73,\n" + 
				"            \"createDate\": \"2019-02-21 14:29:48\",\n" + 
				"            \"createBy\": null,\n" + 
				"            \"modifyDate\": \"2019-02-21 14:29:48\",\n" + 
				"            \"modifyBy\": null,\n" + 
				"            \"img1\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img2\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img3\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img4\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img5\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img6\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img7\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img8\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img9\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"userId\": 2,\n" + 
				"            \"content\": \"3\",\n" + 
				"            \"giveTheThumbsUpIds\": \"2\",\n" + 
				"            \"vedio1\": null,\n" + 
				"            \"userNickName\": \"昵称18565831133\",\n" + 
				"            \"thumbsUpUserList\": [\n" + 
				"                {\n" + 
				"                    \"id\": 2,\n" + 
				"                    \"userHeadUrl\": \"http://www.sucaijishi.com/uploadfile/2014/0524/20140524012041558.png\",\n" + 
				"                    \"userNickName\": \"昵称18565831133\",\n" + 
				"                    \"userId\": 2\n" + 
				"                }\n" + 
				"            ],\n" + 
				"            \"circleOfFriendsCommentList\": [\n" + 
				"                {\n" + 
				"                    \"id\": 73,\n" + 
				"                    \"createDate\": \"2019-02-21 14:29:48\",\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": \"2019-02-21 14:29:48\",\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"userId\": 2,\n" + 
				"                    \"content\": \"牛逼73\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userNickName\": \"昵称18565831133\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 72,\n" + 
				"                    \"createDate\": \"2019-02-21 14:29:48\",\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": \"2019-02-21 14:29:48\",\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"userId\": 2,\n" + 
				"                    \"content\": \"牛逼72\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userNickName\": \"昵称18565831133\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 71,\n" + 
				"                    \"createDate\": \"2019-02-21 14:29:48\",\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": \"2019-02-21 14:29:48\",\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"userId\": 2,\n" + 
				"                    \"content\": \"牛逼71\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userNickName\": \"昵称18565831133\"\n" + 
				"                }\n" + 
				"            ],\n" + 
				"            \"commentAboutMap\": [\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"id\": 73,\n" + 
				"                    \"userNickName\": \"昵称18565831133\",\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsComment.ImiCircleOfFriendsCommentRsp\",\n" + 
				"                    \"userId\": 2,\n" + 
				"                    \"content\": \"牛逼73\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 71,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼71\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 72,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼72\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 73,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼73\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 74,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼74\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 75,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼75\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 76,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼76\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 78,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼77\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 79,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼78\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 80,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼79\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 83,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼80\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 84,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼81\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 85,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼82\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 86,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼83\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 87,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼84\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\",\n" + 
				"                    \"id\": 88,\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsCommentDialogue.ImiCircleOfFriendsCommentDialogueRsp\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"contentz\": \"牛逼85\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"id\": 72,\n" + 
				"                    \"userNickName\": \"昵称18565831133\",\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsComment.ImiCircleOfFriendsCommentRsp\",\n" + 
				"                    \"userId\": 2,\n" + 
				"                    \"content\": \"牛逼72\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"id\": 71,\n" + 
				"                    \"userNickName\": \"昵称18565831133\",\n" + 
				"                    \"class\": \"com.vm.dto.rsp.ImiCircleOfFriendsComment.ImiCircleOfFriendsCommentRsp\",\n" + 
				"                    \"userId\": 2,\n" + 
				"                    \"content\": \"牛逼71\",\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"createDate\": 1550730588000\n" + 
				"                }\n" + 
				"            ],\n" + 
				"            \"commentDialogueRspList\": [\n" + 
				"                {\n" + 
				"                    \"id\": 71,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼71\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 72,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼72\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 73,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼73\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 74,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼74\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 75,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼75\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 76,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼76\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 78,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼77\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 79,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼78\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 80,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼79\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 83,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼80\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 84,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼81\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 85,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼82\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 86,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼83\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 87,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼84\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 88,\n" + 
				"                    \"createDate\": 1550730588000,\n" + 
				"                    \"createBy\": null,\n" + 
				"                    \"modifyDate\": 1550730588000,\n" + 
				"                    \"modifyBy\": null,\n" + 
				"                    \"imiCircleOfFriendsId\": 73,\n" + 
				"                    \"userIdBei\": 2,\n" + 
				"                    \"userIdZhu\": 1,\n" + 
				"                    \"contentz\": \"牛逼85\",\n" + 
				"                    \"userIdBeiNickName\": \"昵称18565831133\",\n" + 
				"                    \"userIdZhuNickName\": \"昵称18565831132\"\n" + 
				"                }\n" + 
				"            ],\n" + 
				"            \"imgList\": [\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\"\n" + 
				"            ],\n" + 
				"            \"thumbsUpFlag\": false\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"id\": 72,\n" + 
				"            \"createDate\": \"2019-02-21 14:29:48\",\n" + 
				"            \"createBy\": null,\n" + 
				"            \"modifyDate\": \"2019-02-21 14:29:48\",\n" + 
				"            \"modifyBy\": null,\n" + 
				"            \"img1\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img2\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img3\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img4\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img5\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img6\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img7\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img8\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"img9\": \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"            \"userId\": 1,\n" + 
				"            \"content\": \"2\",\n" + 
				"            \"giveTheThumbsUpIds\": \"2,1\",\n" + 
				"            \"vedio1\": null,\n" + 
				"            \"userNickName\": \"昵称18565831132\",\n" + 
				"            \"thumbsUpUserList\": [\n" + 
				"                {\n" + 
				"                    \"id\": 2,\n" + 
				"                    \"userHeadUrl\": \"http://www.sucaijishi.com/uploadfile/2014/0524/20140524012041558.png\",\n" + 
				"                    \"userNickName\": \"昵称18565831133\",\n" + 
				"                    \"userId\": 2\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"id\": 1,\n" + 
				"                    \"userHeadUrl\": \"http://www.sucaijishi.com/uploadfile/2014/0524/20140524012041558.png\",\n" + 
				"                    \"userNickName\": \"昵称18565831132\",\n" + 
				"                    \"userId\": 1\n" + 
				"                }\n" + 
				"            ],\n" + 
				"            \"circleOfFriendsCommentList\": [],\n" + 
				"            \"commentAboutMap\": [],\n" + 
				"            \"commentDialogueRspList\": null,\n" + 
				"            \"imgList\": [\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\",\n" + 
				"                \"http://pic17.nipic.com/20111021/8633866_210108284151_2.jpg\"\n" + 
				"            ],\n" + 
				"            \"thumbsUpFlag\": true\n" + 
				"        }\n" + 
				"    ],\n" + 
				"    \"pages\": 1\n" + 
				"}";
	}
}
