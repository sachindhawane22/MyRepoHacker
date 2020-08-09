package com.hackerrank.github.controller;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Repo;
import com.hackerrank.github.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/events")
public class EventsController {

    Map<Long,Event> eventMap = new HashMap<>();

    @Autowired
    EventService eventService;

    @PostMapping(value = "/" )
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        return ResponseEntity.ok().body(eventService.createEvent(event));
        //eventService.createEvent(event);
        //return null;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.ok().body(eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body( eventService.getEventById(id));

    }

    @GetMapping("/repos/{repoID}")
    public ResponseEntity<List<Event>> getAllEventByRepoId(@PathVariable(value = "repoID") Long repoID){

        return ResponseEntity.ok().body(eventService.getAllEventByRepoId(repoID));
    }

    @GetMapping("/actors/{actorID}")
    public ResponseEntity<List<Event>> getAllEventByActorId(@PathVariable(value = "actorID") Long actorID){

        return ResponseEntity.ok().body(eventService.getAllEventByActorId(actorID));
    }

    @GetMapping("/repos/{repoID}/actors/{actorID}")
    public ResponseEntity<List<Event>> getAllEventByRepoActorId(@PathVariable(value = "repoID") Long repoID, @PathVariable(value = "actorID") Long actorID){

        return ResponseEntity.ok().body(eventService.getAllEventByRepoActorId(repoID,actorID));
    }
}
