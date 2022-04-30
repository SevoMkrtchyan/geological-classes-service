package com.geological.classes.core.service.impl;

import com.geological.classes.core.exception.EntityNotFoundException;
import com.geological.classes.core.mapper.GeologicalClassesMapper;
import com.geological.classes.core.service.GeologicalClassService;
import com.geological.classes.data.access.entity.GeologicClass;
import com.geological.classes.data.access.repository.GeologicClassRepository;
import com.geological.classes.data.transfer.request.GeologicalClassRequest;
import com.geological.classes.data.transfer.response.GeologicalClassResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeologicalClassServiceImpl implements GeologicalClassService {

  private final ModelMapper modelMapper;
  private final GeologicalClassesMapper geologicalClassesMapper;
  private final GeologicClassRepository geologicClassRepository;

  @Override
  public GeologicalClassResponse findById(Long id) {
    return geologicClassRepository
        .findById(id)
        .map(geologicalClassesMapper::toResponse)
        .orElseThrow(EntityNotFoundException::new);
  }

  @Override
  @Transactional
  public void update(Long id, GeologicalClassRequest geologicalClassRequest) {
    GeologicClass geologicClass =
        geologicClassRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    modelMapper.map(geologicalClassRequest, geologicClass);
  }

  @Override
  @Transactional
  public void add(GeologicalClassRequest geologicalClassRequest) {
    if (geologicClassRepository.findByCode(geologicalClassRequest.getCode()).isEmpty()
        && geologicClassRepository.findByName(geologicalClassRequest.getName()).isEmpty()) {
      geologicClassRepository.save(geologicalClassesMapper.toEntity(geologicalClassRequest));
    }
  }

  @Override
  public List<GeologicalClassResponse> findAll(int page, int size) {
    return geologicClassRepository.findAll(PageRequest.of(page, size)).stream()
        .map(geologicalClassesMapper::toResponse)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    geologicClassRepository.findById(id).ifPresent(geologicClassRepository::delete);
  }
}
