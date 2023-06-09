package com.cement.CodysseyBackend.domain.board.community.repository;

import com.cement.CodysseyBackend.domain.board.community.domain.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
    List<Community> findByIsDeleted(boolean isDeleted);
}
