package com.geological.classes.data.access.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @CreationTimestamp private LocalDateTime createdDateTime;
  @UpdateTimestamp private LocalDateTime updatedDateTime;
  @Version private int version;
}
