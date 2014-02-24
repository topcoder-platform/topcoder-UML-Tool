package com.topcoder.service.studio.contest;
import java.lang.*;
/**
 * This is entity for  contest_type_lu table
*/
public class ContestType{
/**
 * entity id
*/
private Long contestTypeId;
/**
 * description of contest type
*/
private String description;
/**
 * flag for file preview
*/
private Boolean requirePreviewFile;
/**
 * flag for image preview
*/
private Boolean requirePreviewImage;
/**
 * list of configuration parameters
*/
private List<Config> config;
}

