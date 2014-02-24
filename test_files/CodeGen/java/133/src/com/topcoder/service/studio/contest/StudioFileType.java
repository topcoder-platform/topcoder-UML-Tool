package com.topcoder.service.studio.contest;
import java.lang.*;
/**
 * This is entity for file_type_lu table
*/
public class StudioFileType{
/**
 * id of file type
*/
private Long studioFileType;
/**
 * map with supported mime types
*/
private Set<MimeType> mimeTypes description = new HashSet<MimeType>();
/**
 * sort
*/
private Integer sort;
/**
 * if image file
*/
private Boolean imageFile;
/**
 * Extension of file
*/
private String extension;
}

