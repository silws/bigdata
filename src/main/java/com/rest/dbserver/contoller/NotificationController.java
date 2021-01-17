package com.rest.dbserver.contoller;

import com.rest.dbserver.db.DatabaseService;
import com.rest.dbserver.db.model.Notification;
import com.rest.dbserver.model.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("notification")
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping("/saveNotification")
    @ResponseStatus(code = HttpStatus.OK)
    public String saveNotification(@RequestBody NotificationRequest notificationRequest) {
        databaseService.saveNotification(new Notification(notificationRequest));
        return notificationRequest.typeOfNotification;
    }

    @GetMapping("/getNotifications")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Notification> getNotifications() {
        List<Notification> notifications = databaseService.getNotifications();
        System.out.println(notifications);
        return notifications;
    }
}
