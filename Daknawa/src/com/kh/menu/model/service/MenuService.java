package com.kh.menu.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static com.kh.common.JDBCTemplate.*;

import com.kh.menu.model.dao.MenuDao;
import com.kh.menu.model.vo.Menu;

public class MenuService {
    
    public ArrayList<Menu> selectList() {
        // 1. 드라이버 등록
        Connection conn = getConnection();

        // 2. dao 메소드 호출
        ArrayList<Menu> list = new MenuDao().selectList(conn);

        // 3. 트랜잭션 처리
        close(conn);

        return list;
    }
}
