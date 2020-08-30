package com.runjook.adapter.infrastructure.jpa;

import com.runjook.domain.model.Greeting;
import com.runjook.domain.BookmarkRepository;
import com.runjook.domain.model.Bookmark;
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
