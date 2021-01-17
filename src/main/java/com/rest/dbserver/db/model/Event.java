package com.rest.dbserver.db.model;

import com.rest.dbserver.model.EventRequest;
import lombok.Data;

@Data
public class Event {
    String name;
    String id;
    String alertCode;
    String classificationTag;
    String location;
    String picture;
    String reportingTime;

    public Event() {
        this.id = null;
        this.alertCode = null;
        this.classificationTag = null;
        this.location = null;
        this.picture = null;
        this.reportingTime = null;
    }
    public Event(EventRequest eventRequest) {

        this.name = eventRequest.eventName;
        this.alertCode = eventRequest.alertCode;
        this.classificationTag = eventRequest.classificationTag;
        this.location = eventRequest.location;
        this.picture = eventRequest.picture;
        this.reportingTime = eventRequest.reportingTime;
    }
}
