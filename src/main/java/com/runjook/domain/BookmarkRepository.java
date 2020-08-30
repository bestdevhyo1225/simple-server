package com.runjook.domain;

import com.runjook.domain.model.Greeting;
import com.runjook.domain.model.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookmarkRepository {

    Page<Bookmark> findAllByMemberId(Long memberId, Pageable pageable);

    Optional<Bookmark> findByGreetingAndMemberId(final Greeting greeting, final Long memberId);

}
