package com.kh.menu.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.kh.common.JDBCTemplate.*;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.menu.model.vo.Menu;

public class MenuDao {

    private Properties prop = new Properties();

    public MenuDao() {
        String fileName = MenuDao.class.getResource("/sql/menu/menu-mapper.xml").getPath();

        try {
            prop.loadFromXML(new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Menu> selectList(Connection conn) {
        ArrayList<Menu> list = new ArrayList<Menu>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        String sql = prop.getProperty("selectMenulList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                list.add(new Menu(rset.getInt("MENU_NO"),
                                  rset.getString("MENU_NAME"),
                                  rset.getInt("MENU_PRICE")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return list;
    }
}
