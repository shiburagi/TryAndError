
package com.infideap.tryanderror.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Map;

public class Action implements Serializable
{

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("columns")
    @Expose
    public Map<String, Object> columns;
    @SerializedName("count")
    @Expose
    public long count;
    private final static long serialVersionUID = -3077233244139977356L;

}
