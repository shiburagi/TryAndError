
package com.infideap.tryanderror.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Answer implements Serializable
{

    @SerializedName("data")
    @Expose
    public List<Map<String, Object>> data = null;
    @SerializedName("metadata")
    @Expose
    public Metadata metadata;
    @SerializedName("actions")
    @Expose
    public List<Action> actions = null;
    private final static long serialVersionUID = -9073884358663996908L;

}
