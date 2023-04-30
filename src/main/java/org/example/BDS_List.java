package org.example;

import java.util.ArrayList;
import java.util.List;

public class BDS_List {
    private static BDS_List instance;
    String server_key;
    private List<From> fromList;

    static BDS_List getInstance() {
        if (instance == null) {
            instance = new BDS_List();
        }
        return instance;
    }
    private BDS_List() {
        fromList = new ArrayList<>();
    }
    public List<From> getFromList() {
        return fromList;
    }

    public void setFromList(List<From> fromList) {
        this.fromList = fromList;
    }

    public String getServer_key() {
        return server_key;
    }

    public void setServer_key(String server_key) {
        this.server_key = server_key;
    }
}
