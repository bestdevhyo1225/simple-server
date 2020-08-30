package com.runjook.whatdoyousayspringserver.domain;

import com.runjook.whatdoyousayspringserver.domain.model.Greeting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GreetingRepository {

    Page<Greeting> findAllBySearchParams(String situation, String honorific, String sentenceLength, Pageable pageable);

    Greeting save(final Greeting greeting);

    Optional<Greeting> findById(final Long id);
}
