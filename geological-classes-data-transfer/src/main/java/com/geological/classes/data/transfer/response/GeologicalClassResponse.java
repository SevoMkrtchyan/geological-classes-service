package com.geological.classes.data.transfer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeologicalClassResponse {

  private String name;
  private String code;
}
