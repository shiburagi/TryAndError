
package com.infideap.tryanderror.entity;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata implements Serializable
{

    @SerializedName("count")
    @Expose
    public long count;
    private final static long serialVersionUID = -6384656889306462156L;

}
