package com.medi.sky.service;

import com.medi.sky.domain.GuestDTO;

public interface IGuestService {
	public int register(GuestDTO gDto) throws Exception;
	public GuestDTO findGuest(GuestDTO gDto) throws Exception;
}
