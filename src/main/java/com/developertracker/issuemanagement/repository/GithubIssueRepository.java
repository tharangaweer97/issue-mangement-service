package com.developertracker.issuemanagement.repository;

import com.developertracker.issuemanagement.model.GithubIssue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GithubIssueRepository extends MongoRepository<GithubIssue, String> {

}