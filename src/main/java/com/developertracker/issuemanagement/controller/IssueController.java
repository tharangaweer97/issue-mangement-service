package com.developertracker.issuemanagement.controller;

import com.developertracker.issuemanagement.model.GithubIssue;
import com.developertracker.issuemanagement.service.GithubIssueService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")

public class IssueController {
    private GithubIssueService githubIssueService;

    @GetMapping("/contributors")
    public ResponseEntity<List<GithubIssue>> getGithubIssue() {
        return ResponseEntity.ok(this.githubIssueService.getGithubIssue());
    }

    @GetMapping("/contributors/get-all")
    public ResponseEntity<List<GithubIssue>> getAllUsers() {
        return ResponseEntity.ok(this.githubIssueService.getAllIssues());
    }
}
