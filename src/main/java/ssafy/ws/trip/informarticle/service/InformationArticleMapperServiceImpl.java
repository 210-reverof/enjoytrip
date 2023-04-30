package ssafy.ws.trip.informarticle.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssafy.ws.trip.informarticle.dto.InformArticleDto;
import ssafy.ws.trip.informarticle.respository.InformArticleRepository;

@Service
public class InformationArticleMapperServiceImpl implements InformArticleService{

	@Autowired
	private SqlSession session;
	
	@Override
	public void writeArticle(InformArticleDto informArticleDto) throws SQLException {
		session.getMapper(InformArticleRepository.class).writeArticle(informArticleDto);
	}

	@Override
	public List<InformArticleDto> listArticle() throws SQLException {
		return session.getMapper(InformArticleRepository.class).listArticle();
	}

	@Override
	public int getTotalArticleCount(Map<String, Object> param) throws SQLException {
		return session.getMapper(InformArticleRepository.class).getTotalArticleCount(param);
	}

	@Override
	public InformArticleDto getArticle(int articleNo) throws SQLException {
		return session.getMapper(InformArticleRepository.class).getArticle(articleNo);
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		session.getMapper(InformArticleRepository.class).updateHit(articleNo);
	}

	@Override
	public void modifyArticle(InformArticleDto InformArticleDto) throws SQLException {
		session.getMapper(InformArticleRepository.class).modifyArticle(InformArticleDto);
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		session.getMapper(InformArticleRepository.class).deleteArticle(articleNo);
	}
	

}

