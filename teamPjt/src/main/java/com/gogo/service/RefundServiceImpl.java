package com.gogo.service;

import org.springframework.stereotype.Service;

import com.gogo.mapper.RefundMapper;
import com.gogo.vo.RefundVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService {
	
	private final RefundMapper refundMapper;
	
	@Override
	public int insertRefund(RefundVO vo) {
		return refundMapper.insertRefund(vo);
	}

	@Override
	public RefundVO selectOne(String paymentNo) {
		return refundMapper.selectOne(paymentNo);
	}

}
