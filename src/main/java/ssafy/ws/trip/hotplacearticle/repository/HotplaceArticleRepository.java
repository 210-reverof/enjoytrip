package ssafy.ws.trip.hotplacearticle.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ssafy.ws.trip.hotplacearticle.dto.HotplaceArticleDto;
import ssafy.ws.trip.informarticle.dto.InformArticleDto;

@Mapper
public interface HotplaceArticleRepository {
	void writeArticle(HotplaceArticleDto hotplaceArticleDto) throws SQLException;
//	List<InformArticleDto> listArticle(Map<String, Object> param) throws SQLException;
	List<HotplaceArticleDto> listArticle(Map<String, Object> map) throws SQLException;
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	HotplaceArticleDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	
	void modifyArticle(HotplaceArticleDto hotplaceArticleDto) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
}
