package org.zerock.myapp.controller;

import java.io.File;

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
		log.info("\n\t현재 클래스는 {}입니다.",this.getClass().getName());
		System.out.println();
	}	// end getThisClassInfo
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		this.getThisClassInfo();
		log.info("uploadForm() invoked.");
	}	// end uploadForm
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile,Model model) throws Exception {
		this.getThisClassInfo();
		String uploadFolder = "/Users/wisdlogos/Temp/upload/tmp/";
		
		log.info("uploadFormPost() invoked.");
//		log.info("uploadFile : {}",uploadFile);
//		log.info("Model : {}",model);
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("-----------------------");
			log.info("Upload File Name : {}",multipartFile.getOriginalFilename());
			log.info("Upload File Size : {}",multipartFile.getSize());
			
			log.info("Upload File getName : {}",multipartFile.getName());
			log.info("String getOriginalFileName() : {}",multipartFile.getOriginalFilename());
			log.info("boolean isEmpty() : {}",multipartFile.isEmpty());
			log.info("getSize() : {}",multipartFile.getSize());
			log.info("getBytes() : {}",multipartFile.getBytes());
			log.info("inputStream getInputStream() : {}",multipartFile.getInputStream());
			
			File saveFile = new File(uploadFolder,multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
				log.info("uploadFile");
			}catch(Exception e) {
				log.error(e.getMessage());
			}	// end try-catch
			log.info("-----------------------");
		}	// end for
		
	}	// end uploadFormPost
}	// end class
