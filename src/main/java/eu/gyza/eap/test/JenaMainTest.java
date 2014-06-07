/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.gyza.eap.test;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import static com.hp.hpl.jena.ontology.OntModelSpec.OWL_MEM;
import static com.hp.hpl.jena.ontology.OntModelSpec.OWL_MEM_MICRO_RULE_INF;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.VCARD;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ydespotopoulos
 */
public class JenaMainTest {

    static String personURI = "http://somewhere/JohnSmith";
    static String fullName = "John Smith";

    public static void main(String args[]) {

        // create an empty Model
        Model model = ModelFactory.createDefaultModel();
        OntModel m = ModelFactory.createOntologyModel();
        // create the resource
        Resource johnSmith = model.createResource(personURI);

        // add the property
        johnSmith.addProperty(VCARD.FN, fullName);

        // create the base model
        String SOURCE = "http://www.eswc2006.org/technologies/ontology";
        String NS = SOURCE + "#";
        String file = "C://personal/2006-09-21.rdf";
        File f = new File(file);
        Reader reader = null;
        try {
            reader = new FileReader(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JenaMainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        OntModel base = ModelFactory.createOntologyModel(OWL_MEM);
        base.read(reader, "RDF/XML");

// create the reasoning model using the base
        OntModel inf = ModelFactory.createOntologyModel(OWL_MEM_MICRO_RULE_INF, base);

// create a dummy paper for this example
        OntClass paper = base.getOntClass(NS + "Paper");
        Individual p1 = base.createIndividual(NS + "paper1", paper);

// list the asserted types
        for (Iterator i = p1.listRDFTypes(false); i.hasNext();) {
            System.out.println(p1.getURI() + " is asserted in class " + i.next());
        }

// list the inferred types
        p1 = inf.getIndividual(NS + "paper1");
        for (Iterator<Resource> i = p1.listRDFTypes(false); i.hasNext();) {
            System.out.println(p1.getURI() + " is inferred to be in class " + i.next());
        }

        OntClass programme = m.createClass(NS + "Programme");
        OntClass orgEvent = m.createClass(NS + "OrganizedEvent");

        ObjectProperty hasProgramme = m.createObjectProperty(NS + "hasProgramme");

     //   hasProgramme.addDomain(orgEvent);
      //  body.addRange(programme);
      ///  body.addLabel("has programme", "en");
    }

}
