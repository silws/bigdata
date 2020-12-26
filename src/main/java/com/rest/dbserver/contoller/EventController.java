package com.rest.dbserver.contoller;

import com.rest.dbserver.db.DatabaseService;
import com.rest.dbserver.db.model.Event;
import com.rest.dbserver.model.EventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("event")
@RequestMapping("/event")
public class EventController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping("/saveEvent")
    @ResponseStatus(code = HttpStatus.OK)
    public String saveEvent(@RequestBody EventRequest eventRequest) {
        databaseService.saveEvent(new Event(eventRequest));
        return eventRequest.eventName;
    }

    @GetMapping("/getEvent")
    @ResponseStatus(code = HttpStatus.OK)
    public Event getEvent(@RequestParam String id) {
        Event event = databaseService.getEvent(id);
        return event;
    }

    @GetMapping("/getEvents")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Event> getEvents() {
        List<Event> events = databaseService.getEvents();
        return events;
    }
}
