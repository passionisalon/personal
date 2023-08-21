package org.zerock.myapp.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.myapp.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j2
public class UploadController {
	
	// temp
//	private static String pathP = "";
	
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
	
	@SuppressWarnings("deprecation")
	@PostMapping(value="/uploadAjaxAction",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile){
		this.getThisClassInfo();
		log.info("uploadAjaxPost() invoked.");
		log.info("uploadFile : {}",uploadFile);
		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = "/Users/wisdlogos/Temp/upload/tmp/";
		
		String uploadFolderPath = getFolder();
//		UploadController.pathP = uploadFolderPath;
		// make folder ----
		File uploadPath = new File(uploadFolder,uploadFolderPath);
		
		if(uploadPath.exists()==false) {
			uploadPath.mkdirs();
		}	// end if
		// make yyyy/MM/dd folder
		
		for(MultipartFile multipartFile : uploadFile) {
			AttachFileDTO attachDTO = new AttachFileDTO();
			String uploadFileName = multipartFile.getOriginalFilename();
			
			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			log.info("only file name : {}",uploadFileName);
			attachDTO.setFileName(uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			
			uploadFileName = uuid.toString()+"_"+uploadFileName;
			
			try {
				File saveFile = new File(uploadPath,uploadFileName);
//				File saveFile = new File(uploadFolder,uploadFileName);
				multipartFile.transferTo(saveFile);
				
//				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);
				attachDTO.setUploadPath(uploadFolder);
				
				// check image type file
				if(checkImageType(saveFile)) {
					attachDTO.setImage(true);
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
//					FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder,"s_" + uploadFileName));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100,100);
					thumbnail.close();
				}	// end if
				// add to List
				list.add(attachDTO);
			}catch(Exception e) {
				e.getStackTrace();
			}
		}	// end for
		return new ResponseEntity<>(list,HttpStatus.OK);
	}	// end uploadAjaxPost
	
	
	// 기존 ajax파일 업로드
//	@PostMapping("/uploadAjaxAction")
//	public String uploadAjaxPost(MultipartFile[] uploadFile) throws Exception {
//		this.getThisClassInfo();
//		log.info("uploadAjaxPost() invoked.");
//		try {
//			log.info("MultipartFile[] : {}",uploadFile);
//			String uploadFolder = "/Users/wisdlogos/Temp/upload/tmp/";
//			log.info("uploadFolder : {}",uploadFolder);
//			
//			// make folder 
//			File uploadPath = new File(uploadFolder,getFolder());
//			log.info("uploadPath : {}",uploadPath);
//			
//			if(uploadPath.exists() == false) {
//				uploadPath.mkdirs();
//			}
//			
//			for(MultipartFile multipartFile : uploadFile) {
//				
//				log.info("------------------------------");
//				log.info("Upload File Name : {}",multipartFile);
//				log.info("Upload File Name getOriginalFillename() : {}",multipartFile.getOriginalFilename());
//				log.info("Upload File Size : {}",multipartFile.getSize());
//				
//				String uploadFileName = multipartFile.getOriginalFilename();
//				log.info("uploadFileName : {}",uploadFileName);
//				
//				// IE has file path
//				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
//				log.info("only file name : ",uploadFileName);
//				
//				UUID uuid = UUID.randomUUID();
//				log.info("uuid : {}",uuid);
//				
//				uploadFileName = uuid.toString() + "_" + uploadFileName;
//				log.info("uploadFileName : {}",uploadFileName);
//				
//				
////				File saveFile = new File(uploadFolder, uploadFileName);
//				File saveFile = new File(uploadPath,uploadFileName);
//				log.info("saveFile : {}",saveFile);
//				
//				multipartFile.transferTo(saveFile);
//				
//				if(checkImageType(saveFile)) {
//					
//					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
//					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100,100);
//					
//					thumbnail.close();
//				}
//				
//				log.info("------------------------------");
//				return "redirect:/uploadAjax";	
//			}	// end for
//			
//		}catch(Exception e) {
//			throw new Exception(e);
//		}
//		return "redirect:/uploadAjax";
//		
//	}	// end uploadAjaxPost
	
	private String getFolder() {
		
		this.getThisClassInfo();
		log.info("getFolder() invoked.");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		log.info("sdf : {}",sdf);
		
		Date date = new Date();
		log.info("date : {}",date);
		
		String str = sdf.format(date);
		log.info("str : {}",str);
		
		String result = str.replace("-", File.separator);
		log.info("result : {}",result);
		
		return result;
	}	// end getFolder
		
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			log.info("contentType : {}",contentType);
			
			return contentType.startsWith("image");

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}	// end checkImageType
	
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName){
		this.getThisClassInfo();
		log.info("getFile() invoked.");
		log.info("fileName : {}",fileName);
		
		// Check if fileName is not null or empty
		if(fileName == null || fileName.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		File file = new File("/Users/wisdlogos/Temp/upload/tmp/"+fileName);
		log.info("file : {}",file);
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}	// end getFile
	
//	@GetMapping(value="/download",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	@ResponseBody
//	public ResponseEntity<Resource> downloadFile(String fileName){
//		this.getThisClassInfo();
//		log.info("downloadFile() invoked.");
//		log.info("fileName : {}",fileName);
//		
//		FileSystemResource resource = new FileSystemResource("/Users/wisdlogos/Temp/upload/tmp/"+fileName);
//		
//		log.info("resource : {}",resource);
//		
//		return null;
//		
//	}	// downloadFile
	
	@GetMapping(value="/download",produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String fileName){
		this.getThisClassInfo();
		log.info("downloadFile() invoked.");
		log.info("download file : {}",fileName);
		
		Resource resource = new FileSystemResource("/Users/wisdlogos/Temp/upload/tmp/"+fileName);
		
		log.info("resouece : {}",resource);
		String resourceName = resource.getFilename();
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			headers.add("Content-Disposition","attachment; filename="+new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
//		return null;
	}	// downloadFile
	
}	// end class
