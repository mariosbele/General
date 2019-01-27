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
public class Article {
    
    private int id;
    private int creator_id;
    private String sub_date;
    private String pub_date;
    private String category;
    private String title;
    private String article;
    private String question;
    private Boolean is_saved;
    
    public int getId(){return this.id;}
    public int getCreator_id(){return this.creator_id;}
    public String getSub_date(){return this.sub_date;}
    public String getPub_date(){return this.pub_date;}
    public String getCategory(){return this.category;}
    public String getTitle(){return this.title;}
    public String getArticle(){return this.article;}
    public String getQuestion(){return this.question;}
    public Boolean getIs_saved(){return this.is_saved;}
    
    public void setId(int id){this.id = id;}
    public void setCreator_id(int creator_id){this.creator_id = creator_id;}
    public void setSub_date(String sub_date){this.sub_date = sub_date;}
    public void setPub_date(String pub_date){this.pub_date = pub_date;}
    public void setCategory(String category){this.category = category;}
    public void setTitle(String title){this.title = title;}
    public void setArticle(String article){this.article = article;}
    public void setQuestion(String question){this.question = question;}
    public void setIs_saved(Boolean is_saved){this.is_saved = is_saved;}
}
