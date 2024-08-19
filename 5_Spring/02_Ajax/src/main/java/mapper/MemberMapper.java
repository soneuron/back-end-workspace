package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.ajax.model.vo.Member;

@Mapper
public interface MemberMapper {

	Member idCheck(String id);
//	<select id="idCheck" parameterType="String" resultType="Member"> 
	
	void register(Member vo); // insert = return값이 없음 따라서 [void]
//	Member serialize(String id, String password, String name);
//	<insert id="register" parameterType="Member">
}
