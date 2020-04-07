package com.orhang.issuemanagement.service.impl;

import com.orhang.issuemanagement.dto.ProjectDto;
import com.orhang.issuemanagement.entity.Project;
import com.orhang.issuemanagement.repository.ProjectRepository;
import com.orhang.issuemanagement.service.ProjectService;
import com.orhang.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper){

        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if(projectCheck!=null){
            throw  new IllegalArgumentException("Project code already exist");
        }

        Project p = modelMapper.map(project,Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());

        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(ProjectDto project) {
        return null;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb = projectRepository.getOne(id);
        if(projectDb == null){
            throw  new IllegalArgumentException("Project does not exist ID:" + id);
        }

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if(projectCheck!=null && projectCheck.getId() != projectDb.getId() ){
            throw  new IllegalArgumentException("Project code already exist");
        }

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);

    }

}
