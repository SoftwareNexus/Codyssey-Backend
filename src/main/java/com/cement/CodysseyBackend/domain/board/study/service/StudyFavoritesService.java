package com.cement.CodysseyBackend.domain.board.study.service;

import com.cement.CodysseyBackend.domain.board.favorites.domain.StudyFavorites;
import com.cement.CodysseyBackend.domain.board.favorites.repository.StudyFavoritesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyFavoritesService {

    private final StudyFavoritesRepository studyFavoritesRepository;

    public List<StudyFavorites> getMemberStudyFavorites(Long memberId) {
        List<StudyFavorites> studyFavoritesList = studyFavoritesRepository.findByMemberId(memberId);
        return studyFavoritesList;
    }
}
