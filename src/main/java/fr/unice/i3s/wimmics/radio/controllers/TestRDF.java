/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.i3s.wimmics.radio.controllers;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

/**
 *
 * @author maurice
 */
public class TestRDF {

    private String path = "file:/home/maurice/test.rdf";

    public static void main(String[] args) {
        TestRDF testRDF = new TestRDF();
        testRDF.load();
    }

    public void load() {
        Model model = ModelFactory.createDefaultModel();
        model.read(path);
        model.write(System.out);
    }
}
