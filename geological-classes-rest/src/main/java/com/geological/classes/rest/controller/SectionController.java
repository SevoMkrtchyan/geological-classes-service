package com.geological.classes.rest.controller;

import com.geological.classes.core.service.SectionService;
import com.geological.classes.data.transfer.request.SectionRequest;
import com.geological.classes.data.transfer.response.SectionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.geological.classes.core.util.UrlMappings.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(SECTIONS_MAPPING_URL)
public class SectionController {

  private final SectionService sectionService;

  @PostMapping(ONLY_SLASH)
  public ResponseEntity<HttpStatus> save(@RequestBody SectionRequest sectionRequest) {
    sectionService.add(sectionRequest);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @PutMapping(BY_ID)
  public ResponseEntity<HttpStatus> update(
      @PathVariable Long id, @RequestBody SectionRequest sectionRequest) {
    sectionService.update(id, sectionRequest);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @GetMapping(BY_ID)
  public ResponseEntity<SectionResponse> findById(@PathVariable Long id) {
    return ResponseEntity.ok(sectionService.findById(id));
  }

  @DeleteMapping(BY_ID)
  public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
    sectionService.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @GetMapping(ONLY_SLASH)
  public ResponseEntity<List<SectionResponse>> findAll(
      @RequestParam int page, @RequestParam int size) {
    return ResponseEntity.ok(sectionService.findAll(page, size));
  }
}
