package com.kh.post.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;
import com.kh.post.model.vo.Post;

public class PostDao {

    private Properties prop = new Properties();
	
	public PostDao() {
		String fileName = PostDao.class.getResource("/sql/post/post-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectReviewListCount(Connection conn) {
		
        int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset =  null;
		String sql = prop.getProperty("selectReviewListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	public ArrayList<Post> selectReviewList(Connection conn, PageInfo pi) {
		
        ArrayList<Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getPostLimit() + 1;
		int endRow = startRow + pi.getPostLimit() - 1;
		
		System.out.println(startRow);
		System.out.println(endRow);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Post po = new Post();

                po.setPostNo(rset.getInt("POST_NO"));
                po.setPostTitle(rset.getString("POST_TITLE"));
                po.setPostContent(rset.getString("POST_CONTENT"));
                po.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
                po.setPostView(rset.getInt("POST_VIEW"));
                po.setPostDate(rset.getDate("POST_DATE"));
				
				list.add(po);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

    public int increaseCount(Connection conn, int postNum) {
        
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("increaseCount");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, postNum);
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

	public Post selectPost(Connection conn, int postNo) {
		
		Post p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Post();
				
				p.setPostNo(rset.getInt("POST_NO"));
				p.setPostTitle(rset.getString("POST_TITLE"));
				p.setPostContent(rset.getString("POST_CONTENT"));
				p.setMemberNickname(rset.getString("MEMBER_NICKNAME"));
				p.setPostView(rset.getInt("POST_VIEW"));
				p.setPostDate(rset.getDate("POST_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return p;
	}

	public Attachment selectAttachment(Connection conn, int postNo) {
		
		Attachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				at = new Attachment();
				
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFileDate(rset.getDate("FILE_DATE"));
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setFileLevel(rset.getInt("FILE_LEVEL"));
				at.setPostNo(rset.getInt("POST_NO"));
				at.setStatus(rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return at;
	}

	public ArrayList<Attachment> selectAttachmentList(Connection conn, int boardNo) {
		
		ArrayList<Attachment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		// 일반게시판 상세조회 요청 시 썼던 쿼리문 재활용
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();

			list = new ArrayList<>();

			while(rset.next()) {

				Attachment at = new Attachment();

				// 만약 게시글 수정 시 파일도 같이 변경하고 싶다면 FILE_NO 을 가져오는 것이 좋음
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
				//=> 단순히 이미지만 노출시키고 말 경우에는 원본 파일명까진 필요 없음!!

				list.add(at);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

}
