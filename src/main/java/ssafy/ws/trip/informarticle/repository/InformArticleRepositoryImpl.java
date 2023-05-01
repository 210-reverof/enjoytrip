package ssafy.ws.trip.informarticle.repository;
//package ssafy.ws.trip.informarticle.respository;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import ssafy.ws.trip.informarticle.dto.InformArticleDto;
//
//@Repository("InformArticleRepositoryImpl")
//public class InformArticleRepositoryImpl implements InformArticleRepository{
//	 @Autowired
//	    SqlSession session;
//	    String ns = "ssafy.ws.trip.informarticle.repository.InformArticleRepository.";
//	    
//	@Override
//	public List<InformArticleDto> listArticle() throws SQLException {
//		return session.selectList(ns+"listArticle");
//	}
//	
//
//}
