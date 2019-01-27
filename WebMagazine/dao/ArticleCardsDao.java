package com.cbfteam.dao;  
import com.cbfteam.daoInterface.ArticleCardsDaoInterface;
import com.cbfteam.beans.ArticleCards;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;    
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;   


  
public class ArticleCardsDao implements ArticleCardsDaoInterface {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  



    @Override  
    public List<ArticleCards> getAllPublishedCards(){  
    return template.query("select * from teamproject.allPublished ORDER BY pub_date DESC",new RowMapper<ArticleCards>(){  
        public ArticleCards mapRow(ResultSet rs, int row) throws SQLException {  
            ArticleCards e=new ArticleCards();  
            e.setId(rs.getInt(1));
            e.setCategory(rs.getString(2));
            e.setTitle(rs.getString(3));
            e.setArticle_img(rs.getString(4));
            e.setUsername(rs.getString(5));
            e.setPub_date(rs.getString(6));
            
            return e;  
            }  
        });  
    }

    @Override  
    public List<ArticleCards> getAllPublishedCardsByCategory(String category){  
    return template.query("select * from teamproject.allPublished WHERE category='"+category+"' ORDER BY pub_date DESC",new RowMapper<ArticleCards>(){  
        public ArticleCards mapRow(ResultSet rs, int row) throws SQLException {  
            ArticleCards e=new ArticleCards();  
            e.setId(rs.getInt(1));
            e.setCategory(rs.getString(2));
            e.setTitle(rs.getString(3));
            e.setArticle_img(rs.getString(4));
            e.setUsername(rs.getString(5));
            e.setPub_date(rs.getString(6));
            
            return e;  
            }  
        });  
    }



}  