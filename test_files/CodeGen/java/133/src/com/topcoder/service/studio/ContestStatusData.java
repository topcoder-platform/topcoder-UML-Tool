package com.topcoder.service.studio;
import java.lang.*;
/**
 * DTO class which is used to transfer contest status data
*/
public class ContestStatusData{
/**
 * status id
*/
private long satusId;
/**
 * status name
*/
private String name;
/**
 * status description
*/
private String description;
/**
 * allowable next statuses
*/
private List<Long> allowableNextStatus;
/**
 * display icon
*/
private String displayIcon;
}

