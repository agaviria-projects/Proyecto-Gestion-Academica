package gestor.gestor_academico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GestorAcademicoApplication {

	public static void main(String[] args) {
		// Para adaptarse al puerto dinámico de Railway
		String port = System.getenv("PORT");
		if (port != null) {
			System.getProperties().put("server.port", port);
		}
		SpringApplication.run(GestorAcademicoApplication.class, args);
	}
}
