package com.geological.classes.data.transfer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionResponse {

  private String name;
  private List<GeologicalClassResponse> geologicalClassResponses;
}
