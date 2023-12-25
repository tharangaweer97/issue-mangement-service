package com.developertracker.issuemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "github_issues")

public class GithubIssue {

    @Id
    private String userName;

    private String title;

    private String createdAt;

    private String updatedAt;

    private String type;

}