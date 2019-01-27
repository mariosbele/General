package com.cbfteam.dao;  
import com.cbfteam.daoInterface.ArticleImageDaoInterface;
import com.cbfteam.beans.Article;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;   
import com.cbfteam.beans.ArticleImage;
import org.springframework.dao.EmptyResultDataAccessException;

  
public class ArticleImageDao implements ArticleImageDaoInterface {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
    @Override  
    public int saveArticleImage(Article ar, ArticleImage im){  
    String sql="insert into teamproject.article_images(article_id,caption,article_img) "
            + "values('"+ar.getId()+"','"+im.getCaption().replace("'", "\\'")+"','"+im.getArticle_img()+"')";  
    return template.update(sql);  
}

    @Override  
    public int saveArticleImageDEFAULT(Article ar, String caption, String img){  
    String sql="insert into teamproject.article_images(article_id,caption,article_img) "
            + "values('"+ar.getId()+"','"+caption.replace("'", "\\'")+"','"+img+"')";  
    return template.update(sql);  
}
    @Override
    public String defaultImageByCategory(Article ar, String img){
    if(ar.getCategory().equals("SCIENCE")){return "https://6dollarshirts.com/image/cache//data/designs/001top100/science/science-t-shirt-heathergreen-tn-300x300.jpg";}
    else if(ar.getCategory().equals("ENVIRONMENT")){return "http://onecentatatime.com/wp-content/uploads/2012/01/Every-day-save-environment-300x300.jpg";}
    else if(ar.getCategory().equals("ART")){return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThVcn6Cus0Y4j6B2LvI-V7S9F83u4La_apWQ-jTjU0cfqliVtorA";}
    else if(ar.getCategory().equals("TECHNOLOGY")){return "https://sloanreview.mit.edu/content/uploads/2018/08/MAG-Dutra-Blockchain-Online-Media-Entertainment-Sports-Innovation-Technology-Cybersecurity-1200-300x300.jpg";}
    else {return "https://mobileart.co.nz/wp-content/uploads/2017/10/Always-Working-W-300x300.jpg";}
}

    @Override  
    public int deleteArticleImage(int id){  
    String sql="delete from teamproject.article_images where id="+id+"";  
    return template.update(sql);  
}  
    @Override  
    public ArticleImage getArticleImageById(int id){  
    String sql="select * from teamproject.article_images where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<ArticleImage>(ArticleImage.class));  
}

    @Override  
    public List<String> getUnPublishedArticlesImg(){  
    return template.query("SELECT distinct article_id, article_img  FROM teamproject.article_images "
            + "INNER JOIN teamproject.article on article_images.article_id = article.id  "
            + "WHERE article.pub_date IS NOT NULL   ORDER BY article.pub_date DESC",new RowMapper<String>(){  
        public String mapRow(ResultSet rs, int row) throws SQLException {  
            String e = null;  
           
            e=(rs.getString(3));  
           
            return e;  
            }  
        });  
    }

    @Override
    public Integer getZEROimages(int article_id){  
        String sql="select count(*) from teamproject.article LEFT JOIN teamproject.article_images on article_images.article_id = article.id " +
            "where article.is_saved=false and article.pub_date IS NULL and article_images.id IS NULL AND article.id = ?";
        try{
        return template.queryForObject(sql, new Object[] {article_id}, Integer.class);    
    }catch(EmptyResultDataAccessException e)
        {return null;}  
}





    @Override  
    public List<String> getPublishedImagesByCategory(String category){  
    return template.query("SELECT distinct article_id, article_img FROM article_images INNER JOIN teamproject.article on article_images.article_id = article.id  "
            + "WHERE article.pub_date IS NOT NULL AND article.category = '"+category+"' ORDER BY article.pub_date DESC",new RowMapper<String>(){  
        public String mapRow(ResultSet rs, int row) throws SQLException {  
            String e="";  
            e=(rs.getString(2));  
            
            return e;  
        }  
    });  
}









    
    @Override  
    public List<ArticleImage> getImagesByPublishedArticleID(int id){  
    return template.query("select teamproject.article_images.* from teamproject.article_images INNER JOIN "
            + "teamproject.article on article_images.article_id = article.id  where (article.pub_date IS NOT null AND article.id="+id+") ORDER BY article.pub_date",new RowMapper<ArticleImage>(){  
        
            public ArticleImage mapRow(ResultSet rs, int row) throws SQLException {  
            ArticleImage e=new ArticleImage();  
            e.setId(rs.getInt(1));  
            e.setArticle_id(rs.getInt(2));  
            e.setCaption(rs.getString(3));  
            e.setArticle_img(rs.getString(4));  
            
            return e;  
            }  
        });  
    }
    @Override  
    public List<ArticleImage> getSAVEDArticleImagesByArticleID(int artclID){  
    return template.query("select teamproject.article_images.* from teamproject.article_images INNER JOIN "
            + "teamproject.article on article_images.article_id = article.id where (article.is_saved=true AND article.id="+artclID+ ") ORDER BY article_images.id DESC",new RowMapper<ArticleImage>(){  
        
            public ArticleImage mapRow(ResultSet rs, int row) throws SQLException {  
            ArticleImage e=new ArticleImage();  
            e.setId(rs.getInt(1));  
            e.setArticle_id(rs.getInt(2));  
            e.setCaption(rs.getString(3));  
            e.setArticle_img(rs.getString(4));           
            return e;  
            }  
        });  
    }

    @Override  
    public List<ArticleImage> getUnpublishedArticleImagesByArticleID(int artclID){  
    return template.query("select teamproject.article_images.* from teamproject.article_images INNER JOIN "
            + "teamproject.article on article_images.article_id = article.id where (article.is_saved=false and article.pub_date IS NULL AND article.id="+artclID+ ") ORDER BY article_images.id DESC",new RowMapper<ArticleImage>(){  
        
            public ArticleImage mapRow(ResultSet rs, int row) throws SQLException {  
            ArticleImage e=new ArticleImage();  
            e.setId(rs.getInt(1));  
            e.setArticle_id(rs.getInt(2));  
            e.setCaption(rs.getString(3));  
            e.setArticle_img(rs.getString(4));           
            return e;  
            }  
        });  
    }

    @Override  
    public List<ArticleImage> getPublishedArticleImagesByArticleID(int artclID){  
    return template.query("select teamproject.article_images.* from teamproject.article_images INNER JOIN "
            + "teamproject.article on article_images.article_id = article.id where (article.is_saved=false and article.pub_date IS NOT NULL AND article.id="+artclID+ ") ORDER BY article_images.id DESC",new RowMapper<ArticleImage>(){  
        
            public ArticleImage mapRow(ResultSet rs, int row) throws SQLException {  
            ArticleImage e=new ArticleImage();  
            e.setId(rs.getInt(1));  
            e.setArticle_id(rs.getInt(2));  
            e.setCaption(rs.getString(3));  
            e.setArticle_img(rs.getString(4));           
            return e;  
            }  
        });  
    }

    @Override  
    public List<ArticleImage> getSAVEDArticleImagesByArticleIDCreatorID(int artclID, int usrID){  
    return template.query("select teamproject.article_images.* from teamproject.article INNER JOIN "
            + "teamproject.article on article_images.article_id = article.id where (article.is_saved=true AND article.id="+artclID+ " AND article.creator_id ="+usrID+") ORDER BY article_images.id DESC",new RowMapper<ArticleImage>(){  
        
            public ArticleImage mapRow(ResultSet rs, int row) throws SQLException {  
            ArticleImage e=new ArticleImage();  
            e.setId(rs.getInt(1));  
            e.setArticle_id(rs.getInt(2));  
            e.setCaption(rs.getString(3));  
            e.setArticle_img(rs.getString(4));           
            return e;  
            }  
        });  
    }
    
    @Override
    public List<ArticleImage> getArticleImagesByArticleID(int artclID){  
    return template.query("select * from teamproject.article_images WHERE article_id="+artclID+"",new RowMapper<ArticleImage>(){  
        
            public ArticleImage mapRow(ResultSet rs, int row) throws SQLException {  
            ArticleImage e=new ArticleImage();  
            e.setId(rs.getInt(1));  
            e.setArticle_id(rs.getInt(2));  
            e.setCaption(rs.getString(3));  
            e.setArticle_img(rs.getString(4));           
            return e;  
            }  
        });  
    }    
    
    
    
}  