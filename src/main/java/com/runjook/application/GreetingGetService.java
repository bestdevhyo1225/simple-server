package com.runjook.application;

import com.runjook.adapter.presentation.web.greeting.dto.GreetingListViewResponse;
import com.runjook.adapter.presentation.web.greeting.dto.GreetingDetailViewResponse;
import com.runjook.adapter.presentation.web.greeting.dto.GreetingSearchRequest;
import com.runjook.domain.BookmarkRepository;
import com.runjook.domain.GreetingRepository;
import com.runjook.domain.model.Bookmark;
import com.runjook.domain.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GreetingGetService {

    private final GreetingRepository greetingRepository;

    private final BookmarkRepository bookmarkRepository;

    public List<GreetingListViewResponse> findGreetings(final GreetingSearchRequest greetingSearchRequest,
                                                        final Pageable pageable) {
        Page<Greeting> greetings = this.greetingRepository.findAllBySearchParams(
                greetingSearchRequest.getSituation(),
                greetingSearchRequest.getHonorific(),
                greetingSearchRequest.getSentenceLength(),
                pageable
        );

        HashMap<Greeting, Boolean> hashMapForIdCheck = this.createHashMapForBookmarkCheck(
                greetingSearchRequest.getMemberId(),
                pageable
        );

        return GreetingListViewResponse.toList(greetings, hashMapForIdCheck);
    }

    private HashMap<Greeting, Boolean> createHashMapForBookmarkCheck(final Long memberId, final Pageable pageable) {
        HashMap<Greeting, Boolean> hashMapForIdCheck = new HashMap<>();

        if (!Objects.isNull(memberId)) {
            Page<Bookmark> bookmarks = this.bookmarkRepository.findAllByMemberId(memberId, pageable);

            bookmarks.forEach(bookmark -> hashMapForIdCheck.put(bookmark.getGreeting(), true));
        }

        return hashMapForIdCheck;
    }

    public GreetingDetailViewResponse findGreeting(final Long id) {
        Greeting greeting = this.greetingRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 인사말입니다."));

        return GreetingDetailViewResponse.of(greeting);
    }

}
