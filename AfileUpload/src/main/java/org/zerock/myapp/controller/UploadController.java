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
	
	// 업로드 폼 형식 get
	@GetMapping("/uploadForm")
	public void uploadForm() {
		this.getThisClassInfo();
		log.info("uploadForm() invoked.");
	}	// end uploadForm
	
	
	
	
	// 업로드 폼 형식 post
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
			
			log.info("파라미터의 이름<input>태그의 이름");
			log.info("Upload File getName : {}",multipartFile.getName());
			
			log.info("업로드되는 파일의 이름");
			log.info("String getOriginalFileName() : {}",multipartFile.getOriginalFilename());
			
			log.info("파일이 존재하지 않는 경우 true");
			log.info("boolean isEmpty() : {}",multipartFile.isEmpty());
			
			log.info("업로드되는 파일의 크기");
			log.info("getSize() : {}",multipartFile.getSize());
			
			log.info("byte[]로 파일 데이터 변환");
			log.info("getBytes() : {}",multipartFile.getBytes());
			
			log.info("파일데이터와 연결된 InputStream을 반환");
			log.info("inputStream getInputStream() : {}",multipartFile.getInputStream());
			
			File saveFile = new File(uploadFolder,multipartFile.getOriginalFilename());
			
			try {
				log.info("파일의 저장");
				multipartFile.transferTo(saveFile);
				log.info("uploadFile");
			}catch(Exception e) {
				log.error(e.getMessage());
			}	// end try-catch
			log.info("-----------------------");
		}	// end for
		
	}	// end uploadFormPost
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		this.getThisClassInfo();
		log.info("upload ajax");
	}	// end uploadAjax
	
	@PostMapping("/uploadAjaxAction")
	public String uploadAjaxPost(MultipartFile[] uploadFile) throws Exception {
		this.getThisClassInfo();
		log.info("uploadAjaxPost() invoked.");
		try {
			log.info("MultipartFile[] : {}",uploadFile);
			String uploadFolder = "/Users/wisdlogos/Temp/upload/tmp/";
			log.info("uploadFolder : {}",uploadFolder);
			for(MultipartFile multipartFile : uploadFile) {
				
				log.info("------------------------------");
				log.info("Upload File Name : {}",multipartFile);
				log.info("Upload File Name getOriginalFillename() : {}",multipartFile.getOriginalFilename());
				log.info("Upload File Size : {}",multipartFile.getSize());
				
				String uploadFileName = multipartFile.getOriginalFilename();
				log.info("uploadFileName : {}",uploadFileName);
				
				// IE has file path
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
				log.info("only file name : ",uploadFileName);
				
				File saveFile = new File(uploadFolder, uploadFileName);
				log.info("saveFile : {}",saveFile);
				
				multipartFile.transferTo(saveFile);
				
				log.info("------------------------------");
				return "redirect:/uploadAjax";	
			}	// end for
			
		}catch(Exception e) {
//			return "controller에서 처리완료???";
			throw new Exception(e);
			
		}
		return "redirect:/uploadAjax";
		
		
		
		
	}	// end uploadAjaxPost
	
	
}	// end class
