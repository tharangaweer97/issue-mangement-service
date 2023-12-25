package com.developertracker.issuemanagement.controller;

import com.developertracker.issuemanagement.dto.IssueDetailsDto;
import com.developertracker.issuemanagement.model.GithubIssue;
import com.developertracker.issuemanagement.service.GithubIssueService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")

public class IssueController {
    private GithubIssueService githubIssueService;

    @GetMapping("/issues")
    public ResponseEntity<List<GithubIssue>> getGithubIssue() {
        return ResponseEntity.ok(this.githubIssueService.getGithubIssue());
    }

    @GetMapping("/issues/get-all")
    public ResponseEntity<List<GithubIssue>> getAllUsers() {
        return ResponseEntity.ok(this.githubIssueService.getAllIssues());
    }

    @GetMapping("/issues/by-user-name")
    public ResponseEntity<IssueDetailsDto> getAllIssuesByUserName(@RequestParam() String userName) {
        return ResponseEntity.ok(this.githubIssueService.getAllIssuesByUserName(userName));
    }


}

