
package com.infideap.tryanderror.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable
{

    @SerializedName("answers")
    @Expose
    public List<Answer> answers = null;
    private final static long serialVersionUID = 8758646593106193969L;

}
