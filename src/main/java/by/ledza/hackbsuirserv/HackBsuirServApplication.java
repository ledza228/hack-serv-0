package by.ledza.hackbsuirserv;

import by.ledza.hackbsuirserv.socket.DatagramSocketFabric;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.DatagramSocket;
import java.net.SocketException;

@SpringBootApplication
@EnableSwagger2
@EnableMongoRepositories
public class HackBsuirServApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackBsuirServApplication.class, args);
	}


	@Bean
	@Scope("prototype")
	public DatagramSocket datagramSocket() throws SocketException {
		return new DatagramSocket();
	}

	@Bean
	public DatagramSocketFabric datagramSocketFabric(){
		return new DatagramSocketFabric() {
			@Override
			public DatagramSocket getNewSocket() throws SocketException {
				return datagramSocket();
			}
		};
	}
}
