package ssafy.ws.trip.informarticle.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ssafy.ws.trip.informarticle.dto.InformArticleDto;

@Mapper
public interface InformArticleRepository {
	void writeArticle(InformArticleDto informArticleDto) throws SQLException;
//	List<InformArticleDto> listArticle(Map<String, Object> param) throws SQLException;
	List<InformArticleDto> listArticle(Map<String, Object> map) throws SQLException;
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	InformArticleDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	
	void modifyArticle(InformArticleDto InformArticleDto) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
}
