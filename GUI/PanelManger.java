package GUI;

import javax.swing.JTabbedPane;

import DTO.NV_DTO;
import DTO.NV_DTO.role;
import GUI.Items.PanelChangePasswd;
import Phuc.KhuyenMai;
import Phuc.Nhanvien;

public class PanelManger extends JTabbedPane{
    
    private PanelChangePasswd passwd;
    private Nhanvien UserManger = new Nhanvien();
    private KhuyenMai discount = new KhuyenMai();

    public PanelManger(NV_DTO user){
        passwd = new PanelChangePasswd(user);

        addTab("Đổi mật khẩu", passwd);
        addTab("QL Nhân Viên", UserManger);
        addTab("Khuyến mãi", discount);
        if (user.getRole() != role.Manager){
            setEnabledAt(1, false);
            setEnabledAt(2, false);
        }

    }
}
