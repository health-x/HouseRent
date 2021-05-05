package com.house.health.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.house.health.entity.House;
import com.house.health.service.IHouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class AddHouseController {

	private String str = this.getClass().getClassLoader().getResource("houseImages/1.txt").getPath();
	private String dirPath = str.substring(1,str.length()-5);

	//private String dirPath = "classpath:/houseImages/";
	// 简介图片地址
	private String simplePath = "";
	// 详细图片地址
	private StringBuilder detailsPath = new StringBuilder();
	
	@Autowired
	private IHouserService service;

	@RequestMapping("/MultipleUpload")
	@ResponseBody
	public Map<String, Object> upload(@RequestParam("file") List<MultipartFile> file, HttpServletRequest req) {
		System.out.println("dirPath::::"+dirPath);

		Map<String, Object> map = new HashMap<String,Object>();
		if (!file.isEmpty() && file.size() > 0) {
			for (MultipartFile f : file) {
				try {
					// 文件名
					String filename = UUID.randomUUID()
							+ f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
					// 存储虚拟路径
					String localPath ="http://localhost:8090/images/"+ filename;
					System.out.println("localPath::::"+localPath);
					detailsPath.append(localPath+"~");

					File filePath = new File(dirPath);
					if (!filePath.exists()) {
						filePath.mkdirs();
					}
					//上传
					f.transferTo(new File(dirPath + filename));

				} catch (Exception e) {
					map.put("code", 1);
					map.put("msg", "上传失败");
					e.printStackTrace();
				}
			}
			map.put("code", 0);
			map.put("msg", "上传成功");
		}
		return map;
	}

	@RequestMapping("/singleUpload")
	@ResponseBody
	public Map<String, Object> singleUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String filename = UUID.randomUUID() + suffixName;
			File filePath = new File(dirPath);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}
			//创建虚拟路径存储
			simplePath = "http://localhost:8090/images/"+ filename;
			map.put("image", simplePath);
			file.transferTo(new File(dirPath + filename));
			map.put("code", 0);
			map.put("msg", "上传成功");
		} catch (Exception e) {
			map.put("code", 1);
			map.put("msg", "上传失败");
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/addHouse")
	public String addHouse() {
		return "addhouse";
	}
	
	@RequestMapping("/addHouseRecord")
	@ResponseBody
	public String addHouse(House house) {
		if(house.getPublisher()==null||"".equals(house.getPublisher())) {
			house.setPublisher("管理员");
		}
		house.setHouseImage(simplePath);
		house.setHouseDetailsImg(detailsPath.toString());
		int n = service.addNewHouse(house);
		if(n>0) {
			detailsPath.delete(0,detailsPath.length());
			return "OK";
		}
		return "FAIL";
	}
}
