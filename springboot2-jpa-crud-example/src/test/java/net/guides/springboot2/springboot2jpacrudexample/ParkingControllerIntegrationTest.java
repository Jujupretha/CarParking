package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;


import net.guides.springboot2.springboot2jpacrudexample.model.Parking;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllParkings() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/parkings",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetParkingById() {
		Parking parking = restTemplate.getForObject(getRootUrl() + "/parkings/1", Parking.class);
		System.out.println(parking.getOwnerName());
		assertNotNull(parking);
	}

	@Test
	public void testCreateParking() {
		Parking parking = new Parking();
		parking.setExitTime("06-02-2022,13:15");
		parking.setEntryTime("06-02-2022,13:12");
		parking.setCarNumber("TN45");
		parking.setCarName("MG");
		parking.setEmailId("Juju@gmail.com");
		parking.setOwnerName("Juju");
//		parking.setEmailId("admin@gmail.com");
//		parking.setFirstName("admin");
//		parking.setLastName("admin");

		ResponseEntity<Parking> postResponse = restTemplate.postForEntity(getRootUrl() + "/parkings", parking, Parking.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateParking() {
		int id = 1;
		Parking parking = restTemplate.getForObject(getRootUrl() + "/parkings/" + id, Parking.class);
		parking.setOwnerName("admin1");
		parking.setCarName("polo");
		parking.setCarNumber("TN43");
		parking.setEntryTime("06-02-2022,13:20");
		parking.setExitTime("06-02-2022,13:25");

		restTemplate.put(getRootUrl() + "/parkings/" + id, parking);

		Parking updatedParking = restTemplate.getForObject(getRootUrl() + "/parkings/" + id, Parking.class);
		assertNotNull(updatedParking);
	}

	@Test
	public void testDeleteParking() {
		int id = 2;
		Parking parking = restTemplate.getForObject(getRootUrl() + "/parkings/" + id, Parking.class);
		assertNotNull(parking);

		restTemplate.delete(getRootUrl() + "/parkings/" + id);

		try {
			parking = restTemplate.getForObject(getRootUrl() + "/parkings/" + id, Parking.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
