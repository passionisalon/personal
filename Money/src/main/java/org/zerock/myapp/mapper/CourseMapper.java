package org.zerock.myapp.mapper;

import java.util.LinkedList;

import org.zerock.myapp.domain.CourseDTO;
import org.zerock.myapp.domain.TravelDTO;

public interface CourseMapper {

	// Course게시판의 게시물을 들고오는 역할 
	public abstract LinkedList<CourseDTO> getCourseList(CourseDTO courseDTO);
	
	// Course게시판의 여행지 목록을 가지는 역할
	public abstract LinkedList<TravelDTO> getSelectCourseTravelList(CourseDTO courseDTO);
	
}	// end interface
