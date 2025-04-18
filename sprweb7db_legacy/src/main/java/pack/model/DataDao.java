package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class DataDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Autowired
    private MyDataSource dataSource;

    public DataDao() {

    }

    public ArrayList<SanpumDto> getDataAll() {
        ArrayList<SanpumDto> list = new ArrayList<>();

        try {
            String sql = "select * from sangdata";
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                SanpumDto dto = new SanpumDto();
                dto.setCode(rs.getString("code"));
                dto.setSang(rs.getString("sang"));
                dto.setSu(rs.getString("su"));
                dto.setDan(rs.getString("dan"));
                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("getDataAll err : " + e.getMessage());
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (Exception e2) {
                System.out.println("closing connection err : " + e2.getMessage());
            }
        }

        return list;
    }
}
