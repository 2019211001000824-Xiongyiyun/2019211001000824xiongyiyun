package com.xiongyiyun.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;
    private Boolean active;

    public Category() {
    }

    public Category(String categoryName, String description, Boolean active) {
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static List<Category> findAllCategory(Connection con) {
        String dbRequire="select * from Category";
        List<Category> list=new ArrayList<Category>();
        try{
            PreparedStatement st=con.prepareStatement(dbRequire);
            ResultSet resultDb=st.executeQuery();
            while(resultDb.next()) {
                Category c=new Category();
                c.setCategoryId(resultDb.getInt("CategoryId"));
                System.out.println(resultDb.getInt("CategoryId"));
                c.setCategoryName(resultDb.getString("CategoryName"));
                c.setDescription(resultDb.getString("Description"));
                list.add(c);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static  String findByCategoryId(Connection con,int categoryId) throws SQLException {
        String categoryName=null;
        try{
            String dbRequire="select CategoryName from Category where CategoryId=?";
            PreparedStatement st=con.prepareStatement(dbRequire);
            st.setInt(1,categoryId);
            ResultSet resultDb=st.executeQuery();
            if(resultDb.next()) {
                categoryName=resultDb.getString("CategoryName");
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return categoryName;
    }
}