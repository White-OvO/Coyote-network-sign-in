package members;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
//@SpringBootApplication

public class SignInMembers {


		public static void main(String[] args) {
			SpringApplication.run(SignInMembers.class, args);

		}

	}

