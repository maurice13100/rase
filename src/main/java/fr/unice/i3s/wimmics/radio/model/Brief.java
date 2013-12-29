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
@RdfType("Brief")
@SparqlQueries({
    @SparqlAnnotation(name = Constant.findAll,
            value = "DESCRIBE * \n"
            + " WHERE{\n"
            + "{?x rdf:type rds:Brief.\n"
            + "}\n"
            + "UNION {?x rdf:type rdfs:Class}\n"
            + "}"),
    @SparqlAnnotation(name = Constant.count,
            value = "select (count(*) AS ?count) \n"
            + "where\n"
            + "{\n"
            + "?instance rdf:type rds:Brief\n"
            + "}"),
    @SparqlAnnotation(name = Constant.findById,
            value = "DESCRIBE * \n"
            + "WHERE{\n"
            + "{?x rdf:type rds:Brief.\n"
            + "?x rds:id ?id.\n"
            + "FILTER(?id=xsd:long(%s))\n"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
            + "}"),
     @SparqlAnnotation(name = Constant.findByUri,
            value = "DESCRIBE * \n"
            + "WHERE{\n"
            + "{?x rdf:type rds:Brief.\n"
            + "FILTER(?x=<%s>)\n"
            + "}"
            + "UNION {?x rdf:type rdfs:Class}"
            + "}")
})
public class Brief implements Serializable {

    private Geo location; // lieu 
    private Disease disease; // maladie
    private List<Symptom> symptoms; // liste de symptomes
    private String date; // date d'envoi
    private long id; // ID
    private int notation; // indice de surete : 1-5
    private String typeEmetteur;
    private String name;
    private String remarque;

    public Geo getLocation() {
        return location;
    }

    public void setLocation(Geo location) {
        this.location = location;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNotation() {
        return notation;
    }

    public void setNotation(int notation) {
        this.notation = notation;
    }

    public String getTypeEmetteur() {
        return typeEmetteur;
    }

    public void setTypeEmetteur(String typeEmetteur) {
        this.typeEmetteur = typeEmetteur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    @Override
    public String toString() {
        return "Brief{" + "location=" + location + ", disease=" + disease + ", symptoms=" + symptoms + ", date=" + date + ", id=" + id + ", notation=" + notation + ", typeEmetteur=" + typeEmetteur + ", name=" + name + ", remarque=" + remarque + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.location);
        hash = 67 * hash + Objects.hashCode(this.disease);
        hash = 67 * hash + Objects.hashCode(this.symptoms);
        hash = 67 * hash + Objects.hashCode(this.date);
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + this.notation;
        hash = 67 * hash + Objects.hashCode(this.typeEmetteur);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.remarque);
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
        final Brief other = (Brief) obj;
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.disease, other.disease)) {
            return false;
        }
        if (!Objects.equals(this.symptoms, other.symptoms)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.notation != other.notation) {
            return false;
        }
        if (!Objects.equals(this.typeEmetteur, other.typeEmetteur)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.remarque, other.remarque)) {
            return false;
        }
        return true;
    }

    @thewebsemantic.Id
    public String id() {
        return String.valueOf(id);
    }

}
