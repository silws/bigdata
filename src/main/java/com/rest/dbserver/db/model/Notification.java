package com.rest.dbserver.db.model;

import com.rest.dbserver.model.NotificationRequest;
import lombok.Data;

@Data
public class Notification {
    String id;
    String typeOfNotification;
    String location;
    String reportingTime;
    String creationDate;

    public Notification() {
        this.id = null;
        this.typeOfNotification = null;
        this.location = null;
        this.reportingTime = null;
        this.creationDate = null;
    }
    public Notification(NotificationRequest notificationRequest) {
        this.id = notificationRequest.id;
        this.typeOfNotification = notificationRequest.typeOfNotification;
        this.location = notificationRequest.location;
        this.reportingTime = notificationRequest.reportingTime;
        this.creationDate = notificationRequest.creationDate;
    }
}
