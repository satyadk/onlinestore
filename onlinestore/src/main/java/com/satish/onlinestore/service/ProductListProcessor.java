package com.satish.onlinestore.service;

import com.satish.onlinestore.domain.Product;
import com.satish.onlinestore.processor.ObjectToXMLProcessor;
import com.satish.onlinestore.processor.XMLtoStringProcessor;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Implement the function productListToString that does conversion of provided list of products to text representation
 * of this list in this way.
 * - Result string is \n - separated string. E.g.
 *
 *   product 1 details
 *   product 2 details
 *   ...
 *   product 3 details
 *
 * - Each line contains details of one product
 * - Product description line should look like this:
 *   Product name (product GUID), product attribute 1 name:product attribute1 value; ... product attribute n name:product attributen value;
 *   For example. List contains BackPack definition:
 *   BackPack {
 *       guid: 111-222-333
 *       name: Cool Backpack
 *       maxContentWeight: 15
 *       color: "Black"
 *       capacity: 20
 *   }
 *   This becka pakc description string should look like this:
 *   Cool Backpack (111-222-333), maxContentWeight: 15, color: "Black", capacity: 20
 *
 * Keep in mind these requirements:
 * - String reorientation can be modified in future.
 * - There is a possibility to support multiply ways to convert list of products to string. E.g. it it is possible that in future
 *   you will need to implement support of different formats of outpust string (e.g. json instead of \n-separated string).
 * The basic idea is to make your current implementation flexible and modifiable in future.
 *
 * You can use any build system to build the sources (maven, gralde, ant).
 * You can use any 3rd party libs in your application.
 * Any java version (>=8).
 * Code must be tested (framework is up to you).
 * 
 * PLEASE KEEP IN MIND THAT IT CAN BE THOUSANDS OF PRODUCT IMPLEMENTATIONS, NOT JUST 2!!! INSTANCE OF SOLUTION IS BAD AND IS NOT GOING TO 
 * WORK IN A REAL WORLD!
 * 
 * Product classes (base class and implementations) can be changed to resolve the task, Any new methods, properties or anything else can be added there.
 * 
 * If you are familiar with Git, please do work in a separate branch and create a pull request with your changes.
 */
public class ProductListProcessor {

    /**
     * Make String representation of providd product list.
     * @param products list of the products that needs to be converted to String
     * @return String representation of the provided list.
     */
    public String productListToString(List<Product> products) throws IOException, SAXException {

        XMLtoStringProcessor xmLtoStringProcessor = new XMLtoStringProcessor();
        ObjectToXMLProcessor objectToXMLProcessor = new ObjectToXMLProcessor();

        for (Product product : products) {

            String guid = product.getGuid().toString();

            // Convert Object to XML
            String xmlString = objectToXMLProcessor.runSmooksTransform(product);

            // Convert XML to String
            String productString = xmLtoStringProcessor.runSmooksTransform(xmlString);
            System.out.println(productString);
        }

        return null;
    }
}
