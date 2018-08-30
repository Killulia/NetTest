package com.bksx.nettest.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "CDG_REGIONCODE",createInDb = false)
public class RegionCode {
    @Property(nameInDb = "CD_ID")
    @Id (autoincrement = true)
    private long id;
    @Property(nameInDb = "CD_NAME")
    private String name;
    @Generated(hash = 1036299484)
    public RegionCode(long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 617419664)
    public RegionCode() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

  
}
