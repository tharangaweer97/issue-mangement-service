package com.developertracker.issuemanagement.service;

import com.developertracker.issuemanagement.dto.GithubIssueDto;
import com.developertracker.issuemanagement.dto.IssueDetailsDto;
import com.developertracker.issuemanagement.model.GithubIssue;
import com.developertracker.issuemanagement.repository.GithubIssueRepository;
import com.developertracker.issuemanagement.service.external.GithubExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class GithubIssueServiceImpl implements GithubIssueService {

    private final GithubExternalClient githubExternalClient;
    private final GithubIssueRepository githubIssueRepository;

    @Override
    public List<GithubIssue> getGithubIssue() {
        List<GithubIssue> githubIssues = new ArrayList<>();

        List<GithubIssueDto> githubIssueDtoList = this.githubExternalClient.getIssueDetails();
        githubIssueDtoList.forEach(githubIssueDto -> {
            GithubIssue githubIssue = this.generateGithubIssueObject(githubIssueDto);
            githubIssues.add(githubIssue);
        });

        this.githubIssueRepository.saveAll(githubIssues);

        return githubIssues;


    }

    @Override
    public List<GithubIssue> getAllIssues() {
        return this.githubIssueRepository.findAll();
    }

    @Override
    public IssueDetailsDto getAllIssuesByUserName(String userName) {
        List<GithubIssue> githubIssues = this.githubIssueRepository.findAllByUserName(userName.trim());
        return IssueDetailsDto.builder().issueCount(githubIssues.size()).userIssueList(githubIssues).build();
    }


    private GithubIssue generateGithubIssueObject(GithubIssueDto githubIssueDto) {
        return GithubIssue.builder()
                .userName(githubIssueDto.getUserDto().getLogin())
                .title(githubIssueDto.getTitle())
                .createdAt(githubIssueDto.getCreated_at())
                .updatedAt(githubIssueDto.getUpdated_at())
                .type(githubIssueDto.getUserDto().getType())
                .build();



    }

}


