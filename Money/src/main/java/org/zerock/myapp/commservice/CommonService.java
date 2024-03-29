package org.zerock.myapp.commservice;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.myapp.domain.AttachFileDTO;
import org.zerock.myapp.exception.ServiceException;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;

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
		private static String getFolder() throws ServiceException{
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
		private static boolean checkImageType(File file) throws ServiceException{
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
		public static ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile,String boardName)
				throws ServiceException{
			CommonService.CommonServiceInfo();
			log.trace("uploadAjaxPost() invoked.");
			log.info("uploadFile : {}",uploadFile);
			log.info("boardName : {}",boardName);
			
			if(boardName == null | boardName.isEmpty()) {
				log.info("boardName이 비어있습니다. 해당 첨부파일을 처리할 수 없습니다.");
				log.info("boardName의 값은 {} 입니다. 확인부탁드립니다.",boardName);
				
				return null;
			}
			
			if(uploadFile == null) {
				log.info("uploadFile이 비어있습니다. 해당 첨부파일을 처리 할 수 없습니다. ");
				log.info("uploadFile의 값은 {}입니다. 확인부탁드립니다.",uploadFile);
				
				return null;
			}
			
			String uploadFolder = "/resources/upload/";
			log.info("uploadFolder : {}",uploadFolder);
			
			String uploadFolderPath = CommonService.getFolder();
			log.info("uploadFolderPath : {}",uploadFolderPath);
			
			File uploadPath = new File(uploadFolder, uploadFolderPath);
			log.info("uploadPath : {}",uploadPath);
			
			if(uploadPath.exists() == false) {
				log.info("정확한 디렉토리 경로가 없기 때문에 해당 uploadPath에 맞는 디렉토리를 생성합니다.");
				uploadPath.mkdirs();
			}	// end if
			
			List<AttachFileDTO> list = new ArrayList<>();
			
			
			for(MultipartFile multiFile : uploadFile) {
				
				AttachFileDTO attachDTO = new AttachFileDTO();
				
				String uploadFileName = multiFile.getOriginalFilename();
				log.info("upload File Name : {}",uploadFileName);
				log.info("upload File Size : {}",multiFile.getSize());

				// IE has file path
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("//")+1);
				log.info("upload File Name : {}",uploadFileName);
				
				// attachDTO에 uploadFileName을 넣는다.
				attachDTO.setFileName(uploadFileName);
				log.info("attachDTO에 setFileName Set!!!");
								
				// UUID 만들어 넣기
				UUID uuid = UUID.randomUUID();
				uploadFileName = uuid.toString()+"_"+uploadFileName;
				log.info("uploadFileName : {}",uploadFileName);
				
				try {
					File saveFile = new File(uploadPath, uploadFileName);
					log.info("saveFile : {}",saveFile);
					
					log.info("multiFile.transferTo(File file)");
					multiFile.transferTo(saveFile);
					log.info("!!!Success upload File!!!");
					
					attachDTO.setUuid(uuid.toString());
					attachDTO.setUploadPath(uploadFolderPath);
					log.info("uuid.toString() : {}",uuid.toString());
					log.info("uploadPath : {}",uploadFolderPath);
					
					if(CommonService.checkImageType(saveFile)) {
						attachDTO.setImage(true);
						FileOutputStream thumbnail = 
								new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
						log.info("thumbnail : {}",thumbnail);
						Thumbnailator.createThumbnail(multiFile.getInputStream(),thumbnail,100,100);
						thumbnail.close();
					}	// end if
					
					
					// add to List
					list.add(attachDTO);
					log.info("list : {}",list);
					
				}catch(Exception e) {
					throw new ServiceException(e);
				}	// end try-catch
				
				
			}	// end for
			
			
			return new ResponseEntity<>(list,HttpStatus.OK);
		}	// uploadAjaxPost
		
		// display
		public static ResponseEntity<byte []> getFile(String fileName) throws ServiceException{
			CommonService.CommonServiceInfo();
			log.trace("getFile() invoked.");
			log.info("fileName : {}",fileName);
			
			File file = new File("/resources/upload/"+fileName);
			log.info("file : {}",file);
			
			ResponseEntity<byte[]> result = null;
			
			try {
				HttpHeaders header = new HttpHeaders();
				log.info("header : {}",header);
				header.add("Content-Type", Files.probeContentType(file.toPath()));
				log.info("header : {}",header);
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
				log.info("result : {}",result);
				
				return result;
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
			
		}	// end getFile
		
		// download
		public static ResponseEntity<Resource> downloadFile(String userAgent, String fileName) throws ServiceException{
			CommonService.CommonServiceInfo();
			log.trace("downloadFile() invoked.");
			log.info("userAgent : {}",userAgent);
			log.info("fileName : {}",fileName);
			
			FileSystemResource resource = 
					new FileSystemResource("/resources/upload"+fileName);
			log.info("resource : {}",resource);
			
			if(resource.exists() == false) {
				log.info("resource.exists false입니다.");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}	// end if
			
			String resourceName = resource.getFilename();
			log.info("resourceName : {}",resourceName);
			
			String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1);
			
			HttpHeaders headers = new HttpHeaders();
			log.info("headers : {}",headers);
			
			try {
				String downloadName = null;
				
				if(userAgent.contains("trident")) {
					log.info("IE browser");
					downloadName = URLEncoder.encode(resourceOriginalName,"UTF-8");
				}else if(userAgent.contains("Edge browser")) {
					log.info("Edge brwser");
					downloadName = URLEncoder.encode(resourceOriginalName,"UTF-8");
				}else {
					log.info("Chrome browser");
					downloadName = new String(resourceOriginalName.getBytes("UTF-8"),"ISO-8859-1");
				}
				
				log.info("downloadName : {}",downloadName);
				
				headers.add("Content-Disposition","attachment; filename="+downloadName);
				log.info("headers : {}",headers);
						
				return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
			
		}	// end downloadFile
		
		// deleteFile
		public static ResponseEntity<String> deleteFile(String fileName, String type) throws ServiceException{
			CommonService.CommonServiceInfo();
			log.trace("deleteFile() invoked.");
			log.info("fileName : {}",fileName);
			log.info("type : {}",type);
			
			File file;
			try {
				file = new File("/resources/upload/"+URLDecoder.decode(fileName,"UTF-8"));
				log.info("file : {}",file);
				file.delete();
				
				if(type.equals("image")) {
					String largeFileName = file.getAbsolutePath().replace("s_","");
					log.info("largeFileName : {}",largeFileName);
					file = new File(largeFileName);
					file.delete();
				}	// end if
				
				return new ResponseEntity<String>("deleted",HttpStatus.OK);
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
			
		}	// deleteFile
	
	
}	// end class
