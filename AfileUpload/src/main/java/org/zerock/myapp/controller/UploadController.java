package org.zerock.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class UploadController {
	
	public void getThisClassInfo() {
		System.out.println();
		log.info("현재 클래스는 {}입니다.",this.getClass().getName());
		System.out.println();
	}	// end getThisClassInfo
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		this.getThisClassInfo();
		log.info("uploadForm() invoked.");
	}	// end uploadForm
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile,Model model) {
		this.getThisClassInfo();
		log.info("uploadFormPost() invoked.");
//		log.info("uploadFile : {}",uploadFile);
//		log.info("Model : {}",model);
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("-----------------------");
			log.info("Upload File Name : {}",multipartFile.getOriginalFilename());
			log.info("Upload File Size : {}",multipartFile.getSize());
			log.info("-----------------------");
		}	// end for
		
	}	// end uploadFormPost
}	// end class
