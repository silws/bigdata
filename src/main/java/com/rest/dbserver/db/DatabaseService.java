package com.rest.dbserver.db;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.rest.dbserver.db.config.FirebaseInitializer;
import com.rest.dbserver.db.model.Event;
import com.rest.dbserver.db.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class DatabaseService {
    @Autowired
    FirebaseInitializer db;

    private CollectionReference getEventsCollection() {
        return db.getDb().collection("events");
    }
    private CollectionReference getNotificationsCollection() {
        return db.getDb().collection("notifications");
    }
    public void saveEvent(Event eventModel) {
        ApiFuture<WriteResult> collectionApiFuture = getEventsCollection().document(Long.toString(System.currentTimeMillis())).set(eventModel);
    }

    public void saveNotification(Notification notificationModel) {
        ApiFuture<WriteResult> collectionApiFuture = getNotificationsCollection().document(Long.toString(System.currentTimeMillis())).set(notificationModel);
    }

    public Event getEvent(String id) {
        DocumentReference documentReference = getEventsCollection().document(id);
        ApiFuture<DocumentSnapshot> future =  documentReference.get();
        DocumentSnapshot documentSnapshot = null;
        Event event = null;

        try {
            documentSnapshot = future.get();
            if (documentSnapshot.exists()) {
                event = documentSnapshot.toObject(Event.class);
                event.setId(documentSnapshot.getId());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return event;
    }

    public List<Event> getEvents() {
        ApiFuture<QuerySnapshot> queryFuture = getEventsCollection().get();
        List<Event> events = new ArrayList<>();
        try {
            QuerySnapshot querySnapshot = queryFuture.get();
            querySnapshot.getDocuments().forEach(queryDocumentSnapshot -> {
                Event event;
                event = queryDocumentSnapshot.toObject(Event.class);
                event.setId(queryDocumentSnapshot.getId());
                events.add(event);
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return events;
    }

    public List<Notification> getNotifications() {
        ApiFuture<QuerySnapshot> queryFuture = getNotificationsCollection().get();
        List<Notification> notifications = new ArrayList<>();
        try {
            QuerySnapshot querySnapshot = queryFuture.get();
            querySnapshot.getDocuments().forEach(queryDocumentSnapshot -> {
                Notification notification;
                notification = queryDocumentSnapshot.toObject(Notification.class);
                notification.setId(queryDocumentSnapshot.getId());
                notifications.add(notification);
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return notifications;
    }
}
