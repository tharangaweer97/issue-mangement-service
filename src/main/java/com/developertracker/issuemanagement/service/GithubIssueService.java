package com.developertracker.issuemanagement.service;

import com.developertracker.issuemanagement.model.GithubIssue;

import java.util.List;




public interface GithubIssueService {
    List<GithubIssue> getGithubIssue();

    List<GithubIssue> getAllIssues();
}
