package com.geological.classes.data.access.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "geological_class")
public class GeologicClass extends BaseEntity {

  private String name;
  private String code;
}
