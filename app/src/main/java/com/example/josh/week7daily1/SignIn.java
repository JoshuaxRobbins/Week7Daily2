package com.example.josh.week7daily1;

import android.accounts.AccountManager;
import android.content.SharedPreferences;
import android.util.Log;

import java.security.InvalidKeyException;
import java.security.KeyPair;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class SignIn {
    String email;
    String password;
    SignIn.Callback callback;
    SharedPreferences sharedPreferences;
    public static final String TAG = "_TAG";
    CipherManager cipherManager;
    KeyPair keyPair;

    public SignIn(String email, String password, SignIn.Callback callback, SharedPreferences sharedPreferences, CipherManager cipherManager,KeyPair keyPair) {
        Log.d(TAG, "SignUp: " + password);
        this.email = email;
        this.password = password;
        this.callback = callback;
        this.sharedPreferences = sharedPreferences;
        this.cipherManager = cipherManager;
        this.keyPair = keyPair;
    }

    public void onSignIn() throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        String decPass = cipherManager.decrypt(sharedPreferences.getString(email,""), keyPair.getPublic());
        if(!sharedPreferences.contains(email)){
            callback.onFailedSignIn("Email not registered.");
        }
        else if(password.equals(decPass)){
            callback.onSignedIn();
        }
        else {
            Log.d(TAG, "onSignIn: " + sharedPreferences.getString(email,""));
            callback.onFailedSignIn("Incorrect Password.");
        }

    }




    public interface Callback{
        void onSignedIn();
        void onFailedSignIn(String error);
    }
}
