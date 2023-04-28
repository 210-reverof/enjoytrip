package ssafy.ws.trip.informarticle.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import ssafy.ws.trip.informarticle.dto.InformArticleDto;

public interface InformArticleService {
	void writeArticle(InformArticleDto informArticleDto) throws SQLException;
//	List<InformArticleDto> listArticle(Map<String, Object> param) throws SQLException;
	List<InformArticleDto> listArticle() throws SQLException;
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	InformArticleDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	
	void modifyArticle(InformArticleDto InformArticleDto) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
}
