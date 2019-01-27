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
public class ArticleReader {
    
    private int id;
    private int article_id;
    private int reader_id;
    private String is_like;
    private String question_answer;
    private String comment;
    private String sub_date;
    
    public int getId(){return this.id;}
    public int getArticle_id(){return this.article_id;}
    public int getReader_id(){return this.reader_id;}
    public String getIs_like(){return this.is_like;}
    public String getQuestion_answer(){return this.question_answer;}
    public String getComment(){return this.comment;}
    public String getSub_date(){return this.sub_date;}
    
    public void setId(int id){this.id = id;}
    public void setArticle_id(int article_id){this.article_id = article_id;}
    public void setReader_id(int reader_id){this.reader_id = reader_id;}
    public void setIs_like(String is_like){this.is_like = is_like;}
    public void setQuestion_answer(String question_answer){this.question_answer = question_answer;}
    public void setComment(String comment){this.comment=comment;}
    public void setSub_date(String sub_date){this.sub_date = sub_date;}
    
    
}
