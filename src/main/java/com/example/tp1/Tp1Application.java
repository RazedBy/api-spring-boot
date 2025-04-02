package com.example.tp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Tp1Application {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication.run(Tp1Application.class, args);
    try {
      Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
      while (interfaces.hasMoreElements()) {
        NetworkInterface networkInterface = interfaces.nextElement();
        Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
        while (addresses.hasMoreElements()) {
          InetAddress inetAddress = addresses.nextElement();

          // Vérifier si c'est une adresse IPv4 et non une loopback
          if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().indexOf(':') == -1) {
            String serverIp = inetAddress.getHostAddress();
            System.out.println("Adresse IP du serveur : " + serverIp);

            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "http://51.210.251.137/arena/register";

            // Construire le JSON
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("studentName", "Léo LETENEUR test3");
            requestBody.put("baseUrl", "https://8bd9-2a04-cec0-1148-98f0-b02d-8a0f-d3-1fdd.ngrok-free.app:8080");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

            // Envoyer la requête POST
            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, request, String.class);

            System.out.println("Réponse de l'API : " + response.getBody());          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

	}

}
