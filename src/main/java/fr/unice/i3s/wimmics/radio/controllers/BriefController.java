/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.i3s.wimmics.radio.controllers;

import fr.unice.i3s.wimmics.radio.model.*;
import fr.unice.i3s.wimmics.radio.utils.Constant;
import fr.unice.i3s.wimmics.radio.utils.QueryHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author maurice
 */
@Stateless
public class BriefController extends AbstractFacade<Brief> {

    public BriefController() {
        super(Brief.class);
    }

    public List<Brief> findByDateDisease(String from, String to, Long id) {
        String query = String.format(QueryHelper.findBriefByDisease, id);
        query = String.format(query, Constant.NS, Constant.NS + rdfType, "brief", String.valueOf(id));
        List<Brief> results = executeDescribe(createQuery(query));
        List<Brief> newList = new ArrayList<Brief>();
        Calendar c1 = Calendar.getInstance();
        System.out.print(Integer.parseInt(from.substring(4, 8)) + "/" + Integer.parseInt(from.substring(2, 4)) + "/" + Integer.parseInt(from.substring(0, 2)
        ));
        c1.set(Integer.parseInt(from.substring(4, 8)), Integer.parseInt(from.substring(2, 4)), Integer.parseInt(from.substring(0, 2)
        ));
        Calendar c2 = Calendar.getInstance();
        c2.set(Integer.parseInt(to.substring(4, 8)), Integer.parseInt(to.substring(2, 4)), Integer.parseInt(to.substring(0, 2)
        ));
        Calendar date_brief = Calendar.getInstance();

        for (Brief brief : results) {
            String[] date = brief.getDate().split("/");
            date_brief.set(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
            if (c1.compareTo(date_brief) >= 0 && c2.compareTo(date_brief) <= 0) {

                newList.add(brief);
            }

        }
        return newList;
    }
}
