/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.i3s.wimmics.radio.controllers;

import fr.unice.i3s.wimmics.radio.utils.Constant;
import fr.unice.i3s.wimmics.radio.utils.QueryHelper;
import fr.unice.i3s.wimmics.radio.model.DiseaseSymptom;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author maurice
 */
@Stateless
public class DiseaseSymptomController extends AbstractFacade<DiseaseSymptom> {

    public DiseaseSymptomController() {
        super(DiseaseSymptom.class);
    }

    public List<DiseaseSymptom> findByDisease(Long id) {
        String query = String.format(QueryHelper.findByDisease, id);
        System.out.println("beingg" + query + "end");
        query = String.format(query, Constant.NS, Constant.NS + rdfType, String.valueOf(id));
        System.out.println("being" + query + "end");
        List<DiseaseSymptom> results = executeDescribe(createQuery(query));
        System.out.print("countTESTresults" + results.size());
        return results;
    }

}
