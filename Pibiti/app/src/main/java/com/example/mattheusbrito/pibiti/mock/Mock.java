package com.example.mattheusbrito.pibiti.mock;

import com.example.mattheusbrito.pibiti.release.Release;

import java.util.ArrayList;
import java.util.List;

public class Mock {

    private static List<Release> releaseList = new ArrayList<>();


    public static void add (Release release){
        if (!releaseList.contains(release)){
            releaseList.add(release);
        }

    }

    public static void delete(Release release){
        releaseList.remove(release);
    }


    public static int size (){
        return releaseList.size();
    }

    public static Release get (int index){


        return releaseList.get(index);
    }




}
