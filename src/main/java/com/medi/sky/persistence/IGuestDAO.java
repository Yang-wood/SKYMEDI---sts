package com.medi.sky.persistence;

import com.medi.sky.domain.GuestDTO;

public interface IGuestDAO {
	public int insert(GuestDTO gDto);
	public GuestDTO findGuest(GuestDTO gDto);
}
