package com.sample.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * 파일 업로드 유틸
 * @author kwpark
 * @since 2014.01.07
 */
public class FileUpload {

	public static int IMG_FILE = 1;
	public static int XLS_FILE = 2;
	
	private String imgArray[]={
			 "jpg"
			,"png"
			,"bmp"
			,"gif"
			,"jpeg"
	};
	
	private String xlsArray[]={
			"xls"
	};
	
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * 싱글 파일
	 * @param uploadFileType
	 * @param file
	 * @param basePath
	 * @return Map<String, String>
	 * @throws FileSizeException 
	 * @throws FileExtentionException 
	 * @throws IOException 
	 */
	public FileUploadResult fileUpload(int uploadFileType, MultipartFile file, String basePath, long maxSize) throws FileSizeException, FileExtentionException, IOException{
		
		String srcFileName = null;
		String extention = null;
		String destFileName = null;
		
		// 파일 사이즈 검사
		if(file.getSize() == 0){
			throw new FileSizeException("file size is zero.");
		}
		
		if(file.getSize() > maxSize * 1024 * 1024){	// MB 단위
			throw new FileSizeException("file size over then limit.");
		}
		
		// 파일 형식 검사
		boolean checkFile = false;
		if(uploadFileType == IMG_FILE){
			checkFile = isExtensionCheck(file, imgArray);
		}else if(uploadFileType == XLS_FILE){
			checkFile = isExtensionCheck(file, xlsArray);
		}
		
		if(!checkFile){
			throw new FileExtentionException("file extention not matched.");
		}
		
		// 한글 파일명 검사
		srcFileName = FilenameUtils.getBaseName((file.getOriginalFilename()));
		extention = FilenameUtils.getExtension(file.getOriginalFilename());	
		//if(srcFileName.matches("([a-zA-Z0-9]|[^a-zA-Z0-9|^가-힣|ㅏ-ㅣ|ㄱ-ㅎ])*([가-힣|ㅏ-ㅣ|ㄱ-ㅎ])+([a-zA-Z0-9]|[^a-zA-Z0-9|^가-힣|ㅏ-ㅣ|ㄱ-ㅎ])*")){
		if(srcFileName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")){
			//logger.debug("한글 파일입니다. temp 로 파일명을 변환합니다.");
			srcFileName = dateFormat.format(cal.getTime());
		}
		
		// 파일 업로드
		File forder = new File(basePath);
		File newFile = new File(basePath+"/"+srcFileName+"."+extention);
		
		// 디렉터리 있는지 확인
		if(!forder.isDirectory()){
			forder.mkdirs();
		}
		
		// 파일 중복 여부 체크
		int cnt = 0;
		while(true){
			cnt += 1;
			if(newFile.isFile()){
				destFileName = srcFileName+"("+String.valueOf(cnt)+")"+"."+extention;
				newFile = new File(basePath+"/"+destFileName);
			}else{
				if(cnt == 1){
					destFileName = srcFileName+"."+extention;
				}
				newFile.createNewFile();
				break;
			}
		}
	
		InputStream inputStream = file.getInputStream();
		
		OutputStream outputStream = new FileOutputStream(newFile);
		
		int read = 0;
		byte[] bytes = new byte[1024];
		
		while((read = inputStream.read(bytes)) != -1){
			outputStream.write(bytes, 0, read);
		}
		
		// 정보  입력
		FileUploadResult result = new FileUploadResult();
		result.setRealPath(basePath);
		result.setFileName(destFileName);
		result.setSrcFileName(file.getOriginalFilename());
		
		inputStream.close();
		outputStream.close();
			
		
		return result;
	}
	
	
	
	/**
	 * extention check
	 * @param file
	 * @param array
	 * @return
	 */
	private boolean isExtensionCheck(MultipartFile file, String[] array) {
		int arraySize;
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		boolean check = false;

		arraySize = array.length;
		for (int i = 0; i < arraySize; i++) {
			if (extension.equals(array[i])) {
				check = true;
			}
		}
		return check;
	}
	
	/**
	 * file upload result value object
	 * @author v.kwpark
	 *
	 */
	@Data
	public class FileUploadResult{
		private String realPath;
		private String fileName;
		private String srcFileName;
	}
	
	/**
	 * file size exception
	 * @author v.kwpark
	 *
	 */
	public class FileSizeException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public FileSizeException() { super(); }
		public FileSizeException(String message) { super(message); }
		public FileSizeException(String message, Throwable cause) { super(message, cause); }
		public FileSizeException(Throwable cause) { super(cause); }
	}
	
	/**
	 * file extention exception
	 * @author v.kwpark
	 *
	 */
	public class FileExtentionException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public FileExtentionException() { super(); }
		public FileExtentionException(String message) { super(message); }
		public FileExtentionException(String message, Throwable cause) { super(message, cause); }
		public FileExtentionException(Throwable cause) { super(cause); }
	}
}


