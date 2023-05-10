package ssafy.ws.trip.user.repository;

import java.sql.SQLException;
import java.util.List;

import ssafy.ws.trip.user.dto.UserDto;

public interface UserRepository {
	void insertUser(UserDto userDto) throws SQLException;
	UserDto selectOne(UserDto userDto) throws SQLException;
	UserDto getUserInfo(String userId) throws SQLException;
	void updateOne(UserDto userDto) throws SQLException;
	void deleteOne(String id) throws SQLException;
}
