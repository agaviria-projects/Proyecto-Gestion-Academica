package gestor.gestor_academico;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GestorAcademicoApplication {

	public static void main(String[] args) {
		int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
		new SpringApplicationBuilder(GestorAcademicoApplication.class)
				.properties("server.port=" + port)
				.run(args);
	}
}
