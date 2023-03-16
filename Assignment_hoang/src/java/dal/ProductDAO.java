/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import modelAdmin.Category;
import modelAdmin.Collection;
import modelAdmin.Product;
import modelAdmin.ProductImage;
import modelAdmin.ProductSize;

/**
 *
 * @author GearVn
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getAll() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT p.[ProductCode]\n"
                + "      ,p.[ProductName]\n"
                + "      ,p.[CategoryID]\n"
                + "      ,p.[Price]\n"
                + "      ,p.[Description]\n"
                + "      ,p.[Status]\n"
                + "      ,p.[Gender]\n"
                + "      ,p.[CollectionID]\n"
                + "      ,p.[Quantity]\n"
                + "      ,p.[Style]\n"
                + "      ,p.[DetailProduct]\n"
                + "	 ,pim.[image1]\n"
                + "      ,pim.[image2]\n"
                + "      ,pim.[image3]\n"
                + "	 ,ps.[size1]\n"
                + "      ,ps.[size2]\n"
                + "      ,ps.[size3]\n"
                + "      ,ps.[size4]\n"
                + "      ,ps.[size5]\n"
                + "      ,ps.[size6]\n"
                + "      ,ps.[size7]\n"
                + "      ,ps.[size8]\n"
                + "      ,ps.[size9]\n"
                + "      ,ps.[size10]\n"
                + "      ,ps.[size11]\n"
                + "      ,ps.[size12]\n"
                + "	  ,cl.[CollectionName]\n"
                + "      ,cl.[CollectionImage]\n"
                + "	  ,c.[CategoryName]\n"
                + "  FROM [ananas].[dbo].[Products] p FULL outer join [ananas].[dbo].Categories c\n"
                + "  on p.CategoryID = c.ID FULL outer join [ananas].[dbo].ProductImages pim\n"
                + "  on p.ProductCode = pim.ProductCode FULL outer join [ananas].[dbo].ProductSize ps\n"
                + "  on p.ProductCode = ps.ProductCode FULL outer join [ananas].[dbo].Collections cl\n"
                + "  on p.CollectionID = cl.ID ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductImage pim = new ProductImage(rs.getString("ProductCode"), rs.getString("image1"), rs.getString("image2"), rs.getString("image3"));

                ProductSize ps = new ProductSize(rs.getString("ProductCode"), rs.getString("size1"), rs.getString("size2"), rs.getString("size3"),
                        rs.getString("size4"), rs.getString("size5"), rs.getString("size6"), rs.getString("size7"), rs.getString("size8"),
                        rs.getString("size9"), rs.getString("size10"), rs.getString("size11"), rs.getString("size12"));

                Collection cl = new Collection(rs.getInt("CollectionID"), rs.getString("CollectionName"), rs.getString("CollectionImage"));

                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"));

                Product p = new Product(rs.getString("ProductCode"), rs.getString("ProductName"), rs.getDouble("Price"), rs.getString("Description"),
                        rs.getString("Status"), rs.getInt("Gender"), rs.getInt("Quantity"), rs.getString("Style"), rs.getString("DetailProduct"),
                        pim, ps, cl, c);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getProductByCategoryID(int categoryID) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT p.[ProductCode]\n"
                + "      ,p.[ProductName]\n"
                + "      ,p.[CategoryID]\n"
                + "      ,p.[Price]\n"
                + "      ,p.[Description]\n"
                + "      ,p.[Status]\n"
                + "      ,p.[Gender]\n"
                + "      ,p.[CollectionID]\n"
                + "      ,p.[Quantity]\n"
                + "      ,p.[Style]\n"
                + "      ,p.[DetailProduct]\n"
                + "	 ,pim.[image1]\n"
                + "      ,pim.[image2]\n"
                + "      ,pim.[image3]\n"
                + "	 ,ps.[size1]\n"
                + "      ,ps.[size2]\n"
                + "      ,ps.[size3]\n"
                + "      ,ps.[size4]\n"
                + "      ,ps.[size5]\n"
                + "      ,ps.[size6]\n"
                + "      ,ps.[size7]\n"
                + "      ,ps.[size8]\n"
                + "      ,ps.[size9]\n"
                + "      ,ps.[size10]\n"
                + "      ,ps.[size11]\n"
                + "      ,ps.[size12]\n"
                + "	  ,cl.[CollectionName]\n"
                + "      ,cl.[CollectionImage]\n"
                + "	  ,c.[CategoryName]\n"
                + "  FROM [ananas].[dbo].[Products] p FULL outer join [ananas].[dbo].Categories c\n"
                + "  on p.CategoryID = c.ID FULL outer join [ananas].[dbo].ProductImages pim\n"
                + "  on p.ProductCode = pim.ProductCode FULL outer join [ananas].[dbo].ProductSize ps\n"
                + "  on p.ProductCode = ps.ProductCode FULL outer join [ananas].[dbo].Collections cl\n"
                + "  on p.CollectionID = cl.ID \n"
                + " WHERE 1=1";
        try {
            if (categoryID != 0) {
                sql += " AND p.categoryID = " + categoryID;
            }
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductImage pim = new ProductImage(rs.getString("ProductCode"), rs.getString("image1"), rs.getString("image2"), rs.getString("image3"));

                ProductSize ps = new ProductSize(rs.getString("ProductCode"), rs.getString("size1"), rs.getString("size2"), rs.getString("size3"),
                        rs.getString("size4"), rs.getString("size5"), rs.getString("size6"), rs.getString("size7"), rs.getString("size8"),
                        rs.getString("size9"), rs.getString("size10"), rs.getString("size11"), rs.getString("size12"));

                Collection cl = new Collection(rs.getInt("CollectionID"), rs.getString("CollectionName"), rs.getString("CollectionImage"));

                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"));

                Product p = new Product(rs.getString("ProductCode"), rs.getString("ProductName"), rs.getDouble("Price"), rs.getString("Description"),
                        rs.getString("Status"), rs.getInt("Gender"), rs.getInt("Quantity"), rs.getString("Style"), rs.getString("DetailProduct"),
                        pim, ps, cl, c);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getProductByCollectID(int[] collectionID) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT p.[ProductCode]\n"
                + "      ,p.[ProductName]\n"
                + "      ,p.[CategoryID]\n"
                + "      ,p.[Price]\n"
                + "      ,p.[Description]\n"
                + "      ,p.[Status]\n"
                + "      ,p.[Gender]\n"
                + "      ,p.[CollectionID]\n"
                + "      ,p.[Quantity]\n"
                + "      ,p.[Style]\n"
                + "      ,p.[DetailProduct]\n"
                + "	 ,pim.[image1]\n"
                + "      ,pim.[image2]\n"
                + "      ,pim.[image3]\n"
                + "	 ,ps.[size1]\n"
                + "      ,ps.[size2]\n"
                + "      ,ps.[size3]\n"
                + "      ,ps.[size4]\n"
                + "      ,ps.[size5]\n"
                + "      ,ps.[size6]\n"
                + "      ,ps.[size7]\n"
                + "      ,ps.[size8]\n"
                + "      ,ps.[size9]\n"
                + "      ,ps.[size10]\n"
                + "      ,ps.[size11]\n"
                + "      ,ps.[size12]\n"
                + "	  ,cl.[CollectionName]\n"
                + "      ,cl.[CollectionImage]\n"
                + "	  ,c.[CategoryName]\n"
                + "  FROM [ananas].[dbo].[Products] p FULL outer join [ananas].[dbo].Categories c\n"
                + "  on p.CategoryID = c.ID FULL outer join [ananas].[dbo].ProductImages pim\n"
                + "  on p.ProductCode = pim.ProductCode FULL outer join [ananas].[dbo].ProductSize ps\n"
                + "  on p.ProductCode = ps.ProductCode FULL outer join [ananas].[dbo].Collections cl\n"
                + "  on p.CollectionID = cl.ID \n"
                + " WHERE 1=1";
        try {
            if (collectionID != null) {
                sql += " AND p.CollectionID IN ( ";
                for (int i = 0; i < collectionID.length; i++) {
                    if (i == collectionID.length - 1) {
                        sql += collectionID[i] + " )";
                    } else {
                        sql += collectionID[i] + ", ";
                    }
                }
            }
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductImage pim = new ProductImage(rs.getString("ProductCode"), rs.getString("image1"), rs.getString("image2"), rs.getString("image3"));

                ProductSize ps = new ProductSize(rs.getString("ProductCode"), rs.getString("size1"), rs.getString("size2"), rs.getString("size3"),
                        rs.getString("size4"), rs.getString("size5"), rs.getString("size6"), rs.getString("size7"), rs.getString("size8"),
                        rs.getString("size9"), rs.getString("size10"), rs.getString("size11"), rs.getString("size12"));

                Collection cl = new Collection(rs.getInt("CollectionID"), rs.getString("CollectionName"), rs.getString("CollectionImage"));

                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"));

                Product p = new Product(rs.getString("ProductCode"), rs.getString("ProductName"), rs.getDouble("Price"), rs.getString("Description"),
                        rs.getString("Status"), rs.getInt("Gender"), rs.getInt("Quantity"), rs.getString("Style"), rs.getString("DetailProduct"),
                        pim, ps, cl, c);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getProductBySearch(String search) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT p.[ProductCode]\n"
                + "      ,p.[ProductName]\n"
                + "      ,p.[CategoryID]\n"
                + "      ,p.[Price]\n"
                + "      ,p.[Description]\n"
                + "      ,p.[Status]\n"
                + "      ,p.[Gender]\n"
                + "      ,p.[CollectionID]\n"
                + "      ,p.[Quantity]\n"
                + "      ,p.[Style]\n"
                + "      ,p.[DetailProduct]\n"
                + "	 ,pim.[image1]\n"
                + "      ,pim.[image2]\n"
                + "      ,pim.[image3]\n"
                + "	 ,ps.[size1]\n"
                + "      ,ps.[size2]\n"
                + "      ,ps.[size3]\n"
                + "      ,ps.[size4]\n"
                + "      ,ps.[size5]\n"
                + "      ,ps.[size6]\n"
                + "      ,ps.[size7]\n"
                + "      ,ps.[size8]\n"
                + "      ,ps.[size9]\n"
                + "      ,ps.[size10]\n"
                + "      ,ps.[size11]\n"
                + "      ,ps.[size12]\n"
                + "	  ,cl.[CollectionName]\n"
                + "      ,cl.[CollectionImage]\n"
                + "	  ,c.[CategoryName]\n"
                + "  FROM [ananas].[dbo].[Products] p FULL outer join [ananas].[dbo].Categories c\n"
                + "  on p.CategoryID = c.ID FULL outer join [ananas].[dbo].ProductImages pim\n"
                + "  on p.ProductCode = pim.ProductCode FULL outer join [ananas].[dbo].ProductSize ps\n"
                + "  on p.ProductCode = ps.ProductCode FULL outer join [ananas].[dbo].Collections cl\n"
                + "  on p.CollectionID = cl.ID \n"
                + " WHERE 1=1";
        try {
            if (search != null) {
                sql += " AND c.CategoryName like '%" + search + "%' OR p.ProductName like '%" + search + "%'";
            }
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductImage pim = new ProductImage(rs.getString("ProductCode"), rs.getString("image1"), rs.getString("image2"), rs.getString("image3"));

                ProductSize ps = new ProductSize(rs.getString("ProductCode"), rs.getString("size1"), rs.getString("size2"), rs.getString("size3"),
                        rs.getString("size4"), rs.getString("size5"), rs.getString("size6"), rs.getString("size7"), rs.getString("size8"),
                        rs.getString("size9"), rs.getString("size10"), rs.getString("size11"), rs.getString("size12"));

                Collection cl = new Collection(rs.getInt("CollectionID"), rs.getString("CollectionName"), rs.getString("CollectionImage"));

                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"));

                Product p = new Product(rs.getString("ProductCode"), rs.getString("ProductName"), rs.getDouble("Price"), rs.getString("Description"),
                        rs.getString("Status"), rs.getInt("Gender"), rs.getInt("Quantity"), rs.getString("Style"), rs.getString("DetailProduct"),
                        pim, ps, cl, c);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getProductByStatus(String status) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT p.[ProductCode]\n"
                + "      ,p.[ProductName]\n"
                + "      ,p.[CategoryID]\n"
                + "      ,p.[Price]\n"
                + "      ,p.[Description]\n"
                + "      ,p.[Status]\n"
                + "      ,p.[Gender]\n"
                + "      ,p.[CollectionID]\n"
                + "      ,p.[Quantity]\n"
                + "      ,p.[Style]\n"
                + "      ,p.[DetailProduct]\n"
                + "	 ,pim.[image1]\n"
                + "      ,pim.[image2]\n"
                + "      ,pim.[image3]\n"
                + "	 ,ps.[size1]\n"
                + "      ,ps.[size2]\n"
                + "      ,ps.[size3]\n"
                + "      ,ps.[size4]\n"
                + "      ,ps.[size5]\n"
                + "      ,ps.[size6]\n"
                + "      ,ps.[size7]\n"
                + "      ,ps.[size8]\n"
                + "      ,ps.[size9]\n"
                + "      ,ps.[size10]\n"
                + "      ,ps.[size11]\n"
                + "      ,ps.[size12]\n"
                + "	  ,cl.[CollectionName]\n"
                + "      ,cl.[CollectionImage]\n"
                + "	  ,c.[CategoryName]\n"
                + "  FROM [ananas].[dbo].[Products] p FULL outer join [ananas].[dbo].Categories c\n"
                + "  on p.CategoryID = c.ID FULL outer join [ananas].[dbo].ProductImages pim\n"
                + "  on p.ProductCode = pim.ProductCode FULL outer join [ananas].[dbo].ProductSize ps\n"
                + "  on p.ProductCode = ps.ProductCode FULL outer join [ananas].[dbo].Collections cl\n"
                + "  on p.CollectionID = cl.ID \n"
                + " WHERE 1=1";
        try {
            if (status != null) {
                sql += " AND p.Status like '%" + status + "%'";
            }
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductImage pim = new ProductImage(rs.getString("ProductCode"), rs.getString("image1"), rs.getString("image2"), rs.getString("image3"));

                ProductSize ps = new ProductSize(rs.getString("ProductCode"), rs.getString("size1"), rs.getString("size2"), rs.getString("size3"),
                        rs.getString("size4"), rs.getString("size5"), rs.getString("size6"), rs.getString("size7"), rs.getString("size8"),
                        rs.getString("size9"), rs.getString("size10"), rs.getString("size11"), rs.getString("size12"));

                Collection cl = new Collection(rs.getInt("CollectionID"), rs.getString("CollectionName"), rs.getString("CollectionImage"));

                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"));

                Product p = new Product(rs.getString("ProductCode"), rs.getString("ProductName"), rs.getDouble("Price"), rs.getString("Description"),
                        rs.getString("Status"), rs.getInt("Gender"), rs.getInt("Quantity"), rs.getString("Style"), rs.getString("DetailProduct"),
                        pim, ps, cl, c);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getTop5ProductByStatus(String status) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT top(5) p.[ProductCode]\n"
                + "      ,p.[ProductName]\n"
                + "      ,p.[CategoryID]\n"
                + "      ,p.[Price]\n"
                + "      ,p.[Description]\n"
                + "      ,p.[Status]\n"
                + "      ,p.[Gender]\n"
                + "      ,p.[CollectionID]\n"
                + "      ,p.[Quantity]\n"
                + "      ,p.[Style]\n"
                + "      ,p.[DetailProduct]\n"
                + "	 ,pim.[image1]\n"
                + "      ,pim.[image2]\n"
                + "      ,pim.[image3]\n"
                + "	 ,ps.[size1]\n"
                + "      ,ps.[size2]\n"
                + "      ,ps.[size3]\n"
                + "      ,ps.[size4]\n"
                + "      ,ps.[size5]\n"
                + "      ,ps.[size6]\n"
                + "      ,ps.[size7]\n"
                + "      ,ps.[size8]\n"
                + "      ,ps.[size9]\n"
                + "      ,ps.[size10]\n"
                + "      ,ps.[size11]\n"
                + "      ,ps.[size12]\n"
                + "	  ,cl.[CollectionName]\n"
                + "      ,cl.[CollectionImage]\n"
                + "	  ,c.[CategoryName]\n"
                + "  FROM [ananas].[dbo].[Products] p FULL outer join [ananas].[dbo].Categories c\n"
                + "  on p.CategoryID = c.ID FULL outer join [ananas].[dbo].ProductImages pim\n"
                + "  on p.ProductCode = pim.ProductCode FULL outer join [ananas].[dbo].ProductSize ps\n"
                + "  on p.ProductCode = ps.ProductCode FULL outer join [ananas].[dbo].Collections cl\n"
                + "  on p.CollectionID = cl.ID \n"
                + " WHERE 1=1";
        try {
            if (status != null) {
                sql += " AND p.Status like '%" + status + "%'";
            }
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductImage pim = new ProductImage(rs.getString("ProductCode"), rs.getString("image1"), rs.getString("image2"), rs.getString("image3"));

                ProductSize ps = new ProductSize(rs.getString("ProductCode"), rs.getString("size1"), rs.getString("size2"), rs.getString("size3"),
                        rs.getString("size4"), rs.getString("size5"), rs.getString("size6"), rs.getString("size7"), rs.getString("size8"),
                        rs.getString("size9"), rs.getString("size10"), rs.getString("size11"), rs.getString("size12"));

                Collection cl = new Collection(rs.getInt("CollectionID"), rs.getString("CollectionName"), rs.getString("CollectionImage"));

                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"));

                Product p = new Product(rs.getString("ProductCode"), rs.getString("ProductName"), rs.getDouble("Price"), rs.getString("Description"),
                        rs.getString("Status"), rs.getInt("Gender"), rs.getInt("Quantity"), rs.getString("Style"), rs.getString("DetailProduct"),
                        pim, ps, cl, c);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Product> getTop5ProductByGender(int gender) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT top(5) p.[ProductCode]\n"
                + "      ,p.[ProductName]\n"
                + "      ,p.[CategoryID]\n"
                + "      ,p.[Price]\n"
                + "      ,p.[Description]\n"
                + "      ,p.[Status]\n"
                + "      ,p.[Gender]\n"
                + "      ,p.[CollectionID]\n"
                + "      ,p.[Quantity]\n"
                + "      ,p.[Style]\n"
                + "      ,p.[DetailProduct]\n"
                + "	 ,pim.[image1]\n"
                + "      ,pim.[image2]\n"
                + "      ,pim.[image3]\n"
                + "	 ,ps.[size1]\n"
                + "      ,ps.[size2]\n"
                + "      ,ps.[size3]\n"
                + "      ,ps.[size4]\n"
                + "      ,ps.[size5]\n"
                + "      ,ps.[size6]\n"
                + "      ,ps.[size7]\n"
                + "      ,ps.[size8]\n"
                + "      ,ps.[size9]\n"
                + "      ,ps.[size10]\n"
                + "      ,ps.[size11]\n"
                + "      ,ps.[size12]\n"
                + "	  ,cl.[CollectionName]\n"
                + "      ,cl.[CollectionImage]\n"
                + "	  ,c.[CategoryName]\n"
                + "  FROM [ananas].[dbo].[Products] p FULL outer join [ananas].[dbo].Categories c\n"
                + "  on p.CategoryID = c.ID FULL outer join [ananas].[dbo].ProductImages pim\n"
                + "  on p.ProductCode = pim.ProductCode FULL outer join [ananas].[dbo].ProductSize ps\n"
                + "  on p.ProductCode = ps.ProductCode FULL outer join [ananas].[dbo].Collections cl\n"
                + "  on p.CollectionID = cl.ID \n"
                + " WHERE 1=1";
        try {
            if (gender != -1) {
                sql += " AND p.Gender =" + gender;
            }
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductImage pim = new ProductImage(rs.getString("ProductCode"), rs.getString("image1"), rs.getString("image2"), rs.getString("image3"));

                ProductSize ps = new ProductSize(rs.getString("ProductCode"), rs.getString("size1"), rs.getString("size2"), rs.getString("size3"),
                        rs.getString("size4"), rs.getString("size5"), rs.getString("size6"), rs.getString("size7"), rs.getString("size8"),
                        rs.getString("size9"), rs.getString("size10"), rs.getString("size11"), rs.getString("size12"));

                Collection cl = new Collection(rs.getInt("CollectionID"), rs.getString("CollectionName"), rs.getString("CollectionImage"));

                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"));

                Product p = new Product(rs.getString("ProductCode"), rs.getString("ProductName"), rs.getDouble("Price"), rs.getString("Description"),
                        rs.getString("Status"), rs.getInt("Gender"), rs.getInt("Quantity"), rs.getString("Style"), rs.getString("DetailProduct"),
                        pim, ps, cl, c);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getProductByProductCode(String productCode) {
        String sql = "SELECT p.[ProductCode]\n"
                + "      ,p.[ProductName]\n"
                + "      ,p.[CategoryID]\n"
                + "      ,p.[Price]\n"
                + "      ,p.[Description]\n"
                + "      ,p.[Status]\n"
                + "      ,p.[Gender]\n"
                + "      ,p.[CollectionID]\n"
                + "      ,p.[Quantity]\n"
                + "      ,p.[Style]\n"
                + "      ,p.[DetailProduct]\n"
                + "	 ,pim.[image1]\n"
                + "      ,pim.[image2]\n"
                + "      ,pim.[image3]\n"
                + "	 ,ps.[size1]\n"
                + "      ,ps.[size2]\n"
                + "      ,ps.[size3]\n"
                + "      ,ps.[size4]\n"
                + "      ,ps.[size5]\n"
                + "      ,ps.[size6]\n"
                + "      ,ps.[size7]\n"
                + "      ,ps.[size8]\n"
                + "      ,ps.[size9]\n"
                + "      ,ps.[size10]\n"
                + "      ,ps.[size11]\n"
                + "      ,ps.[size12]\n"
                + "	  ,cl.[CollectionName]\n"
                + "      ,cl.[CollectionImage]\n"
                + "	  ,c.[CategoryName]\n"
                + "  FROM [ananas].[dbo].[Products] p FULL outer join [ananas].[dbo].Categories c\n"
                + "  on p.CategoryID = c.ID FULL outer join [ananas].[dbo].ProductImages pim\n"
                + "  on p.ProductCode = pim.ProductCode FULL outer join [ananas].[dbo].ProductSize ps\n"
                + "  on p.ProductCode = ps.ProductCode FULL outer join [ananas].[dbo].Collections cl\n"
                + "  on p.CollectionID = cl.ID \n"
                + " WHERE 1=1";
        try {
            if (productCode != null) {
                sql += " AND p.[ProductCode] = '" + productCode + "'";
            }
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductImage pim = new ProductImage(rs.getString("ProductCode"), rs.getString("image1"), rs.getString("image2"), rs.getString("image3"));

                ProductSize ps = new ProductSize(rs.getString("ProductCode"), rs.getString("size1"), rs.getString("size2"), rs.getString("size3"),
                        rs.getString("size4"), rs.getString("size5"), rs.getString("size6"), rs.getString("size7"), rs.getString("size8"),
                        rs.getString("size9"), rs.getString("size10"), rs.getString("size11"), rs.getString("size12"));

                Collection cl = new Collection(rs.getInt("CollectionID"), rs.getString("CollectionName"), rs.getString("CollectionImage"));

                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"));

                Product p = new Product(rs.getString("ProductCode"), rs.getString("ProductName"), rs.getDouble("Price"), rs.getString("Description"),
                        rs.getString("Status"), rs.getInt("Gender"), rs.getInt("Quantity"), rs.getString("Style"), rs.getString("DetailProduct"),
                        pim, ps, cl, c);

                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int getCategoryByProductCode(String ProductCode) {
        try {
            String sql = "SELECT \n"
                    + "      [CategoryID]\n"
                    + "  FROM [ananas].[dbo].[Product]\n"
                    + "  WHERE productCode = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, ProductCode);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public List<Product> getListByPage(List<Product> list, int start, int end) {
        List<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public int getQuantityForChart(int categoryID) {
        try {
            String sql = "SELECT sum(quantity)\n"
                    + "  FROM [ananas].[dbo].[Products]\n"
                    + "  where CategoryID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, categoryID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public int getQuantityAll() {
        try {
            String sql = "SELECT sum(quantity)\n"
                    + "  FROM [ananas].[dbo].[Products]\n";
            PreparedStatement st = connection.prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

}
