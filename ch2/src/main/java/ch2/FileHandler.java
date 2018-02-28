package ch2;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.web.multipart.MultipartFile;

public class FileHandler {

		
	private MultipartFile image;

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile Image) {
		this.image = Image;
	}
	  
	  
}