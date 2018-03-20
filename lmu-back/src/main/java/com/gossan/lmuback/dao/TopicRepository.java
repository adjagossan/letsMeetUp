package com.gossan.lmuback.dao;

import com.gossan.lmuback.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "topics", path="topic", exported = false)
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
