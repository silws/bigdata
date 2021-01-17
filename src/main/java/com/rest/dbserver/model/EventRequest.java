package com.rest.dbserver.model;

import lombok.Data;

@Data
public class EventRequest {
    public String eventName;
    public String alertCode;
    public String classificationTag;
    public String location;
    public String picture;
    public String reportingTime;
}
