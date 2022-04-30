package com.geological.classes.data.transfer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeologicalClassRequest {

  private String name;
  private String code;
}
