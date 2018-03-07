package com.sample.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sample.common.FileUpload;
import com.sample.common.FileUpload.FileExtentionException;
import com.sample.common.FileUpload.FileSizeException;
import com.sample.common.FileUpload.FileUploadResult;

@Controller
@RequestMapping("/file")
public class FileController {

	Logger logger = LogManager.getLogger(SampleController.class);
	
	/**
	 * application.properties 의  system.file.path 값 호출
	 * 'applicationProp' properties 는 context-properties.xml 에 정의함. 
	 */
	@Value("#{applicationProp['system.file.path']}")
	private String filePath;
	
	@Value("#{applicationProp['system.file.url']}")
	private String fileUrl;
	
	@Value("#{commonProp['system.file.maxSize']}")
	private long fileSizeLimit;
	
	
	@Autowired
	private FileUpload fileUpload;
	
	/**
	 * file upload page
	 * @return
	 */
	@RequestMapping(value="/file.do", method=RequestMethod.GET)
	public String file(
			){
		return "sample/file";
	}
	
	/**
	 * upload process
	 * @param mRequest
	 */
	@RequestMapping(value="/filePS.do", method=RequestMethod.POST)
	public @ResponseBody FileUploadResult filePS(
				MultipartHttpServletRequest mRequest
				, HttpServletResponse response
			){

		try {
			FileUploadResult result = fileUpload.fileUpload(FileUpload.IMG_FILE, mRequest.getFile("file1"), filePath, fileSizeLimit);
			
			logger.debug("filePath : " + result.getRealPath());
			logger.debug("fileName : " + result.getFileName());
			logger.debug("fileSrcName : " + result.getSrcFileName());
			
			// 최종 접근 가능 url
			// local에 apache webserver 를 구동하여 /KAL_DEV/upload 폴더를 http://localhost/upload 로 접근 가능하게 하여야 테스트 가능 함.
			logger.debug("access url : " + fileUrl + "/" + result.getFileName());
			
			return result;
			
			
		} catch (FileSizeException e) {
			e.printStackTrace();
		} catch (FileExtentionException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
}
