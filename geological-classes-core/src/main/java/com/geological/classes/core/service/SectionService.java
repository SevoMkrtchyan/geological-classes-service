package com.geological.classes.core.service;

import com.geological.classes.data.transfer.request.SectionRequest;
import com.geological.classes.data.transfer.response.SectionResponse;

import java.util.List;

public interface SectionService {

  SectionResponse findById(Long id);

  void update(Long id, SectionRequest sectionRequest);

  void add(SectionRequest sectionRequest);

  List<SectionResponse> findAll(int page, int size);

  void deleteById(Long id);
}
