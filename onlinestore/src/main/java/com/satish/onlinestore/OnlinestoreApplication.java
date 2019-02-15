package com.satish.onlinestore;

import com.satish.onlinestore.domain.BackPack;
import com.satish.onlinestore.domain.Product;
import com.satish.onlinestore.domain.SmartPhone;
import com.satish.onlinestore.service.ProductListProcessor;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OnlinestoreApplication {

	public static void main(String[] args) {

		List<Product> productList = new ArrayList<Product>();
		productList.add(new BackPack("1234","Backpack1"));
		productList.add(new BackPack("1235","Backpack2"));
		productList.add(new BackPack("1236","Backpack3"));
		productList.add(new SmartPhone("1237","SmartPhone1"));
		productList.add(new SmartPhone("1238","SmartPhone2"));

		ProductListProcessor  productListProcessor = new ProductListProcessor();
		try {
			productListProcessor.productListToString(productList);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}

}

