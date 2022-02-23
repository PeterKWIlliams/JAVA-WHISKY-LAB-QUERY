package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {
	@Autowired
	WhiskyRepository whiskyRepository;
	@Autowired
	DistilleryRepository distilleryRepository;
	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskeyByYear(){
		List<Whisky> foundWhiskys = whiskyRepository.findWhiskyByYear(2014);
		assertEquals(4,foundWhiskys.size());
	}

	@Test
	public void findDistilleryByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleryByRegion("Highland");
		assertEquals(3,foundDistilleries.size());
	}

	@Test
	public void findWhiskyByDistilleryAndAge(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryNameAndAge("Glendronach",12);
		assertEquals(1,foundWhiskies.size());
	}

	@Test
	public void findWhiskeyByRegion(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryRegionIgnoreCase("island");
		assertEquals(6,foundWhiskies.size());
	}

	@Test
	public void findDistilleriesByWhiskysAge(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleryByWhiskiesAge(12);
		assertEquals(6,foundDistilleries.size());
	}

}
