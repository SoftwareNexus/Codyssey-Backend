package com.cement.CodysseyBackend.domain.board.project.controller;


import com.cement.CodysseyBackend.domain.board.project.domain.Project;
import com.cement.CodysseyBackend.domain.board.project.domain.ProjectApplicant;
import com.cement.CodysseyBackend.domain.board.project.domain.ProjectRecruit;
import com.cement.CodysseyBackend.domain.board.project.dto.ProjectApplyRequest;
import com.cement.CodysseyBackend.domain.board.project.service.ProjectApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/project/apply")
public class ProjectApplyController {

    private final ProjectApplyService projectApplyService;

    // 프로젝트 지원기능
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ProjectApplicant applyProject(@RequestBody ProjectApplyRequest request){
        ProjectApplicant projectApplicant =
                projectApplyService.applyProject(request);

        return projectApplicant;

    }

    // 프로젝트 지원 거절기능
    @DeleteMapping("/{projectId}/refusal")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectApplicant> applyCancelProject (@PathVariable("projectId") Long projectId,
                                                      @RequestParam Long userId){
        List<ProjectApplicant> projectApplicants = projectApplyService.cancelApplyProject(projectId, userId);
        return projectApplicants;
    }

    // 프로젝트 지원 수락
    @GetMapping("{projectId}/accept")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectRecruit acceptProject(@PathVariable("projectId") Long projectId,
                                        @RequestParam Long userId){
        ProjectRecruit projectRecruit = projectApplyService.acceptApplyProject(projectId, userId);

        return projectRecruit;
    }
}
