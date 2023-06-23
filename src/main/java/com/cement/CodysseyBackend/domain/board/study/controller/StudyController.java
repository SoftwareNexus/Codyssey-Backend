package com.cement.CodysseyBackend.domain.board.study.controller;

import com.cement.CodysseyBackend.domain.board.study.domain.Study;
import com.cement.CodysseyBackend.domain.board.study.dto.StudyCreateRequest;
import com.cement.CodysseyBackend.domain.board.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/study")
public class StudyController {

    private final StudyService studyService;

    @PostMapping
    public ResponseEntity<Study> createStudy(@RequestBody StudyCreateRequest request) {
        Study createdStudy = studyService.createStudy(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdStudy);
    }
}