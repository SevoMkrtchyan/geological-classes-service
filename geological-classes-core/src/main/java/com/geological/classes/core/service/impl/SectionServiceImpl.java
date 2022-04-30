package com.geological.classes.core.service.impl;

import com.geological.classes.core.exception.EntityNotFoundException;
import com.geological.classes.core.mapper.SectionMapper;
import com.geological.classes.core.service.SectionService;
import com.geological.classes.data.access.entity.GeologicClass;
import com.geological.classes.data.access.entity.Section;
import com.geological.classes.data.access.repository.GeologicClassRepository;
import com.geological.classes.data.access.repository.SectionRepository;
import com.geological.classes.data.transfer.request.SectionRequest;
import com.geological.classes.data.transfer.response.SectionResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

  private final ModelMapper modelMapper;
  private final SectionMapper sectionMapper;
  private final SectionRepository sectionRepository;
  private final GeologicClassRepository geologicClassRepository;

  @Override
  public SectionResponse findById(Long id) {
    return sectionRepository
        .findById(id)
        .map(sectionMapper::toResponse)
        .orElseThrow(EntityNotFoundException::new);
  }

  @Override
  @Transactional
  public void update(Long id, SectionRequest sectionRequest) {
    Section section = sectionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    List<GeologicClass> geologicClasses = section.getGeologicClasses();
    modelMapper.map(sectionRequest, section);
    for (Long geologicalClassesId : sectionRequest.getGeologicalClassesIds()) {
      Optional<GeologicClass> byId = geologicClassRepository.findById(geologicalClassesId);
      byId.ifPresent(geologicClasses::add);
    }
  }

  @Override
  @Transactional
  public void add(SectionRequest sectionRequest) {
    sectionRepository.save(sectionMapper.toEntity(sectionRequest));
  }

  @Override
  public List<SectionResponse> findAll(int page, int size) {
    return sectionRepository.findAll(PageRequest.of(page, size)).stream()
        .map(sectionMapper::toResponse)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    sectionRepository.findById(id).ifPresent(sectionRepository::delete);
  }
}
