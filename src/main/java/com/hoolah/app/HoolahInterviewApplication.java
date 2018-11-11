package com.hoolah.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.hoolah.app.model.Transaction;
import com.hoolah.app.model.TransactionHistoryList;

@SpringBootApplication
public class HoolahInterviewApplication {
		
	private static final Logger logger = LoggerFactory.getLogger(HoolahInterviewApplication.class);
	
	@Bean
	public TransactionHistoryList transactionHistoryList(@Value("${app.dataFilePath}") String dataFilePath) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		logger.info(dataFilePath);
		try {			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(dataFilePath)));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy hh:mm:ss");
			String line;
			int lineIndex = 0;
			while( (line = bufferedReader.readLine()) != null) {
				if(lineIndex > 0) {
					String[] attr = line.split(",");
					transactions.add(new Transaction(
							attr[0],
							dateFormat.parse(attr[1]),
							Float.parseFloat(attr[2]),
							attr[3],
							attr[4],
							attr.length != 6 ? "" : attr[5]
							));
				}
					
				lineIndex++;
			}
			bufferedReader.close();
			
		} catch (IOException | NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new TransactionHistoryList(transactions);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HoolahInterviewApplication.class, args);
		String[] beanNameList = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNameList);
		for(String beanName : beanNameList) {
			 logger.info("Bean Definition =>"+beanName);
		}
		
	}
}
