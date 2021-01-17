package com.rest.dbserver.model;

import lombok.Data;

@Data
public class NotificationRequest {
    public String id;
    public String typeOfNotification;
    public String location;
    public String reportingTime;
    public String creationDate;
}
