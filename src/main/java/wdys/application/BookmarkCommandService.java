package wdys.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wdys.adapter.infrastructure.jpa.BookmarkJpaRepository;
import wdys.adapter.infrastructure.jpa.GreetingJpaRepository;
import wdys.domain.model.Bookmark;
import wdys.domain.model.Greeting;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookmarkCommandService {

    private final BookmarkJpaRepository bookmarkRepository;

    private final GreetingJpaRepository greetingRepository;

    public void registerOrCancel(final Long memberId, final Long greetingId, final Boolean isOn) {
        Greeting greeting = this.greetingRepository
                .findById(greetingId)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 인사말입니다."));

        Optional<Bookmark> optionalBookmark = this.bookmarkRepository.findOneByMemberIdAndGreeting(memberId, greeting);

        Bookmark bookmark;

        if (optionalBookmark.isPresent()) {
            bookmark = optionalBookmark.get();
            bookmark.changeBookmark(isOn);
        } else {
            bookmark = Bookmark.createBookmark(memberId, isOn, greeting);
        }

        this.bookmarkRepository.save(bookmark);
    }

}
