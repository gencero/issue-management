package com.orhang.issuemanagement.service.impl;

import com.orhang.issuemanagement.entity.IssueHistory;
import com.orhang.issuemanagement.repository.IssueHistoryRepository;
import com.orhang.issuemanagement.service.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {
    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository){
        this.issueHistoryRepository = issueHistoryRepository;
    }
    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if (issueHistory.getDate() == null){
            throw  new IllegalArgumentException("issue can not be null");
        }

        return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return null;
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        return null;
    }
}
