package com.hackerrank.github.service;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.EventsRepository;
import com.hackerrank.github.repository.RepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    EventsRepository eventsRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    RepoRepository repoRepository;


    public Event createEvent(Event event){
        actorRepository.save(event.getActor());
        repoRepository.save(event.getRepo());

        return eventsRepository.save(event);
    }

    public List<Event> getAllEvents(){
        List<Event> events = eventsRepository.findAll();
        Collections.sort(events,(e1,e2)->e1.getId().compareTo(e2.getId()));
        return events;
    }

    public Event getEventById(Long id){
       Optional event = eventsRepository.findById(id);
       return (Event)event.get();
    }

    public List<Event> getAllEventByRepoId(Long repoID){
        List<Event> events = eventsRepository.findAll();
        List<Event> eventsByRepoId = events.stream()
                        .filter(e->e.getRepo().getId().equals(repoID))
                        .collect(Collectors.toList());
        Collections.sort(eventsByRepoId,(e1,e2)->e1.getId().compareTo(e2.getId()));
        return eventsByRepoId;

    }
    public List<Event> getAllEventByActorId(Long actorID){
        List<Event> events = eventsRepository.findAll();
        List<Event> eventsByRepoId = events.stream()
                .filter(e->e.getActor().getId().equals(actorID))
                .collect(Collectors.toList());
        Collections.sort(eventsByRepoId,(e1,e2)->e1.getId().compareTo(e2.getId()));
        return eventsByRepoId;

    }
    public List<Event> getAllEventByRepoActorId(Long repoID, Long actorID){
        List<Event> events = eventsRepository.findAll();
        List<Event> eventsByRepoId = events.stream()
                .filter(e->e.getRepo().getId().equals(repoID))
                .filter(e->e.getActor().getId().equals(actorID))
                .collect(Collectors.toList());
        Collections.sort(eventsByRepoId,(e1,e2)->e1.getId().compareTo(e2.getId()));
        return eventsByRepoId;

    }
}
