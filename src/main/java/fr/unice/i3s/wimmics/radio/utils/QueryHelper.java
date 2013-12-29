/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.i3s.wimmics.radio.utils;

/**
 *
 * @author eamosse
 */
public class QueryHelper {

    public static final String findByCategory = "DESCRIBE * \n"
            + " WHERE{\n"
            + "{?x rdf:type rds:Frequency.\n"
            + " ?x rds:responseType ?responseType.\n"
            + " ?x rds:publish ?publish.\n"
            + " ?x rds:listen ?listen.\n"
            + " ?x rds:category ?category.\n"
            + " ?category rds:id ?id."
            + "filter (?id =xsd:long(%s))"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
            + "UNION {?x rdf:type rds:Category}"
            + "UNION {?x rdf:type rds:Response}"
            + "UNION {?x rdf:type rds:Administrator}"
            + "UNION {?x rdf:type rds:ResponseType}"
            + "UNION {?x rdf:type rds:AccessRight}"
            + "}";

    public static final String findByDisease = "DESCRIBE * \n"
            + " WHERE{\n"
            + "{?x rdf:type rds:DiseaseSymptom.\n"
            + " ?x rds:symptom ?symptom.\n"
            + " ?x rds:disease ?disease.\n"
            + " ?disease rds:id ?id.\n"
            + "filter (?id = xsd:long(%s))"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
//            + "UNION {?x rdf:type rds:DiseaseSymptom}"
//            + "UNION {?x rdf:type rds:Symptom}"
//            + "UNION {?x rdf:type rds:Disease}"
            + "}";
    
    public static final String findBriefByDisease = "DESCRIBE * \n"
            + " WHERE{\n"
            + "{?x rdf:type rds:Brief.\n"
            + " ?x rds:disease ?disease.\n"
            + " ?disease rds:id ?id.\n"
            + "filter (?id = xsd:long(%s))"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
//            + "UNION {?x rdf:type rds:DiseaseSymptom}"
//            + "UNION {?x rdf:type rds:Symptom}"
//            + "UNION {?x rdf:type rds:Disease}"
            + "}";
    
    
}