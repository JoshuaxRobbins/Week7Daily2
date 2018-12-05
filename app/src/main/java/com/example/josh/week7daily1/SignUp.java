package com.example.josh.week7daily1;

import android.content.SharedPreferences;
import android.util.Log;

import java.security.InvalidKeyException;
import java.security.KeyPair;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;


public class SignUp {

    String email;
    String password;
    Callback callback;
    SharedPreferences sharedPreferences;
    CipherManager cipherManager;
    KeyPair keyPair;
    public static final String TAG = "_TAG";
    public SignUp(String email, String password, Callback callback, SharedPreferences sharedPreferences, CipherManager cipherManager,KeyPair keyPair) {
        Log.d(TAG, "SignUp: " + password);
        this.email = email;
        this.password = password;
        this.callback = callback;
        this.sharedPreferences = sharedPreferences;
        this.cipherManager = cipherManager;
        this.keyPair = keyPair;
    }

    public void onSignup() throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        if(sharedPreferences.contains(email)){
            callback.onFailedSignUp("Email already in use.");
        }
        else if(!PatternMatcher.testPassword(password)){
            String newPass = cipherManager.encrypt(password, keyPair.getPrivate());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(email,"");
            editor.apply();
            callback.onSignedUp();
        }
        else{
            callback.onFailedSignUp("Password needs Uppercase,Lowercase,Number, and Special Character");
        }



    }

    public interface Callback{
        void onSignedUp();
        void onFailedSignUp(String error);
    }




}
