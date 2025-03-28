package com.example.Projet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjetApplicationTests {

	@Test
	void contextLoads() {
		Car car = new Car("AA11BB", "ferrari", 2000);
		assert car.getPlateNumber().equals("AA11BB");
		assert car.getBrand().equals("ferrari");
		assert car.getPrice() == 2000;

		ServiceWeb serviceWeb = new ServiceWeb();

		assert serviceWeb.allCars().size() == 3;

		assert serviceWeb.getCarByPlate("AA11BB").getBody().getBrand().equals("ferrari");
		assert serviceWeb.getCarByPlate("AA11BB").getBody().getPrice() == 2000;
	}

}
