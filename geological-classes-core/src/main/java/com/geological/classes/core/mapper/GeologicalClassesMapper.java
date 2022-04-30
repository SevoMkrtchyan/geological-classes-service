package com.geological.classes.core.mapper;

import com.geological.classes.core.mapper.config.BaseMapper;
import com.geological.classes.data.access.entity.GeologicClass;
import com.geological.classes.data.transfer.request.GeologicalClassRequest;
import com.geological.classes.data.transfer.response.GeologicalClassResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeologicalClassesMapper
    implements BaseMapper<GeologicClass, GeologicalClassRequest, GeologicalClassResponse> {

  private final ModelMapper mapper;

  @Override
  public GeologicClass toEntity(GeologicalClassRequest geologicalClassRequest) {
    return mapper.map(geologicalClassRequest, GeologicClass.class);
  }

  @Override
  public GeologicalClassResponse toResponse(GeologicClass geologicClass) {
    return mapper.map(geologicClass, GeologicalClassResponse.class);
  }
}
