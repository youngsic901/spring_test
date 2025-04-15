package pack.model;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Service
public class SangpumImpl implements SangpumInter {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public SangpumImpl() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패 : " + e);
        }
    }

    @Override
    public ArrayList<SangpumDto> selectList() {
        ArrayList<SangpumDto> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
            pstmt = conn.prepareStatement("select * from sangdata");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                SangpumDto dto = new SangpumDto();
                dto.setCode(rs.getString("code"));
                dto.setSang(rs.getString("sang"));
                dto.setSu(rs.getString("su"));
                dto.setDan(rs.getString("dan"));
                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("selectList err : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e2) {
                System.out.println("closing err : " + e2);
            }
        }

        return list;
    }
}
