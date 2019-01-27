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
public class ArticleImage {
    private int id;
    private int article_id;
    private String caption;
    private String article_img;
    
    
    public int getId(){return this.id;}
    public int getArticle_id(){return this.article_id;}
    public String getCaption(){return this.caption;}
    public String getArticle_img(){return this.article_img;}
    
    public void setId(int id){this.id = id;}
    public void setArticle_id(int article_id){this.article_id = article_id;}
    public void setCaption(String caption){this.caption = caption;}
    public void setArticle_img(String article_img){this.article_img = article_img;}
    
}
