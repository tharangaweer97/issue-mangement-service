package com.developertracker.issuemanagement.service.external;

import com.developertracker.issuemanagement.dto.GithubIssueDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
@Slf4j
public class GithubExternalClient {

    private final RestTemplate restTemplate;

    @Value("${github.issue-detail-url}")
    private String githubIssueDetailsUrl;

    public GithubExternalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GithubIssueDto> getIssueDetails() {
        ResponseEntity<List<GithubIssueDto>> response = restTemplate.exchange(githubIssueDetailsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }


}