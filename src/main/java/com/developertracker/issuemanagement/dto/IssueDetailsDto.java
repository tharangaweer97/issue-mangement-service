package com.developertracker.issuemanagement.dto;

import com.developertracker.issuemanagement.model.GithubIssue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueDetailsDto {

    private int issueCount;

    private List<GithubIssue> userIssueList;
}