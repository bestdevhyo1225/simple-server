package com.runjook.whatdoyousayspringserver.adapter.infrastructure.jpa;

import com.runjook.whatdoyousayspringserver.domain.GreetingRepository;
import com.runjook.whatdoyousayspringserver.domain.model.Greeting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GreetingJpaRepository extends JpaRepository<Greeting, Long>, GreetingRepository {

    @Query(value = "select g from Greeting g " +
            "where g.situation = :situation " +
            "and g.honorific = :honorific " +
            "and g.sentenceLength = :sentenceLength")
    Page<Greeting> findAllBySearchParams(String situation, String honorific, String sentenceLength, Pageable pageable);
}
