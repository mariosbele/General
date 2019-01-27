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
public class ArticleCards {
    
    private int id;
    private String category;
    private String title;
    private String article_img;
    private String username;
    private String pub_date;
    
    
    public int getId(){return this.id;}
    public String getCategory(){return this.category;}
    public String getTitle(){return this.title;}
    public String getArticle_img(){return this.article_img;}
    public String getUsername(){return this.username;}
    public String getPub_date(){return this.pub_date;}
    
    public void setId(int id){this.id = id;}
    public void setCategory(String category){this.category = category;}
    public void setTitle(String title){this.title = title;}
    public void setArticle_img(String article_img){this.article_img = article_img;}
    public void setUsername(String username){this.username = username;}
    public void setPub_date(String pub_date){this.pub_date = pub_date;}
    
}
