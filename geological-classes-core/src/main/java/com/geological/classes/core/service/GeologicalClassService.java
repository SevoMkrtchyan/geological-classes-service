package com.geological.classes.core.service;

import com.geological.classes.data.transfer.request.GeologicalClassRequest;
import com.geological.classes.data.transfer.response.GeologicalClassResponse;

import java.util.List;

public interface GeologicalClassService {

  GeologicalClassResponse findById(Long id);

  void update(Long id, GeologicalClassRequest geologicalClassRequest);

  void add(GeologicalClassRequest geologicalClassRequest);

  List<GeologicalClassResponse> findAll(int page, int size);

  void deleteById(Long id);
}
