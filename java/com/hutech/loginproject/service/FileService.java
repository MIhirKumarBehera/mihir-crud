package com.hutech.loginproject.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
String uploadimage(String path,MultipartFile multipartFile) throws IOException;
InputStream getResources(String path,String filename) throws FileNotFoundException;

}
