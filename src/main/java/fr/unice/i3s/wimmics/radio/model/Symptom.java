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
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
import thewebsemantic.Namespace;
import thewebsemantic.RdfType;

/**
 *
 * @author maurice
 */
@XmlRootElement
@Namespace(Constant.NS)
@RdfType("Symptom")
@SparqlQueries({
    @SparqlAnnotation(name = Constant.findAll,
            value = "DESCRIBE * \n"
            + " WHERE{\n"
            + "{?x rdf:type rds:Symptom.\n"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
            + "}"),
    @SparqlAnnotation(name = Constant.count,
            value = "select (count(*) AS ?count) \n"
            + "where\n"
            + "{\n"
            + "?instance rdf:type rds:Symptom\n"
            + "}"),
    @SparqlAnnotation(name = Constant.findById,
            value = "DESCRIBE * \n"
            + " WHERE{\n"
            + "{?x rdf:type rds:Symptom.\n"
            + " ?x rds:id ?id.\n"
            + "filter (?id =xsd:long(%s))"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
            + "}"),
    @SparqlAnnotation(name = Constant.findByUri,
            value = "DESCRIBE * \n"
            + " WHERE{\n"
            + "{?x rdf:type rds:Symptom.\n"
            + "filter (?x =<%s>)"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
            + "}")
})
public class Symptom implements Serializable {

    private Long id;
    private String name;
    private String description;
    private List<DiseaseSymptom> diseaseSymptom; // un symptome peut avoir plusieurs maladies

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DiseaseSymptom> getDiseaseSymptom() {
        return diseaseSymptom;
    }

    public void setDiseaseSymptom(List<DiseaseSymptom> diseaseSymptoms) {
        this.diseaseSymptom = diseaseSymptoms;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.diseaseSymptom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Symptom other = (Symptom) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.diseaseSymptom, other.diseaseSymptom)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Symptom{" + "id=" + id + ", name=" + name + ", description=" + description + ", listDiseaseSymptoms=" + diseaseSymptom + '}';
    }

    @thewebsemantic.Id
    public String id() {
        return String.valueOf(id);
    }

}
