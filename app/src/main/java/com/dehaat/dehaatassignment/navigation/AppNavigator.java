package com.dehaat.dehaatassignment.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AppNavigator {

    public static void navigateTo(Activity source, Class<?>target, Bundle bundle)
    {
        Intent intent=new Intent(source,target);
        source.startActivity(intent);
    }



    public static void navigateToFragment(int containerId, Fragment fragment,
                                          FragmentActivity fragmentActivity,Boolean addToBackStack)
    {
        FragmentManager fragmentManager= fragmentActivity.getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
         transaction.add(containerId,fragment,fragment.getClass().getName());
         if(addToBackStack) transaction.addToBackStack("");
         transaction.commit();

    }


}
