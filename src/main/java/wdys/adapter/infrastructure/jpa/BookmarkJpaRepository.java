package wdys.adapter.infrastructure.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wdys.domain.model.Bookmark;
import wdys.domain.model.Greeting;

import java.util.Optional;

public interface BookmarkJpaRepository extends JpaRepository<Bookmark, Long> {

    @Query(value = "select b from Bookmark b where b.memberId = :memberId and b.isOn = true")
    Page<Bookmark> findAllByMemberId(Long memberId, Pageable pageable);

    @Query(value = "select b from Bookmark b where b.memberId = :memberId and b.greeting = :greeting")
    Optional<Bookmark> findOneByMemberIdAndGreeting(Long memberId, Greeting greeting);

}
