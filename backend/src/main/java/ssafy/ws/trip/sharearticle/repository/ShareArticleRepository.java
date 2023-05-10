package ssafy.ws.trip.sharearticle.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ssafy.ws.trip.sharearticle.dto.ShareArticleDto;

@Mapper
public interface ShareArticleRepository {
	void writeArticle(ShareArticleDto sharearticle) throws SQLException;
	List<ShareArticleDto> listArticle(Map<String, Object> param) throws SQLException;
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	ShareArticleDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	
	void modifyArticle(ShareArticleDto sharearticle) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
}
