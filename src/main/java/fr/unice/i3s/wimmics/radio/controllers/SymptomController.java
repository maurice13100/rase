/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.i3s.wimmics.radio.controllers;

import fr.unice.i3s.wimmics.radio.model.Symptom;
import fr.unice.i3s.wimmics.radio.utils.Constant;
import fr.unice.i3s.wimmics.radio.utils.QueryHelper;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author maurice
 */
@Stateless
public class SymptomController extends AbstractFacade<Symptom> {

    public SymptomController() {
        super(Symptom.class);
    }

    public List<Symptom> findByDisease(String s) {
        String query = String.format(QueryHelper.findByDisease, s);
        query = String.format(query, Constant.NS, Constant.NS + rdfType, "symptom", s);
        List<Symptom> results = executeDescribe(createQuery(query));
        return results;
    }

}
