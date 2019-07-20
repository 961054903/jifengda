package com.caogen.jfd.converter;

import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.caogen.jfd.common.Constants;

/**
 * 
 * @author Spuiln
 *
 */
public class GsonConverter extends GsonHttpMessageConverter {

	public GsonConverter() {
		super.setGson(Constants.gson);
	}
}
