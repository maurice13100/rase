/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.i3s.wimmics.radio.model;

import fr.unice.i3s.wimmics.radio.utils.Constant;
import fr.unice.i3s.wimmics.radio.utils.SparqlAnnotation;
import fr.unice.i3s.wimmics.radio.utils.SparqlQueries;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import thewebsemantic.Namespace;
import thewebsemantic.RdfType;

/**
 *
 * @author maurice
 */
@XmlRootElement
@Namespace(Constant.NS)
@RdfType("DiseaseSymptom")
@SparqlQueries({
    @SparqlAnnotation(name = Constant.findAll,
            value = "DESCRIBE * \n"
            + " WHERE{\n"
            + "{?x rdf:type rds:DiseaseSymptom.\n"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
            + "UNION {?x rdf:type rds:Disease}"
            + "UNION {?x rdf:type rds:Symptom}"
            + "}"),
    @SparqlAnnotation(name = Constant.count,
            value = "select (count(*) AS ?count) \n"
            + "where\n"
            + "{\n"
            + "?instance rdf:type rds:DiseaseSymptom\n"
            + "}"),
    @SparqlAnnotation(name = Constant.findById,
            value = "DESCRIBE * \n"
            + " WHERE{\n"
            + "{?x rdf:type rds:DiseaseSymptom.\n"
            + " ?x rds:id ?id.\n"
            + "filter (?id =xsd:long(%s))"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
            + "UNION {?x rdf:type rds:Disease}"
            + "UNION {?x rdf:type rds:Symptom}"
            + "}"),
    @SparqlAnnotation(name = Constant.findByUri,
            value = "DESCRIBE * \n"
            + " WHERE{\n"
            + "{?x rdf:type rds:DiseaseSymptom.\n"
            + "filter (?x =<%s>)"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
            + "UNION {?x rdf:type rds:Disease}"
            + "UNION {?x rdf:type rds:Symptom}"
            + "}")
})
public class DiseaseSymptom implements Serializable {

    private Symptom symptom;
    private Disease disease;
    private Long id;

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    @thewebsemantic.Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
