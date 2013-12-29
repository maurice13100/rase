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
@RdfType("Disease")
@SparqlQueries({
    @SparqlAnnotation(name = Constant.findAll,
            value = "DESCRIBE * \n"
            + " WHERE{\n"
            + "{?x rdf:type rds:Disease.\n"
            + "}\n"
            + "UNION {?x rdf:type rdfs:Class}\n"
            + "UNION {?x rdf:type rdfs:Disease}\n"
            + "}"),
    @SparqlAnnotation(name = Constant.count,
            value = "select (count(*) AS ?count) \n"
            + "where\n"
            + "{\n"
            + "?instance rdf:type rds:Disease\n"
            + "}"),
    @SparqlAnnotation(name = Constant.findById,
            value = "DESCRIBE * \n"
            + "WHERE{\n"
            + "{?x rdf:type rds:Disease.\n"
            + "?x rds:id ?id.\n"
            + "FILTER(?id=xsd:long(%s))\n"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
            + "}"),
    @SparqlAnnotation(name = Constant.findByUri,
            value = "DESCRIBE * \n"
            + "WHERE{\n"
            + "{?x rdf:type rds:Disease.\n"
            + "FILTER(?x=<%s>)\n"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
            + "}")
})
public class Disease implements Serializable {

    private List<DiseaseSymptom> diseaseSymptom; // une maladie peut avoir plusieurs symptomes
    private Long id;
    private String name;
    private String description;

    public List<DiseaseSymptom> getDiseaseSymptom() {
        return diseaseSymptom;
    }

    public void setDiseaseSymptom(List<DiseaseSymptom> diseaseSymptom) {
        this.diseaseSymptom = diseaseSymptom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.diseaseSymptom);
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public String toString() {
        return "Disease{" + "diseaseSymptom=" + diseaseSymptom + ", id=" + id + ", name=" + name + ", description=" + description + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disease other = (Disease) obj;
        if (!Objects.equals(this.diseaseSymptom, other.diseaseSymptom)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
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

    @thewebsemantic.Id
    public String id() {
        return String.valueOf(id);
    }

}
