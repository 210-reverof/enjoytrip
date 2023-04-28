package ssafy.ws.trip.informarticle.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ssafy.ws.trip.informarticle.dto.InformArticleDto;
import ssafy.ws.trip.informarticle.respository.InformArticleRepository;

@Service
public class InformationArticleServiceImpl implements InformArticleService{
	
	private InformArticleRepository informArticleRepository;

	public InformationArticleServiceImpl(InformArticleRepository informArticleRepository) {
		super();
		this.informArticleRepository = informArticleRepository;
	}

	@Override
	public void writeArticle(InformArticleDto informArticleDto) throws SQLException {
		informArticleRepository.writeArticle(informArticleDto);
	}

	@Override
	public List<InformArticleDto> listArticle() throws SQLException {
		return informArticleRepository.listArticle();
	}

	@Override
	public int getTotalArticleCount(Map<String, Object> param) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public InformArticleDto getArticle(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		return informArticleRepository.getArticle(articleNo);
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyArticle(InformArticleDto InformArticleDto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
