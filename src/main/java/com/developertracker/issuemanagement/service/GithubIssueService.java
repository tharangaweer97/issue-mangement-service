package com.developertracker.issuemanagement.service;

import com.developertracker.issuemanagement.dto.IssueDetailsDto;
import com.developertracker.issuemanagement.model.GithubIssue;

import java.util.List;




public interface GithubIssueService {
    List<GithubIssue> getGithubIssue();

    List<GithubIssue> getAllIssues();

    IssueDetailsDto getAllIssuesByUserName(String userName);
}



