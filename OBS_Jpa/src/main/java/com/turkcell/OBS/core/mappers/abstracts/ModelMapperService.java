package com.turkcell.OBS.core.mappers.abstracts;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {


	ModelMapper forDto();

	ModelMapper forRequest();
}
