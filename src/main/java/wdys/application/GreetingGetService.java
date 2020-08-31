package wdys.application;

import org.springframework.data.domain.Page;
import wdys.adapter.infrastructure.jpa.BookmarkJpaRepository;
import wdys.adapter.infrastructure.jpa.GreetingJpaRepository;
import wdys.adapter.presentation.web.greeting.dto.GreetingListViewResponse;
import wdys.adapter.presentation.web.greeting.dto.GreetingDetailViewResponse;
import wdys.adapter.presentation.web.greeting.dto.GreetingSearchRequest;
import wdys.domain.model.Bookmark;
import wdys.domain.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GreetingGetService {

    private final GreetingJpaRepository greetingRepository;

    private final BookmarkJpaRepository bookmarkRepository;

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
