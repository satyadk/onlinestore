
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
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.io.StreamUtils;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;


    /**

     */
    public class XMLtoStringProcessor {

        // TODO: Read from properties file
        private String configDir = "src/main/resources/";
        private String configfileName = "smooks-config-xslt.xml";

        public String runSmooksTransform(String xmlString) throws IOException, SAXException, SmooksException {

            // Instantiate Smooks with the config...
            Smooks smooks = new Smooks(configDir + configfileName);

            try {
                // Create an exec context - no profiles....
                ExecutionContext executionContext = smooks.createExecutionContext();
                CharArrayWriter outputWriter = new CharArrayWriter();

                byte[] messageIn = xmlString.getBytes();

                // Filter the input message to the outputWriter, using the execution context...
                smooks.filterSource(executionContext, new StreamSource(new ByteArrayInputStream(messageIn)), new StreamResult(outputWriter));

                return outputWriter.toString();
            } finally {
                smooks.close();
            }
        }

    }


