package com.example.firstapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstapp.models.NumberClass;
import com.example.firstapp.repository.NumberRepository;

public class NumberViewModel extends ViewModel {

    private  MutableLiveData<NumberClass> mNumber;
    private NumberRepository mRepo;

    public void init()
    {
        if(mNumber != null)
        {
            return;
        }
        mRepo = NumberRepository.getInstance();
        mNumber = mRepo.getNumber();
    }

    public LiveData<NumberClass> getNumber()
    {
        return mNumber;
    }

    //This method would usually have async to check repository
    public void changeValueBy(int i)
    {
        NumberClass newNum = new NumberClass();
        int curr = mNumber.getValue().GetNumber();
        newNum.SetNumber(curr + i);
        mNumber.postValue(newNum);
    }
}
