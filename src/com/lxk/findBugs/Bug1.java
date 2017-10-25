package com.lxk.findBugs;

import com.lxk.model.TimeFormatModel;

import java.util.Date;

/**
 * May expose internal representation by incorporating reference to mutable object
 * This code stores a reference to an externally mutable object into the internal representation of the object. 
 * If instances are accessed by untrusted code, and unchecked changes to the mutable object would compromise
 * security or other important properties, you will need to do something different. Storing a copy of the
 * object is better approach in many situations.
 * <p>
 * @author lxk on 2017/3/23
 */
public class Bug1 {
    public static void main(String[] args) {
        TimeFormatModel timeFormatModel = new TimeFormatModel();
        Date now = new Date();
        timeFormatModel.setDate(now);
        //Calendar calendar = Calendar.getInstance();
        //timeFormatModel.setDate(calendar.getTime());
        System.out.println(timeFormatModel.toString());
        now.setYear(4000);
        //calendar.set(Calendar.YEAR, 4000 + 1900);
        System.out.println(timeFormatModel.toString());
    }
}
