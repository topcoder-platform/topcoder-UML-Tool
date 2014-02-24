package com.topcoder.service.studio.contest;
import java.lang.*;
/**
This is entity for contest_status_lu table.
*/
public class ContestStatus{
/**
entity id
*/
private Long contestStatusId;
/**
status description
*/
private String description;
/**
status icon
*/
private displayIcon;
/**
list of the next possible statuses
*/
private List<ContestStatus> statuses;
}

