package com.AndroidLabsMC.lab1.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 07/05/2017.
 */

public class Group {
    public String string;
    public final List<String> children = new ArrayList<String>();

    public Group(String string) {
        this.string = string;
    }
}
