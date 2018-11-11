package com.hoolah.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.catalina.WebResource;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HoolahInterviewApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void contextLoads() {
        Assert.assertNotNull(applicationContext.getBean("transactionHistoryList"));
	}

	@Test
	public void analyzeTransaction() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://localhost:8080/transaction/analyse?fromDate=20/08/2018%2012:45:33&toDate=20/08/2018%2014:07:10&merchant=MacLaren");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		JsonNode actualObj = null;
		while ((line = rd.readLine()) != null) {
		    ObjectMapper mapper = new ObjectMapper();
		    actualObj = mapper.readTree(line);
		}
		Assert.assertEquals(actualObj.get("numberOfTransactions").toString(),String.valueOf(2));
		Assert.assertEquals(actualObj.get("averageTransactionValue").toString(),String.valueOf(52.25));
	}
}
