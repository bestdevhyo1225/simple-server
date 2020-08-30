package com.runjook.whatdoyousayspringserver.domain;

import com.runjook.whatdoyousayspringserver.domain.model.Bookmark;
import com.runjook.whatdoyousayspringserver.domain.model.Greeting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookmarkRepository {

    Page<Bookmark> findAllByMemberId(Long memberId, Pageable pageable);

    Optional<Bookmark> findByGreetingAndMemberId(final Greeting greeting, final Long memberId);

}
