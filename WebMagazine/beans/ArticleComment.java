/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbfteam.beans;

/**
 *
 * @author user
 */
public class ArticleComment {
    
    private String username;
    private String comment;
    private String sub_date;

    
    
    public String getUsername(){return this.username;}
    public String getComment(){return this.comment;}
    public String getSub_date(){return this.sub_date;}
    

    public void setUsername(String username){this.username = username;}
    public void setComment(String comment){this.comment = comment;}
    public void setSub_date(String sub_date){this.sub_date = sub_date;}
    
}
