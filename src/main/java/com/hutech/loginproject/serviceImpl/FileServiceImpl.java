package com.hutech.loginproject.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.loginproject.service.FileService;
@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadimage(String path, MultipartFile multipartFile) throws IOException {
		String name=multipartFile.getOriginalFilename();
		
		//random name for file
		String randomId=UUID.randomUUID().toString();
		String name1=randomId.concat(name.substring(name.lastIndexOf(".")));
		
		//for path
		String filepath=path+File.separator+name1;
		
		//create a folder if not created
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		Files.copy(multipartFile.getInputStream(), Paths.get(filepath));
		return name;
	}

	@Override
	public InputStream getResources(String path, String filename) throws FileNotFoundException {
		String fullpath=path+File.separator+filename;
		InputStream is=new FileInputStream(fullpath);
		return is;
		
	}

}
