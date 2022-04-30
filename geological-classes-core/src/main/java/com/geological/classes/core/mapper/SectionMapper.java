package com.geological.classes.core.mapper;

import com.geological.classes.core.mapper.config.BaseMapper;
import com.geological.classes.data.access.entity.Section;
import com.geological.classes.data.transfer.request.SectionRequest;
import com.geological.classes.data.transfer.response.SectionResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionMapper implements BaseMapper<Section, SectionRequest, SectionResponse> {

  private final ModelMapper mapper;

  @Override
  public Section toEntity(SectionRequest sectionRequest) {
    return mapper.map(sectionRequest, Section.class);
  }

  @Override
  public SectionResponse toResponse(Section section) {
    return mapper.map(section, SectionResponse.class);
  }
}
