package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.semi.youtube.model.vo.VideoLike;

@Mapper
public interface VideoLikeMapper {

	void like(VideoLike vo);
//	INSERT INTO video_like(id, video_code) VALUES (#{id}, #{videoCode})
	
	VideoLike check(VideoLike vo);
//	SELECT * FROM video_like
//	WHERE id = #{id} AND video_code = #{videoCode}
	
	void unlike(int code);
//	DELETE FROM video_like WHERE like_code = #{code}
}
