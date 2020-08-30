package com.runjook.whatdoyousayspringserver.adapter.infrastructure.jpa;

import com.runjook.whatdoyousayspringserver.domain.BookmarkRepository;
import com.runjook.whatdoyousayspringserver.domain.model.Bookmark;
import com.runjook.whatdoyousayspringserver.domain.model.Greeting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookmarkJpaRepository extends JpaRepository<Bookmark, Long>, BookmarkRepository {

    @Query("select b from Bookmark b where b.memberId = :memberId")
    Page<Bookmark> findAllByMemberId(Long memberId, Pageable pageable);

    @Query("select b from Bookmark b where b.greeting = :greeting and b.memberId = :memberId")
    Optional<Bookmark> findByGreetingAndMemberId(final Greeting greeting, final Long memberId);

}
