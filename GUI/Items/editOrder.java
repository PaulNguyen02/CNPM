package GUI.Items;

import java.util.ArrayList;

import javax.swing.JFrame;

import BLL.CTDN_BLL;
import BLL.DonNhan_BLL;
import DTO.CTDN_DTO;
import DTO.NV_DTO;

public class editOrder extends NewOrder {
    private CTDN_BLL ctdn_BLL = new CTDN_BLL();
    private DonNhan_BLL donNhan_BLL = new DonNhan_BLL();
    private ArrayList<CTDN_DTO> oldInputs = new ArrayList<>();
    public editOrder(NV_DTO worker, String ID){
        super(worker);
        btn_Save.setEnabled(true);
        btn_Save.setText("Lưu");
        orderDetails = ctdn_BLL.pullData(ID);
        oldInputs = ctdn_BLL.pullData(ID);
        Order = donNhan_BLL.getData(ID);
        rebuildTable();
    }
    @Override
    public void saveDataEvent() {
        Order.setTong(Total_Price);
        donNhan_BLL.updateData(Order);
        ctdn_BLL.updateData(oldInputs, orderDetails, Order.getMadn());

        MyMessageAlert alert = new MyMessageAlert(new JFrame(), "Lưu thành công");
        alert.setVisible(true);
        dispose();
    }
}
