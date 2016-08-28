package com.icon256bliss.android.coursehandler.appModels;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Kall on 8/10/2016.
 */
public class ExpandableListDataPump {

    private static List<PossibleChoice> makerere;
    private static List<PossibleChoice> kyambogo;
    private static List<PossibleChoice> mbarara;
    private static List<PossibleChoice> gulu;
    private static List<PossibleChoice> busitema;

    public static void setMakerere(ArrayList<PossibleChoice> mk) {
        makerere = mk;
    }

    public static List<PossibleChoice> getMakerere() {
        return makerere;
    }

    public static void setKyambogo(ArrayList<PossibleChoice> ky) {
        kyambogo = ky;
    }

    public static List<PossibleChoice> getKyambogo() {
        return kyambogo;
    }

    public static void setMbarara(ArrayList<PossibleChoice> mb) {
        mbarara = mb;
    }

    public static List<PossibleChoice> getMbarara() {
        return mbarara;
    }

    public static void setGulu(ArrayList<PossibleChoice> gu) {
        gulu = gu;
    }

    public static List<PossibleChoice> getGulu() {
        return gulu;
    }

    public static void setBusitema(ArrayList<PossibleChoice> bu) {
        busitema = bu;
    }

    public static List<PossibleChoice> getBusitema() {
        return busitema;
    }

    public static HashMap<String, List<PossibleChoice>> getData() {
        HashMap<String, List<PossibleChoice>> expandableListDetail = new HashMap<>();


        if (getKyambogo().isEmpty() && getMbarara().isEmpty()
                && getGulu().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
        } else if (getMakerere().isEmpty() && getMbarara().isEmpty()
                && getGulu().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
        } else if (getMakerere().isEmpty() && getKyambogo().isEmpty()
                && getGulu().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
        } else if (getMakerere().isEmpty() && getKyambogo().isEmpty()
                && getMbarara().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
        } else if (getMakerere().isEmpty() && getKyambogo().isEmpty()
                && getMbarara().isEmpty() && getGulu().isEmpty()) {
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getMbarara().isEmpty() && getGulu().isEmpty() && getBusitema().isEmpty()) { //makerere
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
        } else if (getKyambogo().isEmpty() && getGulu().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
        } else if (getKyambogo().isEmpty() && getMbarara().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
        } else if (getKyambogo().isEmpty() && getMbarara().isEmpty() && getGulu().isEmpty()) {
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getMbarara().isEmpty() && getGulu().isEmpty() && getBusitema().isEmpty()) { //kyambogo
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
        } else if (getMakerere().isEmpty() && getGulu().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
        } else if (getMakerere().isEmpty() && getMbarara().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
        } else if (getMakerere().isEmpty() && getMbarara().isEmpty() && getGulu().isEmpty()) {
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getKyambogo().isEmpty() && getGulu().isEmpty() && getBusitema().isEmpty()) { //mbarara
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
        } else if (getMakerere().isEmpty() && getGulu().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
        } else if (getMakerere().isEmpty() && getMbarara().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
        } else if (getMakerere().isEmpty() && getKyambogo().isEmpty() && getGulu().isEmpty()) {
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getKyambogo().isEmpty() && getMbarara().isEmpty() && getBusitema().isEmpty()) { //gulu
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
        } else if (getMakerere().isEmpty() && getMbarara().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
        } else if (getMakerere().isEmpty() && getKyambogo().isEmpty() && getBusitema().isEmpty()) {
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
        } else if (getMakerere().isEmpty() && getKyambogo().isEmpty() && getMbarara().isEmpty()) {
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getKyambogo().isEmpty() && getMbarara().isEmpty() && getGulu().isEmpty()) { //busitema
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
        } else if (getMakerere().isEmpty() && getMbarara().isEmpty() && getGulu().isEmpty()) {
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
        } else if (getMakerere().isEmpty() && getKyambogo().isEmpty() && getGulu().isEmpty()) {
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
        } else if (getMakerere().isEmpty() && getKyambogo().isEmpty() && getMbarara().isEmpty()) {
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
        } else if (getGulu().isEmpty() && getBusitema().isEmpty()) { //makerere twos
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
        } else if (getKyambogo().isEmpty() && getGulu().isEmpty()) {
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getKyambogo().isEmpty() && getMbarara().isEmpty()) {
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getGulu().isEmpty() && getBusitema().isEmpty()) { //kyambogo twos
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
        } else if (getMakerere().isEmpty() && getGulu().isEmpty()) {
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getMakerere().isEmpty() && getMbarara().isEmpty()) {
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getGulu().isEmpty() && getBusitema().isEmpty()) { //mbarara twos
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
        } else if (getKyambogo().isEmpty() && getGulu().isEmpty()) {
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getMakerere().isEmpty() && getMbarara().isEmpty()) {
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getMakerere().isEmpty() && getBusitema().isEmpty()) { //gulu twos
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
        } else if (getKyambogo().isEmpty() && getMbarara().isEmpty()) {
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getMakerere().isEmpty() && getKyambogo().isEmpty()) {
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        } else if (getMakerere().isEmpty() && getGulu().isEmpty()) { //busitema twos
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
        } else if (getKyambogo().isEmpty() && getMbarara().isEmpty()) {
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
        } else if (getMakerere().isEmpty() && getKyambogo().isEmpty()) {
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
        }else if (getMakerere().isEmpty()) { //make fours
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
        } else if (getKyambogo().isEmpty()) {
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
        } else if (getMbarara().isEmpty()) {
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
        }else if (getGulu().isEmpty()) {
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
        }else if (getBusitema().isEmpty()) {
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
        }else{ // all
            expandableListDetail.put("MAKERERE UNIVERSITY", getMakerere());
            expandableListDetail.put("KYAMBOGO UNIVERSITY", getKyambogo());
            expandableListDetail.put("MBARARA UNIVERSITY", getMbarara());
            expandableListDetail.put("GULU UNIVERSITY", getGulu());
            expandableListDetail.put("BUSITEMA UNIVERSITY", getBusitema());
        }

        return expandableListDetail;
    }
}
