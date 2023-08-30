package org.zerock.myapp.commservice;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.myapp.domain.AttachFileDTO;
import org.zerock.myapp.exception.ServiceException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public final class CommonService {
	
	// 해당 클래스의 정보를 가져오는 메소드 완전 공용 
		public static void getThisClassInfo(Object ClassName) throws ServiceException{
			
			System.out.println();
			System.out.println();
			System.out.printf("\n\t this Class is : %s\n",ClassName.getClass().getName());
			System.out.println();
		}	// end getThisClassInfo

		public static void CommonServiceInfo() throws ServiceException{
			System.out.println();
			System.out.println();
			log.trace("this class if CommonService");
			System.out.println();
		}
		
		// 진영이 행님 
		// 파일명 그대로 업로드하는 메소드 
		public static String originUpload(MultipartFile multiFile, String path) throws ServiceException{
			
			CommonService.CommonServiceInfo();
			log.info("originUpload() invoked.");
			log.info("multiFile : {}",multiFile);
			log.info("path : {}",path);
			
			if(multiFile == null || multiFile.isEmpty()) { 
				log.info("파일 업로드 실패!!!");
				return null;
			}	// end if 
			
			String originName = multiFile.getOriginalFilename();
			
			File target = new File(path+originName);
			
			try {
				multiFile.transferTo(target);
				log.info("파일 업로드 성공!!!");
				return originName;
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
		
		}	// end originUpload
		
		// 단일 파일용 업로드할 때 쓰는 메소드 
		public static String changeUpload(MultipartFile multiFile, String path) throws ServiceException{
			
			CommonService.CommonServiceInfo();
			log.trace("changeUpload() invoked.");
			log.info("multiFile : {}",multiFile);
			log.info("path : {}",path);
			
			if(multiFile == null || multiFile.isEmpty()) {
				log.info("파일업로드 실패!!!");
				return null;
			}	// end if
			
			try {
				
				String changeName = generateChangeName(multiFile);
				log.info("changeName : {}",changeName);
				
				File target = new File(path+changeName);
				log.info("target : {}",target);
				
				multiFile.transferTo(target);
				log.info("파일 업로드 성공!!!");
				
				return changeName;
				
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
			
			
		}	// end changeUpload
		
		public static List<String> upload(List<MultipartFile> fileList,String path) throws ServiceException{
			
			CommonService.CommonServiceInfo();
			log.trace("upload() invoked.");
			log.info("fileList : {}",fileList);
			log.info("path : {}",path);
			
			if(fileList == null || fileList.size() == 0 || fileList.get(0).isEmpty()) {
				log.info("파일 업로드 실패!!!");
				return null;
			}	// en dif
			
			try {
				List<String> changeNameList = new ArrayList<String>();
				log.info("changeNameList : {}",changeNameList);
				
				for(MultipartFile multiFile : fileList) {
					
					// changeName 만들기
					String changeName = CommonService.generateChangeName(multiFile);
					log.info("changeName : {}",changeName);
					
					changeNameList.add(changeName);
					changeNameList.forEach(log::info);
					
					// 서버에 저장
					File target = new File(path+changeName);
					log.info("target : {}",target);
					
					multiFile.transferTo(target);
					
				}	// end for
				
				return changeNameList;
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
			
			
		}	// end upload
		
		private static String generateChangeName(MultipartFile multiFile) throws ServiceException{
			
			CommonService.CommonServiceInfo();
			
			log.trace("generateChangeName() invoked.");
			log.info("multiFile : {}",multiFile);
			
			try {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				log.info("sdf : {}",sdf);
				String currentTime = sdf.format(new Date());
				log.info("currentTime : {}",currentTime);
				
				int randomNum = (int)(Math.random()*9000+1000);
				log.info("randomNum : {}",randomNum);
				
				String originName = multiFile.getOriginalFilename();
				log.info("originName : {}",originName);
				
				String ext = originName.substring(originName.lastIndexOf("."));
				log.info("ext : {}",ext);
				
				String changeName = currentTime + "_" + randomNum + ext;
				log.info("changeName : {}",changeName);
				
				return changeName;
			
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
			
			
		}	// end generateChangeName
		
		private static List<String> getOriginNameList(List<MultipartFile> fileList) throws ServiceException{
			
			CommonService.CommonServiceInfo();
			log.trace("getOriginNameList() invoked.");
			log.info("fileList : {}",fileList);
			
			try {
				// 파일이 비었는지 확인
				if(fileList == null || fileList.size() == 0 || fileList.get(0).isEmpty()) {
					log.info("파일이 비어있습니다.");
					return null;
				}	// end if
				
				List<String> originNameList = new ArrayList<String>();
				log.info("originNameList : {}",originNameList);
				
				for(MultipartFile multiFile : fileList) {
					String name = multiFile.getOriginalFilename();
					log.info("name : {}",name);
					
					originNameList.add(name);
					originNameList.forEach(log::info);
				}	// end for
				
				return originNameList;
				
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
			
		}	// getOriginNameList
		
		
		// 교재 
		// 공용 makeDir
		private String getFolder() throws ServiceException{
			CommonService.CommonServiceInfo();
			log.trace("getFolder() invoked.");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			log.info("sdf : {}",sdf);
			
			Date date = new Date();
			String str = sdf.format(date);
			
			log.info("str : {}",str);
			return str.replace("-",File.separator);
			
			
		}	// end getFolder
		
		// 이미지 첵크
		private boolean checkImageType(File file) throws ServiceException{
			CommonService.CommonServiceInfo();
			log.trace("checkImageType() invoked.");
			log.info("file : {}",file);
			
			try {
				
				log.info("file.toPath() : ",file.toPath());
				String contentType = Files.probeContentType(file.toPath());
				log.info("contentType : {}",contentType);
				
				return contentType.startsWith("image");
				
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
		}	// checkImageType
		
		// uploadAjaxAction.
		public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) throws ServiceException{
			return null;
		}
		
		// display
		public ResponseEntity<byte []> getFile(String fileName) throws ServiceException{
			return null;
		}
		
		// download
		public ResponseEntity<Resource> downloadFile(String userAgent, String fileName) throws ServiceException{
			return null;
		}
		
		// deleteFile
		public ResponseEntity<String> deleteFile(String fileName, String type) throws ServiceException{
			return null;
		}
	
	
}	// end class
