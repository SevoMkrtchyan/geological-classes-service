package com.geological.classes.rest.controller;

import com.geological.classes.core.service.ExcelParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.geological.classes.core.util.UrlMappings.EXCEL_PARSER_MAPPING_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(EXCEL_PARSER_MAPPING_URL)
public class ExcelParserController {

  private final ExcelParserService excelParserService;

  @PostMapping("/import")
  public ResponseEntity<String> importFile(@RequestParam MultipartFile file) throws Exception {
    excelParserService.importSection(file);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
