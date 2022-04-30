package com.geological.classes.rest.controller;

import com.geological.classes.core.service.GeologicalClassService;
import com.geological.classes.data.transfer.request.GeologicalClassRequest;
import com.geological.classes.data.transfer.response.GeologicalClassResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.geological.classes.core.util.UrlMappings.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(GEOLOGICAL_MAPPING_URL)
public class GeologicalClassController {

  private final GeologicalClassService geologicalClassService;

  @PostMapping(ONLY_SLASH)
  public ResponseEntity<HttpStatus> save(
      @RequestBody GeologicalClassRequest geologicalClassRequest) {
    geologicalClassService.add(geologicalClassRequest);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @PutMapping(BY_ID)
  public ResponseEntity<HttpStatus> update(
      @PathVariable Long id, @RequestBody GeologicalClassRequest geologicalClassRequest) {
    geologicalClassService.update(id, geologicalClassRequest);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @GetMapping(BY_ID)
  public ResponseEntity<GeologicalClassResponse> findById(@PathVariable Long id) {
    return ResponseEntity.ok(geologicalClassService.findById(id));
  }

  @DeleteMapping(BY_ID)
  public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
    geologicalClassService.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @GetMapping(ONLY_SLASH)
  public ResponseEntity<List<GeologicalClassResponse>> findAll(
      @RequestParam int page, @RequestParam int size) {
    return ResponseEntity.ok(geologicalClassService.findAll(page, size));
  }
}
