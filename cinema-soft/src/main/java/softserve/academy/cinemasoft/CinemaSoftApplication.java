package softserve.academy.cinemasoft;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CinemaSoftApplication {

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper mapper = new ModelMapper();
		return mapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(CinemaSoftApplication.class, args);
	}
}
