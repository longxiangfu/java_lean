package com.lxf.web.model;

import java.io.Serializable;

public class TestForupdate implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Boolean status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}