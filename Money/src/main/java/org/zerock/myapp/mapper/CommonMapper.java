package org.zerock.myapp.mapper;

import org.zerock.myapp.domain.AttachFileDTO;

public interface CommonMapper {
	
	// 사용자의 이미지를 DB에 저장함 
	public abstract Integer insertUserImageUpload(String userEmail,String fileName,String uuidFileName, String uploadPath, String uuid,String checkImage);
	
	// 사용자가 저장한 이미지들 중에서 가장 마지막에 저장한 이미지 경로 등을 들고옴 
	public abstract AttachFileDTO getUserImageInfo(String userEmail);
}	// end interface
