package com.rest.dbserver.db.model;

import com.rest.dbserver.model.EventRequest;
import lombok.Data;

@Data
public class Event {
    String name;
    String id;

    public Event() {this.id = null;}
    public Event(EventRequest eventRequest) {
        this.name = eventRequest.eventName;
    }
}
