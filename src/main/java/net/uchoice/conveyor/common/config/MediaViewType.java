package net.uchoice.conveyor.common.config;

import java.util.regex.Pattern;

public class MediaViewType {

	public static final String WORD = "^.*.(doc|docx|DOC|DOCX|wps|WPS)$";
	
	public static final String HTML = "^.*.(pdf|PDF|jpg|JPG|png|PNG|gif|GIF|bmp|BMP)$";
	
	public static final String FLV = "^.*.(flv|FLV|mp4|MP4|avi|AVI)$";
	
	public static boolean isWordView(String file){
		Pattern p = Pattern.compile(WORD);
		return p.matcher(file).matches();
	}
	
	public static boolean isHtmlView(String file){
		Pattern p = Pattern.compile(HTML);
		return p.matcher(file).matches();
	}
	
	public static boolean isFlvView(String file){
		Pattern p = Pattern.compile(FLV);
		return p.matcher(file).matches();
	}
}
