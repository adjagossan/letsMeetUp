package com.gossan.lmuback.dao;

import com.gossan.lmuback.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;


@PreAuthorize("hasRole('ORGANIZER')")
@RepositoryRestResource(collectionResourceRel = "events", path="event")
public interface EventRepository extends CrudRepository<Event, Long> {

    @Override
    @PreAuthorize("#event?.organizer == null or #event?.organizer?.mail == authentication?.mail")
    Event save(@Param("event") Event event);
}
