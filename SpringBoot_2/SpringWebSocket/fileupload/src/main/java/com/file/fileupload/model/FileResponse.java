package com.file.fileupload.model;

public class FileResponse {

	private String fileName;
	private String fileType;
	private long Size;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return Size;
	}

	public void setSize(long size) {
		Size = size;
	}

	public FileResponse(String fileName, String fileType, long size) {
		this.fileName = fileName;
		this.fileType = fileType;
		Size = size;
	}

}
