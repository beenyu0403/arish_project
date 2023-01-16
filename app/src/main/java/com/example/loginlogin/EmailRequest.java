package com.example.loginlogin;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class EmailRequest extends StringRequest {

    final static private String URL = "http://hwgjh01.ivyro.net/Email.php";
    private Map<String, String> map;

    public EmailRequest(String userEmail, Response.Listener<String>listener){
        super(Request.Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userEmail", userEmail);

    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
