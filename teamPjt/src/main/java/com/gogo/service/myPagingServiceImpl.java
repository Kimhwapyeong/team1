package com.gogo.service;

import org.springframework.stereotype.Service;

import com.gogo.mapper.myPagingMapper;
import com.gogo.vo.Criteria;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class myPagingServiceImpl implements myPagingService {
	
	private final myPagingMapper mapper;
	
	
	// 호스트 - 숙소 관리 페이징
	@Override
	public int hostayCnt(Criteria cri, String memberId) {
		return mapper.hostayCnt(cri, memberId);
	}
	

}
