/*
	Milyn - Copyright (C) 2006 - 2010

	This library is free software; you can redistribute it and/or
	modify it under the terms of the GNU Lesser General Public
	License (version 2.1) as published by the Free Software
	Foundation.

	This library is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

	See the GNU Lesser General Public License for more details:
	http://www.gnu.org/licenses/lgpl.txt
*/
package com.satish.onlinestore.processor;

import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.payload.JavaSource;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;

/**

 */
public class ObjectToXMLProcessor {

    // TODO: Read from properties file
    private String configDir = "src/main/resources/";
    private String configfileName = "smooks-config-xml.xml";
    private String xmlGenerationDir = "src/main/resources/fileMount/";

    /**
     * Run the transform for the request or response.
     * @param inputJavaObject The input Java Object.
     * @return The transformed Java Object XML.
     */
    public void  runSmooksTransform(Object inputJavaObject, String guid) throws IOException, SAXException {
        Smooks smooks = new Smooks(configDir+configfileName);

        try {
            ExecutionContext executionContext = smooks.createExecutionContext();
            StringWriter writer = new StringWriter();

            // Filter the message to the result writer, using the execution context...
            smooks.filterSource(executionContext, new JavaSource(inputJavaObject), new StreamResult(writer));


            stringToDom(writer.toString(),guid);
        } finally {
            smooks.close();
        }
    }

    private void stringToDom(String xmlSource, String fileName)
            throws IOException {
        java.io.FileWriter fw = new java.io.FileWriter(xmlGenerationDir+fileName+".xml");
        fw.write(xmlSource);
        fw.close();
    }



}