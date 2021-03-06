package com.siepam.Meetupdatastream;

import com.siepam.Meetupdatastream.collecting.MyWebSocketHandler;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
public class MeetupDataStreamApplication {

	private static final String MEETUP_URL = "ws://stream.meetup.com/2/rsvps";

	public static void main(String[] args) {
		SpringApplication.run(MeetupDataStreamApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializeConnection(
			MyWebSocketHandler myWebSocketHandler) {
		return args -> {
			WebSocketClient standardWebSocketClient = new StandardWebSocketClient();

			standardWebSocketClient.doHandshake(
					myWebSocketHandler, MEETUP_URL);
		};
	}
}
