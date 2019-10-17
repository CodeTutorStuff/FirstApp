package com.example.firstapp.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.firstapp.models.NumberClass;

public class NumberRepository {

    private static NumberRepository instance;
    private NumberClass numberData = new NumberClass();
    private MutableLiveData<Boolean> isUpdated;

    public static NumberRepository getInstance()
    {
        if(instance == null)
        {
            instance = new NumberRepository();
        }
        return instance;
    }

    //Method where database requests are usually made
    public MutableLiveData<NumberClass> getNumber()
    {
        setNumber();

        MutableLiveData<NumberClass> data = new MutableLiveData<>();
        data.setValue(numberData);
        return data;
    }

    private void setNumber()
    {
        //getting some value
        numberData.SetNumber(5);
    }

}
