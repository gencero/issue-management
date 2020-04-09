package com.orhang.issuemanagement.service.impl;

import com.orhang.issuemanagement.dto.IssueDto;
import com.orhang.issuemanagement.dto.IssueHistoryDto;
import com.orhang.issuemanagement.entity.Issue;
import com.orhang.issuemanagement.entity.IssueHistory;
import com.orhang.issuemanagement.repository.IssueHistoryRepository;
import com.orhang.issuemanagement.repository.IssueRepository;
import com.orhang.issuemanagement.service.IssueHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    @Autowired
    private final IssueHistoryRepository issueHistoryRepository;
    private final ModelMapper modelMapper;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository, ModelMapper modelMapper){
        this.issueHistoryRepository = issueHistoryRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public IssueHistoryDto save(IssueHistoryDto issueHistory) {

        if(issueHistory.getDate()==null){
            throw new IllegalArgumentException("issue can not be null");
        }

        IssueHistory issueHistoryDb = modelMapper.map(issueHistory, IssueHistory.class);
        issueHistoryDb = issueHistoryRepository.save(issueHistoryDb);
        return modelMapper.map(issueHistoryDb, IssueHistoryDto.class);
    }

    @Override
    public IssueHistoryDto getById(Long id) {
        return null;
    }

    @Override
    public Page<IssueHistoryDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(IssueHistoryDto issueHistory) {
        return null;
    }
}
