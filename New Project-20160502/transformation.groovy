package nl.rubix.ci

import javax.xml.transform.TransformerFactory
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

this.'xslAppConfigFile' = args[0]
this.'exportedConfigFile' = args[1]
this.'deploymentConfigFile' = args[2]
//this.'version' = args[3]

// Load xslt
//def xslt= new File("c:\\Tibco_Data\\src\\bw\\ApplyENVSettings.xsl").getText()
def xslt= new File(this.'xslAppConfigFile').getText()

// Create transformer
def transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(new StringReader(xslt)))

// Load xml
def xml= new File(this.'exportedConfigFile').getText()

// Set output file
def xmlTransformed = new FileOutputStream(this.'deploymentConfigFile')

// Perform transformation
transformer.transform(new StreamSource(new StringReader(xml)), new StreamResult(xmlTransformed))	
