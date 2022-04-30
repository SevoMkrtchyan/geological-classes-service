package com.geological.classes.data.access.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "section")
public class Section extends BaseEntity {

  private String name;

  @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinTable(
      name = "section_geological_classes",
      joinColumns = {@JoinColumn(name = "section_id")},
      inverseJoinColumns = {@JoinColumn(name = "geological_class_id")})
  private List<GeologicClass> geologicClasses;
}
