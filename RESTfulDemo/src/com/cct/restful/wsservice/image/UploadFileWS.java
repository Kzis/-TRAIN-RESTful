package com.cct.restful.wsservice.image;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

@Path("/upload")
public class UploadFileWS {

	private final String PATH_SERVER = "d:/uploaded/";

	@POST
	@Path("/image")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	public Response uploadPdfFile(@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileMetaData, 
			@FormDataParam("data") String data)
			throws Exception {
		try {
			System.out.println("File >> " + fileMetaData.getFileName());
			System.out.println("Data information >> " + data);
			writeToFile(fileInputStream, fileMetaData.getFileName());
		} catch (IOException e) {
			throw new WebApplicationException("Error while uploading file. Please try again !!");
		}
		return Response.ok("Data uploaded successfully !!").build();
	}
	
	@POST
	@Path("/image2")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	public Response uploadPdfFile2(@FormDataParam("file") List<FileDataBodyPart> bodyParts,
			@FormDataParam("file") List<FormDataContentDisposition> listFileDetail, 
			@FormDataParam("data") String data)
			throws Exception {
		try {
			
			for(int i = 0; i< bodyParts.size(); i++){
				
				System.out.println(listFileDetail.get(i).getFileName());
				BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyParts.get(i).getEntity();
				String fileNames = listFileDetail.get(i).getName();
				
				writeToFile(bodyPartEntity.getInputStream(), fileNames);
				System.out.println("File >> " + fileNames);
			}
			
		} catch (IOException e) {
			throw new WebApplicationException("Error while uploading file. Please try again !!");
		}
		return Response.ok("Data uploaded successfully !!").build();
	}
	
	/**
	 * save uploaded file to new location
	 * @param uploadedInputStream
	 * @param fileName
	 * @throws IOException
	 */
	private void writeToFile(InputStream uploadedInputStream, String fileName) throws IOException {

		/* Change directory path */
		java.nio.file.Path path = FileSystems.getDefault().getPath(PATH_SERVER + fileName);
		
		/* Create directory if not exist */
		boolean isDirExist = Files.exists(path.getParent(), LinkOption.NOFOLLOW_LINKS);
		if(!isDirExist){
			Files.createDirectory(path.getParent());
		}
		
		/* Save InputStream as file */
		boolean isFileExist = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
		if(!isFileExist){
			Files.copy(uploadedInputStream, path);
		}
	}
}
