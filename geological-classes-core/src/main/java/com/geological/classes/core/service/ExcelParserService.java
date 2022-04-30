package com.geological.classes.core.service;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelParserService {

  void importSection(MultipartFile file) throws Exception;
}
